package com.example.javamailsender.controller;

import com.example.javamailsender.email.EmailSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sendEmail")
public class EmailController {
    private final EmailSender emailSender;

    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping
    public ResponseEntity<?> sendEmail(@RequestParam String to
            , @RequestParam String subject
            , @RequestParam String text) {
        emailSender.sendEmail(to, subject, text);
        return ResponseEntity.ok().build();
    }
}
