package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.services.VisitorService;
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

    @RequestMapping("/add")
    public String addVisitor(Model model){
        model.addAttribute("visitor", new Visitor());
        return "visitor/add";
    }
    @PostMapping("/add")
    public String addVisitor(@ModelAttribute Visitor visitor){
        visitorService.storeVisitor(visitor);
        return "redirect:/visitor/all";
    }
    @GetMapping("/all")
    public String allVisitors(Model model){
        List<Visitor> visitors = visitorService.all();
        model.addAttribute("visitors", visitors);
        return "visitor/all";
    }
    @GetMapping("/delete/{id}")
    public String deleteVisitor(@PathVariable Long id){
        visitorService.deleteById(id);
        return "redirect:/visitor/all";
    }
    @GetMapping("/edit/{id}")
    public String editVisitor(@PathVariable Long id, Model model){
        Visitor visitor = visitorService.getVisitorById(id);
        model.addAttribute("visitor", visitor);
        return "visitor/edit";
    }
    @PostMapping("/edit/{id}")
    public String editVisitor(@PathVariable Long id, @ModelAttribute Visitor visitor){
        visitorService.updateVisitor(visitor);
        return "redirect:/visitor/all";
    }
    @GetMapping("/details/{id}")
    public String detailsVisitor(@PathVariable Long id, Model model){
        Visitor visitor = visitorService.getVisitorById(id);
        model.addAttribute("visitor", visitor);
        return "visitor/details";
    }


    /*//where is this going to be used?
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
    }*/
}
