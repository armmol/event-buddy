package com.accenture.eventbuddy.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "auth")
public class AuthController {

  @Autowired
  private UserDetailsServiceImpl userService;

  @RequestMapping("/register")
  public String showRegistrationForm(Model model){
    UserDto userDto = new UserDto();
    model.addAttribute("user", userDto);
    return "registration";
  }

  @RequestMapping(path = "/register/save", method = RequestMethod.POST)
  public String registration(@ModelAttribute("user") UserDto userDto){
    userService.registerUser(userDto);
    return "redirect:/event/eventList";
  }



}
