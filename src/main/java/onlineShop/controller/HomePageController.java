package onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {

  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String sayIndex() {
    return "index";
  }
//Dispatcher Servlet received a GET request from front end, find a proper controller to
// handle the request by looking at the RequestMapping annotation
  @RequestMapping("/login")
  // TODO: 3/2/21  is model and view  an object?
  //  why /login does not need a method = ?
  //  (value = "error", required = false) String error vs ("lat") double lat
  public ModelAndView login(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout) {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("login");
// TODO: 3/2/21 addObject?  
    if (error != null) {
      modelAndView.addObject("error", "Invalid username and Password");
    }

    if (logout != null) {
      modelAndView.addObject("logout", "You have logged out successfully");
    }
    return modelAndView;
  }

  @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
  public String sayAbout() {
    return "aboutUs";
  }
}
