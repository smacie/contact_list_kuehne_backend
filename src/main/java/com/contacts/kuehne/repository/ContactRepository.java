package com.contacts.kuehne.repository;

import com.contacts.kuehne.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "select * from contact as c where c.full_name =?1", nativeQuery = true)
    List<Contact> findByFullName(String fullName);

    //@Query(value = "select * from contact as c where c.full_name =?1", nativeQuery = true)
    List<Contact> findByFullNameContains(String fullName);
}
