package com.contacts.kuehne.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInfo {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String profilePicture;
}
