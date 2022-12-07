package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.Language;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.services.VisitorService;
import jakarta.el.EvaluationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    //where is this going to be used?
    @RequestMapping(value = {"/addVisitor"}, method = RequestMethod.GET)
    public String showAddVisitorPage(@PathVariable Long id, Model model){
        Visitor visitor = new Visitor();
        model.addAttribute("visitor", visitor);
        return "addVisitor";
    }

    @RequestMapping(value = {"/addVisitor"}, method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("visitorForm") Visitor visitor){
        //Language language = visitor.getLanguage();
        if(visitor != null ){
            visitorService.storeVisitor(visitor);
            return "redirect:/showVisitor/" + visitor.getVisitorId();
        }else return "redirect:/notFoundError";
    }

    @RequestMapping(value = {"/deleteVisitor"}, method = RequestMethod.POST)
    public String deleteEvent(@RequestParam Long id){
        visitorService.deleteById(id);
        return "redirect:/visitorList";
    }

    @RequestMapping (value = {"visitorList"}, method = RequestMethod.GET)
    public String events(Model model){
        List<Visitor> visitors = visitorService.all();
        model.addAttribute("visitors", visitors);
        return "visitorList";
    }

    @RequestMapping (value = {"/showVisitor/{id}"}, method = RequestMethod.GET)
    public String event(@PathVariable("id") Long id, Model model){
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor", visitor);
        return "showVisitor";
    }
}
