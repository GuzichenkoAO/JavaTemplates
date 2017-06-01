package com.guzichenko.templates.hibernate;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.guzichenko.templates.hibernate.entities.MappedEvent;

/**
 * @author - Guzichenko Artem.
 */
public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();

		// create SessionFactor, very expensive and one per database
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new MappedEvent("Our very first event!", new Date()));
		session.save(new MappedEvent("A follow up event", new Date()));
		session.getTransaction().commit();
		// close the session (physical connection to database)
		session.close();

		// now lets pull events from the database and list them
		// create Session (new physical connection to database)
		session = sessionFactory.openSession();
		session.beginTransaction();
		List<MappedEvent> result = session.createQuery("from MappedEvent ").list();
		for (MappedEvent mappedEvent : result) {
			LOGGER.info("MappedEvent (" + mappedEvent.getDate() + ") : " + mappedEvent.getTitle());
		}
		session.getTransaction().commit();
		session.close();

		// destroy session factory
		sessionFactory.close();

	}
}

