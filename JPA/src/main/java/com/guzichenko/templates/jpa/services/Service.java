package com.guzichenko.templates.jpa.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.guzichenko.templates.jpa.dao.ContactDao;
import com.guzichenko.templates.jpa.entities.Contact;


/**
 * @author - Guzichenko Artem.
 */
@Component
public class Service {

    @Autowired
    private ContactDao contactDao;

    @Transactional
    public void add(Contact contact) {
        contactDao.persist(contact);
    }

    @Transactional
    public void addAll(Collection<Contact> contacts) {
        for (Contact contact : contacts) {
            contactDao.persist(contact);
        }
    }

    @Transactional(readOnly = true)
    public List<Contact> listAll() {
        return contactDao.findAll();
    }
}
