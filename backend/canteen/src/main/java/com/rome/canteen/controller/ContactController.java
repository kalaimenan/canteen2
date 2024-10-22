package com.rome.canteen.controller;

import com.rome.canteen.model.Contact;
import com.rome.canteen.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody Contact contact) {
        try {
            contactService.saveContact(contact);
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact form submitted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting contact form: " + e.getMessage());
        }
    }

    // Only users with roles "ADMIN" or "OWNER" can access this endpoint

    @GetMapping("/messages")
    public ResponseEntity<List<Contact>> getAllMessages() {
        List<Contact> messages = contactService.getAllMessages();
        return ResponseEntity.ok(messages);
    }
}
