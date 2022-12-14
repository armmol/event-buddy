package com.accenture.eventbuddy.controllers;

import com.accenture.eventbuddy.auth.User;
import com.accenture.eventbuddy.auth.UserDetailsServiceImpl;
import com.accenture.eventbuddy.auth.UserRepository;
import com.accenture.eventbuddy.models.Visitor;
import com.accenture.eventbuddy.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "visitor")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private UserDetailsServiceImpl userService;
    @Autowired
    private UserRepository userRepository;

    //add common data to model
//    @ModelAttribute
//    public void addCommonData(Model model, Principal principal) {
//        String username = principal.getName();
//        User user = userRepository.findByUsername(username);
//        model.addAttribute("user", user);
//    }

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

    @RequestMapping(value = {"/deleteVisitor"}, method = RequestMethod.POST)
    public String deleteVisitor(@RequestParam Long id){
        visitorService.deleteById(id);
        return "redirect:/visitorList";
    }

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

    @RequestMapping (value = {"/visitorProfile"}, method = RequestMethod.GET)
    public String visitorProfile(Model model, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Visitor visitor = visitorService.getByUser(user);
        model.addAttribute("visitor", visitor);
        return "visitorProfile";
    }

    @RequestMapping(value = {"/visitorProfile/edit"}, method = RequestMethod.GET)
    public String showEditVisitorProfilePage(Model model, Principal principal){
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Visitor visitor = visitorService.getByUser(user);
        model.addAttribute("visitor", visitor);
        return "editVisitorProfile";
    }

    @RequestMapping(value = {"/visitorProfile/edit"}, method = RequestMethod.POST)
    public String editVisitorProfile(@ModelAttribute("visitor") Visitor visitor,
                                     Principal principal, BindingResult result, Model model){
        if(result.hasErrors()){
            visitor.setVisitorId(visitor.getVisitorId());
            return "editVisitorProfile";
        }
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        // get visitor by user
        Visitor visitor1 = visitorService.getByUser(user);
//        String username = principal.getName();
//        User user = userRepository.findByUsername(username);
//        visitor.setUser(user);
        

        visitor1.setVisitorDescription(visitor.getVisitorDescription());
        visitorService.updateVisitor(visitor1);
        return "redirect:/visitor/visitorProfile";
    }
//        String username = principal.getName();
//        User user = userRepository.findByUsername(username);
//        visitor.setUser(user);
//
//        if(visitor != null ){
//            visitorService.updateVisitor(visitor);
//            return "redirect:/visitor/visitorProfile";
//        }else return "redirect:/notFoundError";
//  }

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
