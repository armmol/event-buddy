package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.auth.UserRole;
import com.accenture.eventbuddy.models.Organizer;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.repo.UserRepository;
import com.accenture.eventbuddy.services.OrganizerService;
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
    @Autowired
    private OrganizerService organizerService;

    @RequestMapping(value = {"/add"}, method = RequestMethod.GET)
    public String addVisitor(Model model) {
        model.addAttribute("visitor", new Visitor());
        return "visitor/add";
    }

    @PostMapping("/add")
    public String addVisitor(@ModelAttribute Visitor visitor) {
        visitorService.storeVisitor(visitor);
        return "redirect:/visitor/all";
    }

    @GetMapping("/all")
    public String allVisitors(Model model) {
        List<Visitor> visitors = visitorService.all();
        model.addAttribute("visitors", visitors);
        return "visitor/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteVisitor(@PathVariable Long id) {
        visitorService.deleteById(id);
        return "redirect:/visitor/all";
    }

    @GetMapping("/edit/{id}")
    public String editVisitor(@PathVariable Long id, Model model) {
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor", visitor);
        return "visitor/edit";
    }

    @PostMapping("/edit/{id}")
    public String editVisitor(@PathVariable Long id, @ModelAttribute Visitor visitor) {
        visitorService.updateVisitor(visitor);
        return "redirect:/visitor/all";
    }

    @GetMapping("/details/{id}")
    public String detailsVisitor(@PathVariable Long id, Model model) {
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor", visitor);
        return "visitor/details";
    }

    @RequestMapping(value = {"visitorList"}, method = RequestMethod.GET)
    public String visitors(Model model) {
        List<Visitor> visitors = visitorService.all();
        model.addAttribute("visitors", visitors);
        return "visitorList";
    }

    @RequestMapping(value = {"/showVisitor/{id}"}, method = RequestMethod.GET)
    public String showVisitor(@PathVariable("id") Long id, Model model) {
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor", visitor);
        return "showVisitor";
    }


    @RequestMapping(value = {"/{id}/visitorProfile"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePage(Model model, @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("user", id);
        if (user.isPresent()) {
            UserRole role = user.get().getRole();
            if (role == UserRole.VISITOR) {
                for (Visitor visitor : visitorService.all()) {
                    if (visitor.getUser().getId().equals(id)) {
                        model.addAttribute("visitor", visitor);
                        return "visitor/show";
                    }
                }
            } else {
                for (Organizer organizer : organizerService.all()) {
                    if (organizer.getUser().getId().equals(id)) {
                        model.addAttribute("organizer", organizer);
                        return "organizer/show";
                    }
                }
            }
            return "registration";
        }
        return "registration";
    }


    @RequestMapping(value = {"/{id}/visitorProfile/personal"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePersonalPage(Model model, @PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        model.addAttribute("userId", id);
        if (user.isPresent()) {
            UserRole role = user.get().getRole();
            if (role == UserRole.VISITOR) {
                for (Visitor visitor : visitorService.all()) {
                    if (visitor.getUser().getId().equals(id)) {
                        model.addAttribute("visitor", visitor);
                        return "visitor/showPersonal";
                    }
                }
            } else {
                for (Organizer organizer : organizerService.all()) {
                    if (organizer.getUser().getId().equals(id)) {
                        model.addAttribute("organizer", organizer);
                        return "organizer/showPersonal";
                    }
                }
            }
            return "registration";
        }
        return "registration";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/edit"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePage(Model model, @PathVariable Long id, Principal principal) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            Visitor visitor = visitorService.getByUser(user.get());
            model.addAttribute("visitor", visitor);
            model.addAttribute("userId", id);
            return "visitor/edit";
        }
        return "registration/register";
    }

    @RequestMapping(value = {"/{id}/visitorProfile/edit"}, method = RequestMethod.POST)
    public String editVisitorProfile(@ModelAttribute("visitor") Visitor visitor, BindingResult result, Model model, @PathVariable Long id) {
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
}
