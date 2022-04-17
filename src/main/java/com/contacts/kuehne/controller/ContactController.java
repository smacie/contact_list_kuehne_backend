package com.contacts.kuehne.controller;

import com.contacts.kuehne.pojo.ContactInfo;
import com.contacts.kuehne.service.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author salomao.junior
 * Microservice main | exposed methods
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ContactController {

    public ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/test")
    public String test(){
        return "I'm running mate!";
    }

    @GetMapping("/getContactById/{id}")
    public ContactInfo getContactsById(@PathVariable Long id){
        return contactService.findContactById(id);
    }

    @GetMapping("/getContactsByName")
    public List<ContactInfo> getContactsByName(@RequestParam String name){
        return contactService.findContactsByName(name);
    }

}
