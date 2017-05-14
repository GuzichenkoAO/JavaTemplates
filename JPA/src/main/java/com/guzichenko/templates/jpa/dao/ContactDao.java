package com.guzichenko.templates.jpa.dao;

import com.guzichenko.templates.jpa.entities.Contact;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author - Guzichenko Artem.
 */
@Component
public class ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ContactDao() {
    }

    public void persist(Contact contact) {
        entityManager.persist(contact);
    }

    public List<Contact> findAll() {
        return entityManager.createQuery("SELECT c FROM Contact c").getResultList();
    }
}
