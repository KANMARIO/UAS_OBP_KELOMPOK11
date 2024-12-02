package com.example.demospringboot.controller;

import com.example.demospringboot.entity.Rawat;
import com.example.demospringboot.entity.RawatId;
import com.example.demospringboot.service.RawatService;
import com.example.demospringboot.service.PasienService;
import com.example.demospringboot.service.DokterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RawatController {

    @Autowired
    private RawatService rawatService; // Renamed to follow naming convention

    @Autowired
    private PasienService pasienService;  // Service for Pasien

    @Autowired
    private DokterService dokterService;  // Service for Dokter


    @GetMapping("/rawat")
    public String RawatPage(Model model) {
        model.addAttribute("rawList", rawatService.getAllraw()); // All Rawat entities
        model.addAttribute("rawInfo", new Rawat());  // Form for adding new Rawat
        
        // Fetch list of Pasien and Dokter (assuming you have these services)
        model.addAttribute("pasList", pasienService.getAllpas());  // List of Pasien
        model.addAttribute("dokList", dokterService.getAllDok());  // List of Dokter
        
        return "rawat"; // Render the Rawat.html template
    }

    @GetMapping("/rawat/{rawat_id}/{pasien_id}/{id}")
    public String getRawatDetails(Model model, 
                                  @PathVariable("rawat_id") int rawat_id,
                                  @PathVariable("pasien_id") int pasien_id,
                                  @PathVariable("id") int id) {
        // Construct RawatId for the composite key
        RawatId rawatId = new RawatId(rawat_id, pasien_id, id);
        Rawat rawat = rawatService.getrawById(rawatId);
        model.addAttribute("rawat", rawat);  // Pass the single Rawat to the view
        return "rawat_detail"; // Render a different view for the individual rawat
    }

    @PostMapping(value = "/rawat/submit/add")
    public String rawAdd(@ModelAttribute("rawInfo") Rawat rawInfo) {
        rawatService.addraw(rawInfo);
        return "redirect:/rawat?success=true";
    }
}
