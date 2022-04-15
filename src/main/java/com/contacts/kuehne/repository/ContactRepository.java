package com.contacts.kuehne.repository;

import com.contacts.kuehne.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author salomao.junior
 * Contact Repository: JPA transactional methods set and overiding
 */
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query(value = "select * from contact as c where c.full_name =?1", nativeQuery = true)
    List<Contact> findByFullName(String fullName);

    //@Query(value = "select * from contact as c where c.full_name like %:fullName%", nativeQuery = true)
    @Query(value = "select * from contact as c where lower(c.full_name) like lower(concat('%', ?1,'%'))", nativeQuery = true)
    List<Contact> findByFullNameContaining(String fullName);
}
