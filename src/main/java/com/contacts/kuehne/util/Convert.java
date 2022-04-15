package com.contacts.kuehne.util;

import com.contacts.kuehne.model.Contact;
import com.contacts.kuehne.pojo.ContactInfo;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author salomao.junior
 * Convert methods as some other utilities
 */
public class Convert {

    /**
     * @param object
     * @param tClass
     * @param <T>
     * @return mapped object to given class
     */
    public static <T> T toInfo(Object object, Class<T> tClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, tClass);
    }

    /**
     *
     * @param contact
     * @return ContactInfo object given model ORM object
     */
    public static ContactInfo toContactInfo(Contact contact){
        return toInfo(contact, ContactInfo.class);
    }

    /**
     *
     * @param contactList
     * @return List of ContactInfo objects given list of model ORM object
     */
    public static List<ContactInfo> toContactInfo(List<Contact> contactList){
        return contactList.stream().map(contact -> toInfo(contact, ContactInfo.class)).collect(Collectors.toList());
    }

}
