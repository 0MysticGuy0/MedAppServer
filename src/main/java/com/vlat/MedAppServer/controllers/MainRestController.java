package com.vlat.MedAppServer.controllers;

import com.vlat.MedAppServer.interfaces.Generator;
import com.vlat.MedAppServer.interfaces.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/med")
@AllArgsConstructor
public class MainRestController {
    @Autowired
    private Generator codeGenerator;
    @Autowired
    private EmailService emailService;
    @GetMapping("/code/{email}")
    public String getVerifyCode(@PathVariable String email){
        String code = codeGenerator.generate();
        try {
            emailService.sendSimpleEmail(email,"CODE", code);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return code;
    }
}
