package com.uploadfile.demo.services.impl;

import com.uploadfile.demo.forms.PersonForm;
import com.uploadfile.demo.models.Person;
import com.uploadfile.demo.repositories.PersonRepository;
import com.uploadfile.demo.services.FilesStorageService;
import com.uploadfile.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Person service.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private FilesStorageService filesStorageService;

    @Autowired
    private PersonRepository personRepository;
    
    private final String folderImagePersonne = "personnes";

    @Override
    public Person save(PersonForm personForm) {
        Person person = new Person();
        person.setNom(personForm.getNom());
        person.setPrenoms(personForm.getPrenoms());
        person.setImageName(filesStorageService.save(personForm.getImage(), folderImagePersonne));
        person = personRepository.save(person);
        return person;
    }
}
