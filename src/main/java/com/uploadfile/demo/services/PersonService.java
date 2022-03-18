package com.uploadfile.demo.services;
import com.uploadfile.demo.forms.PersonForm;
import com.uploadfile.demo.models.Person;

/**
 * The interface Person service.
 */
public interface PersonService {

    /**
     * Save person.
     *
     * @param personForm the person form
     * @return the person
     */
    Person save(PersonForm personForm);
}
