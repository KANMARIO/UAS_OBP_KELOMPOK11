package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Dokter;
import com.example.demospringboot.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DokterController {

    @Autowired
    private DokterService dokterService;

    // Display the doctor page with a list of all doctors and a form for adding a new one
    @GetMapping("/dokter")
    public String dokterpage(Model model) {
        model.addAttribute("dokList", dokterService.getAllDok());
        model.addAttribute("dokInfo", new Dokter());  // form for new doctor
        return "dokter.html";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";  // Ensure you have the admin.html in the templates folder
    }

    // Get details of a specific doctor by ID
    @GetMapping("/dokter/{id}")
    public String dokterGetRec(Model model, @PathVariable("id") int id) {
        model.addAttribute("dokList", dokterService.getAllDok());
        model.addAttribute("dokRec", dokterService.getDokById(id));
        return "dokter.html";
    }

    // @PostMapping(value = "/dokter/submit", params = {"add"})
    // public String dokterAdd(Model model, @ModelAttribute("dokInfo") Dokter dokInfo) {
    //     dokterService.addDok(dokInfo);
    //     return "redirect:/dokter";  // Redirect to list of all doctors
    // }
    
    @PostMapping(value = "/dokter/submit", params = {"add"})
    public String dokterAdd(Model model, @ModelAttribute("dokInfo") Dokter dokInfo, RedirectAttributes redirectAttributes) {
    dokterService.addDok(dokInfo);
    dokInfo.Notifikasi();  // Panggil metode Notifikasi (opsional untuk logging)
    redirectAttributes.addFlashAttribute("message", "Dokter berhasil ditambahkan!");
    return "redirect:/dokter";  // Redirect to list of all doctors
    }


    @PostMapping(value = "/dokter/submit/{id}", params = {"delete"})
    public String dokterDelete(Model model, @PathVariable("id") int id) {
        dokterService.deleteDok(id);
        return "redirect:/dokter";  // Redirect to list of all doctors after delete
    }

}
