package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Pasien;
import com.example.demospringboot.service.PasienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PasienController {

    @Autowired
    private PasienService pasienService; // Renamed to follow naming convention

    @GetMapping("/pasien")
    public String pasienPage(Model model) {
    if (!model.containsAttribute("pasRec")) { 
        model.addAttribute("pasRec", null); // Default jika tidak ada data baru
    }
        model.addAttribute("pasList", pasienService.getAllpas()); // Semua pasien
        model.addAttribute("pasInfo", new Pasien(null, null, null, null));  // Form untuk pasien baru
        return "pasien"; // Render pasien.html
}

    
    @GetMapping("/pasien/{pasien_id}")
    public String pasienGetRec(Model model, @PathVariable("pasien_id") int pasienId) {
        Pasien pasien = pasienService.getpasById(pasienId); // Ensure that this returns a valid Pasien or null
        model.addAttribute("pasList", pasienService.getAllpas()); // Pass list of all pasien
        if (pasien != null) {
            model.addAttribute("pasRec", pasien); // Pass the specific Pasien for editing
        } else {
            // Handle the case where Pasien is not found (optional)
            model.addAttribute("error", "Pasien not found!");
        }
        return "pasien"; // Render the pasien.html template
    }

    // LOGIN 

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This will render the login.html page
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("pasien_id") int pasienId,
                               @RequestParam("password") String password,
                               Model model) {
        Pasien pasien = pasienService.authenticatePasienById(pasienId, password);
        if (pasien != null) {
            model.addAttribute("pasien", pasien); // Add the authenticated user to the model
            return "redirect:/rawat"; // Redirect to the pasien page after successful login
        } else {
            model.addAttribute("error", "Invalid Pasien ID or password");
            return "login"; // If authentication fails, show the login page again
        }
    }

    // END LOGIN

    @PostMapping(value = "/pasien/submit", params = {"add"})
    public String pasienAdd(@ModelAttribute("pasInfo") Pasien pasInfo, RedirectAttributes redirectAttributes) {
        Pasien savedPasien = pasienService.addpas(pasInfo);
        redirectAttributes.addFlashAttribute("pasRec", savedPasien); // Kirim data pasien baru
        pasInfo.Notifikasi();  // Panggil metode Notifikasi (opsional untuk logging)
        redirectAttributes.addFlashAttribute("message", "Pasien berhasil ditambahkan!");
        return "redirect:/pasien"; // Redirect kembali ke halaman pasien
    }
    
}
