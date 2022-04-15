package com.contacts.kuehne.util;

import com.contacts.kuehne.domain.Contact;
import com.contacts.kuehne.pojo.ContactInfo;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    public static <T> T toInfo(Object object, Class<T> tClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(object, tClass);
    }

    public static ContactInfo toContactInfo(Contact contact){
        return toInfo(contact, ContactInfo.class);
    }
    public static List<ContactInfo> toContactInfo(List<Contact> contactList){
        return contactList.stream().map(contact -> toInfo(contact, ContactInfo.class)).collect(Collectors.toList());
    }

}
