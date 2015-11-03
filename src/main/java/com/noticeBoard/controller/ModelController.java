package com.noticeBoard.controller;

import com.noticeBoard.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.noticeBoard.service.ModelService;

import java.util.logging.Logger;

/**
 * Created by Andrii on 11/1/2015.
 */
@Controller
public class ModelController {

    private static final Logger LOGGER = Logger.getLogger("Logging info");
    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute ("person") Person person ){
        if (person.getId() == 0){
            this.modelService.addPerson(person);
        }else {
            this.modelService.updatePerson(person);
        }
        return "redirected:/person";
    }

    @RequestMapping("/edit/{id}")
    public String updatePerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.modelService.getPersonById(id));
        return "person";
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.modelService.deletePerson(id);
        return "redirected:/person";
    }
}
