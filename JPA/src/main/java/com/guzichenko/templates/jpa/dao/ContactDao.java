package com.guzichenko.templates.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.ScrollableResults;
import org.springframework.stereotype.Component;

import com.guzichenko.templates.jpa.entities.Contact;
import com.guzichenko.templates.jpa.entities.Contact_;

/**
 * @author - Guzichenko Artem.
 */
@Component
public class ContactDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Contact contact) {
		entityManager.persist(contact);
	}

	public List<Contact> findAll() {
		return entityManager.createQuery("SELECT c FROM Contact c").getResultList();
	}

	public ScrollableResults getScroller(){

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Contact> query = cb.createQuery(Contact.class);
		Root<Contact> from = query.from(Contact.class);

		query.select(from).orderBy(cb.asc(from.get(Contact_.name)));

		return null;
	}
}
