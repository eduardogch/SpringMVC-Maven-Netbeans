package com.shm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shm.model.Contact;
import com.shm.repository.ContactRepository;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public void addContact(Contact contact) {
		contactRepository.addContact(contact);
	}

	public List<Contact> listContact() {

		return contactRepository.listContact();
	}

	public void removeContact(Integer id) {
		contactRepository.removeContact(id);
	}

	public Contact getContact(Integer id) {

		return contactRepository.getContact(id);
	}

	public void updateContact(Contact contact) {
		contactRepository.updateContact(contact);
	}

	public Contact searchContact(String where) {
		
		return contactRepository.searchContact(where);
	}
}
