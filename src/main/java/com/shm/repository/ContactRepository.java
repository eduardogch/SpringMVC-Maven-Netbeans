package com.shm.repository;

import java.util.List;

import com.shm.model.Contact;

public interface ContactRepository {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
	public void updateContact(Contact contact);
	
	public Contact getContact(Integer id);
	public Contact searchContact(String where);
}
