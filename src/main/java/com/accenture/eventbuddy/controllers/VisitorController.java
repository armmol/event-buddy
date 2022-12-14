package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.repo.UserRepository;
import com.accenture.eventbuddy.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
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
        Visitor visitor = visitorService.getById(id);
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
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor", visitor);
        return "visitor/details";
    }

    //where is this going to be used?

    /**
     * Commenting out because was not used. Check Registration Controller to add Visitors and Organizer
     */
//    @RequestMapping(value = {"/addVisitor"}, method = RequestMethod.GET)
//    public String showAddVisitorPage(@PathVariable Long id, Model model){
//        Visitor visitor = new Visitor();
//        model.addAttribute("visitor", visitor);
//        return "addVisitor";
//    }
//
//    @RequestMapping(value = {"/addVisitor"}, method = RequestMethod.POST)
//    public String saveVisitor(@ModelAttribute("visitorForm") Visitor visitor){
//        //Language language = visitor.getLanguage();
//        if(visitor != null ){
//            visitorService.storeVisitor(visitor);
//            return "redirect:/showVisitor/" + visitor.getVisitorId();
//        }else return "redirect:/notFoundError";
//    }

//    @RequestMapping(value = {"/deleteVisitor"}, method = RequestMethod.POST)
//    public String deleteVisitor(@RequestParam Long id){
//        visitorService.deleteById(id);
//        return "redirect:/visitorList";
//    }

    @RequestMapping (value = {"visitorList"}, method = RequestMethod.GET)
    public String visitors(Model model){
        List<Visitor> visitors = visitorService.all();
        model.addAttribute("visitors", visitors);
        return "visitorList";
    }

    @RequestMapping (value = {"/showVisitor/{id}"}, method = RequestMethod.GET)
    public String showVisitor(@PathVariable("id") Long id, Model model){
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor", visitor);
        return "showVisitor";
    }


    @RequestMapping(value = {"/{id}/visitorProfile"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePage(Model model, @PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", id);
        if (user.isPresent()) {
            if (user.get().getRole().equals("VISITOR")) {
                Visitor visitor = visitorService.getByUser(user.get());
                model.addAttribute("visitor", visitor);
                return "visitor/show";
            } else {
                return "registration";
            }
        }
        return "registration";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/personal"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePersonalPage(Model model, @PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Visitor visitor = visitorService.getByUser(user.get());
            model.addAttribute("visitor", visitor);
            model.addAttribute("user", id);
            return "visitor/showPersonal";
        }
        return "registration/register";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/edit"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePage(Model model, @PathVariable Long id, Principal principal){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Visitor visitor = visitorService.getByUser(user.get());
            model.addAttribute("visitor", visitor);
            return "visitor/edit";
        }
        return "registration/register";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/edit"}, method = RequestMethod.POST)
    public String editVisitorProfile(@ModelAttribute("visitor") Visitor visitor, BindingResult result, Model model, @PathVariable Long id){
        if (result.hasErrors()) {
            visitor.setVisitorId(id);
            return "visitor/edit";
        }
        Visitor visitor1 = visitorService.getById(id);
        visitor1.setVisitorDescription(visitor.getVisitorDescription());
        visitorService.updateVisitor(visitor1);
        model.addAttribute("user", id);
        return "redirect:/visitor/" + visitor1.getVisitorId() + "/visitorProfile/personal";
    }

    // edit profile post method
//    @RequestMapping(value = {"/visitorProfile/edit"}, method = RequestMethod.POST)
//    public String editVisitorProfile(@ModelAttribute("visitorForm") Visitor visitor, Principal principal){
//        String username = principal.getName();
//        User user = userRepository.findByUsername(username);
//        visitor.setUser(user);
//
//        if(visitor != null ){
//            visitorService.updateVisitor(visitor);
//            return "redirect:/visitor/visitorProfile";
//        }else return "redirect:/notFoundError";
//    }

//    @RequestMapping(value = {"/visitorProfile/edit"}, method = RequestMethod.POST)
//    public String editVisitorProfile(Visitor visitor, Principal principal){
//        System.out.println("VisitorController: editVisitorProfile");
//        System.out.println(visitor);
//        String username = principal.getName();
//        User user = userRepository.findByUsername(username);
//        visitor.setUser(user);
//        visitorService.storeVisitor(visitor);
//        return "redirect:/visitorProfile";
//    }
}
