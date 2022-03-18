package com.uploadfile.demo.controllers;

import com.uploadfile.demo.forms.PersonForm;
import com.uploadfile.demo.models.Person;
import com.uploadfile.demo.repositories.PersonRepository;
import com.uploadfile.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * The type Personnes controller.
 */
@Controller()
@RequestMapping(value = "persons")
public class PersonnesController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Index string.
     *
     * @param model the model
     * @return string string
     */
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String index(Model model) {
        String bonjourText = "@nano.com";
        model.addAttribute("bonjourText", bonjourText);
        model.addAttribute("personForm", new PersonForm());
        List<Person> personList = personRepository.findByOrderByIdDesc();
        model.addAttribute("persons", personList);
        return "list-persons";
    }


    /**
     * Save string.
     *
     * @param personForm the person form
     * @return the string
     */
    @RequestMapping(method = RequestMethod.POST, value = "save")
    public String save(@ModelAttribute PersonForm personForm) {
        personService.save(personForm);
        return "redirect:/persons/list";
    }

}
