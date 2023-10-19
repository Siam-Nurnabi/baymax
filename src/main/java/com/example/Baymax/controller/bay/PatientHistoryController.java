package com.example.Baymax.controller.bay;

import com.example.Baymax.model.bay.PatientHistory;
import com.example.Baymax.service.bay.PatientHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @GetMapping("/upload")
    public String upload(Model model) {
//        PatientHistoryDto patientHistoryDto = new PatientHistoryDto();
//        model.addAttribute("patientHistoryDto", patientHistoryDto);
        return "/PatientHistory/Upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("image") MultipartFile file, Model model
//                         @Valid @ModelAttribute("patientDto") PatientHistoryDto patientHistoryDto,
    ) throws IOException {
        System.out.println("Get Original file name:" + file.getOriginalFilename());
//        List<String> errors = new ArrayList<>();
//        Patient patient = patientHistoryService.toPatient(patientDto);
        PatientHistory patientHistory = new PatientHistory();
        try {
            patientHistoryService.createPatientHistory(patientHistory);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        return "/PatientHistory/Upload";
    }

}
