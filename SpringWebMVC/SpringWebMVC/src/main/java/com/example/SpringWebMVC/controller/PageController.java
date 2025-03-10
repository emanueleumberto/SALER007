package com.example.SpringWebMVC.controller;

import com.example.SpringWebMVC.model.User;
import com.example.SpringWebMVC.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class PageController {

    @Autowired UserService userService;

    @GetMapping("/home")
    public @ResponseBody String getHomePage() {
        return "Prima pagina MVC Spring";
    }

    // EndPoint con parametri di tipo Query String
    @GetMapping("/home/params")
    public @ResponseBody String getHomePageWithQueryStringParams(@RequestParam String name, @RequestParam String lastname) {
        // http://localhost:8080/home/params?name=Mario&lastname=Rossi
        return "Prima pagina MVC Spring con paramentri di tipo Query String: " + name + " " + lastname;
    }

    @GetMapping("/home/params/{name}")
    public @ResponseBody String getHomePageWithPathParams(@PathVariable String name) {
        // http://localhost:8080/home/params/Mario
        return "Prima pagina MVC Spring con paramentri di tipo Path Variable: " + name;
    }

    @GetMapping("/home/params/{name}/{lastname}")
    public @ResponseBody String getHomePageWithPathParams(@PathVariable String name, @PathVariable String lastname) {
        // http://localhost:8080/home/params/Mario/Rossi
        return "<H2>Prima pagina MVC Spring con paramentri di tipo</h2> <h3>Path Variable: " + name + " " + lastname + "</h3>";
    }

    @GetMapping("/page1/{name}/{lastname}")
    public String getPageThymeLeaf(Map<String, Object> model, @PathVariable String name, @PathVariable String lastname) {
        model.put("firstname", name);
        model.put("lastname", lastname);
        return "pageThymeLeaf";
    }

    @GetMapping("/page2/{name}/{lastname}")
    public String getPageThymeLeaf(Model model, @PathVariable String name, @PathVariable String lastname) {
        model.addAttribute("firstname", name);
        model.addAttribute("lastname", lastname);
        return "pageThymeLeaf";
    }

    @GetMapping("/page3/{name}/{lastname}")
    public String getPageThymeLeaf(ModelMap model, @PathVariable String name, @PathVariable String lastname) {
        model.addAttribute("firstname", name);
        model.addAttribute("lastname", lastname);
        return "pageThymeLeaf";
    }

    @GetMapping("/page4/{name}/{lastname}")
    public ModelAndView getPageThymeLeaf(@PathVariable String name, @PathVariable String lastname) {
        //String page = (name != "" ) ? "pageThymeLeaf" : "error";
        String page = "pageThymeLeaf";
        ModelAndView model = new ModelAndView(page);
        model.addObject("firstname", name);
        model.addObject("lastname", lastname);
        return model;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/gestione-login")
    public @ResponseBody String gestioneLoginGet(@RequestParam String loginemail, @RequestParam String loginpass) {
        return "Controller Page Login!!! (" + loginemail + ")-(" + loginpass + ")";
    }

    @PostMapping("/gestione-login")
    public @ResponseBody String gestioneLoginPost(@RequestParam String loginemail, @RequestParam String loginpass) {
        User user = userService.checkLogin(loginemail, loginpass);
        if(user != null ) {
            return "Controller Page Login!!! (" + user.getFirstname() + " " + user.getLastname() + ") - Login";
        } else {
            return "Errore di Login!!!";
        }

    }
}
