package com.example.Baymax.controller.bay;

import com.example.Baymax.dto.bay.PatientHistoryDto;
import com.example.Baymax.model.bay.PatientHistory;
import com.example.Baymax.service.bay.PatientHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "history")
public class PatientHistoryController {

    private final PatientHistoryService patientHistoryService;

    public PatientHistoryController(PatientHistoryService patientHistoryService) {
        this.patientHistoryService = patientHistoryService;
    }

    @GetMapping("/manage")
    public String manage(Model model) {
        model.addAttribute("patientHistoryList", patientHistoryService.getAllPatientHistory());
        return "/PatientHistory/Manage";
    }

    @GetMapping("/create")
    public String create(Model model) {
        PatientHistoryDto patientHistoryDto = new PatientHistoryDto();
        model.addAttribute("patientHistoryDto", patientHistoryDto);
        return "/PatientHistory/Upload";
    }

    @PostMapping("/upload")
    public String create(@Valid @ModelAttribute("patientDto") PatientHistoryDto patientHistoryDto,
                         @RequestParam("image") MultipartFile file, BindingResult result, Model model) {
//        List<String> errors = new ArrayList<>();
//        Patient patient = patientHistoryService.toPatient(patientDto);
        PatientHistory patientHistory = new PatientHistory();
        try {
            patientHistoryService.createPatientHistory(patientHistory);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return "Upload";
    }

}
