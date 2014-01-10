package com.shm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shm.model.Contact;
import com.shm.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	// ******************* Read Method *********************

	@RequestMapping(method = RequestMethod.GET)
	public String listContact(ModelMap model) {

		model.addAttribute("contact", new Contact());
		model.addAttribute("contactList", contactService.listContact());
		return "contact/list";
	}

	// ******************* Create Methods *********************

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addContactGet(ModelMap model) {

		model.addAttribute("contact", new Contact());
		return "contact/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContactPost(
			@Valid @ModelAttribute("contact") Contact contact,
			BindingResult result, ModelMap model) {

		if (!result.hasErrors()) {
			contactService.addContact(contact);
			model.addAttribute("message", "Contact was successfully added.");
			model.addAttribute("errorType", "info");
			return "contact/add";
		} else {
			model.addAttribute("message", "Error adding a contact.");
			model.addAttribute("errorType", "danger");
			return "contact/add";
		}
	}

	// ******************* Update Methods *********************

	@RequestMapping(value = "/edit/{contactId}", method = RequestMethod.GET)
	public String editContactGet(@PathVariable("contactId") Integer contactId,
			ModelMap model) {

		model.addAttribute("contact", contactService.getContact(contactId));
		return "contact/edit";
	}

	@RequestMapping(value = "/edit/{contactId}", method = RequestMethod.POST)
	public String editContactPost(@PathVariable("contactId") Integer contactId,
			@Valid @ModelAttribute("contact") Contact contact,
			BindingResult result, ModelMap model) {

		if (!result.hasErrors()) {
			contact.setId(contactId);
			contactService.updateContact(contact);
			model.addAttribute("message", "Contact was successfully edited.");
			model.addAttribute("errorType", "info");
			return "contact/edit";
		} else {
			model.addAttribute("message", "Error editing a contact.");
			model.addAttribute("errorType", "danger");
			return "contact/edit";
		}

	}

	// ******************* Delete Method *********************

	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);
		return "redirect:/contact";
	}

	// ******************* Search Method *********************

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchContactGet(@RequestParam String email, ModelMap model) {

		if (email.equals("")) {
			return "redirect:/contact";
		} else {
			Contact contact = contactService.searchContact("email = '" + email + "'");
			return "redirect:/contact/edit/" + contact.getId();
		}
	}

	// ******************* AutoComplete Methods *********************

	@RequestMapping(value = "/getEmailTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Contact> getTags(@RequestParam String getEmail) {

		List<Contact> result = new ArrayList<Contact>();

		for (Contact contact : contactService.listContact()) {
			if (contact.getEmail().contains(getEmail)) {
				result.add(contact);
			}
		}

		return result;

	}

}
