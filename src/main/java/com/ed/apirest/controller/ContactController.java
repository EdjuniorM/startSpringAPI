package com.ed.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ed.apirest.model.Contact;
import com.ed.apirest.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @GetMapping
    public List<Contact> list() {
        return repository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Contact contact) {
        repository.save(contact);
    }

    @PutMapping("/update")
    public Contact update(@RequestBody Contact contact) {
        if (contact.getId() > 0) {
            return repository.save(contact);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        Optional<Contact> user = repository.findById(id);

        if (user.isPresent()) {
            repository.deleteById(id);
            return "Contact deleted successfully.";
        }

        return "Contact not found.";
    }

}
