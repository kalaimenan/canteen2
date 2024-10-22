package com.rome.canteen.service;

import com.rome.canteen.model.Contact;
import com.rome.canteen.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Method to save a contact message
    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    // Method to retrieve all contact messages
    public List<Contact> getAllMessages() {
        return contactRepository.findAll();
    }
}
