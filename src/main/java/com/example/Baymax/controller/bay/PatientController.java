package com.example.Baymax.controller.bay;

import com.example.Baymax.dto.bay.PatientDto;
import com.example.Baymax.model.Patient;
import com.example.Baymax.service.bay.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/manage")
    public String manage(Model model) {
        model.addAttribute("patientList", patientService.getAllPatients());
        return "/Patient/Manage";
    }

    @GetMapping("/create")
    public String create(Model model) {
        PatientDto patientDto = new PatientDto();
        model.addAttribute("patientDto", patientDto);
        return "/Patient/Create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("patientDto") PatientDto patientDto, BindingResult result, Model model) {
        List<String> errors = new ArrayList<>();
        Patient patient = patientService.toPatient(patientDto);
        try {
//            patientService.savePatient(patient);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return "/Patient/Create";
    }

}
