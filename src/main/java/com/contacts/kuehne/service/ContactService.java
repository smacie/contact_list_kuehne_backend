package com.contacts.kuehne.service;

import com.contacts.kuehne.pojo.ContactInfo;
import com.contacts.kuehne.repository.ContactRepository;
import com.contacts.kuehne.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    public ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactInfo findContactById(Long id){
        return Convert.toContactInfo(contactRepository.findById(id).get());
    }

    public List<ContactInfo> findContactsByName(String name){
        return Convert.toContactInfo(contactRepository.findByFullNameContaining(name));
    }
}
