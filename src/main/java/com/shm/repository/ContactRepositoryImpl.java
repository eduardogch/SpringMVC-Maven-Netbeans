package com.shm.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shm.model.Contact;

@Repository
public class ContactRepositoryImpl implements ContactRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	public List<Contact> listContact() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact");
		List<Contact> list = query.list();
		return list;
	}

	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);

		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}
	}

	public void updateContact(Contact contact) {
		Contact contactToUpdate = getContact(contact.getId());
		contactToUpdate.setFirstname(contact.getFirstname());
		contactToUpdate.setLastname(contact.getLastname());
		contactToUpdate.setTelephone(contact.getTelephone());
		contactToUpdate.setEmail(contact.getEmail());

		sessionFactory.getCurrentSession().update(contactToUpdate);
	}

	public Contact getContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
		return contact;
	}

	public Contact searchContact(String where) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Contact where " + where);
		Contact contact = (Contact) query.uniqueResult();
		return contact;
	}

}
