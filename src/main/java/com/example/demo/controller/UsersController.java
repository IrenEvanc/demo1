package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class UsersController {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String Humans(ModelMap model) {
            List<Human> humans = new ArrayList<Human>();

            *//*if (title == null)
                tutorialRepository.findAll().forEach(tutorials::add);
            else
                tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
*//*
            humanRepository.findAll().forEach(humans::add);

        model.addAttribute("humans", humans);
        return "showHuman";
    }*/

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "show-user";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Users user) {
        System.out.println("TRYTOADDD");
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid Users user, BindingResult result, Model model) {
        System.out.println("BRGINOFADDING");
        if (result.hasErrors()) {
            System.out.println("ERROR????");
            return "add-user";
        }

        usersRepository.save(user);
        System.out.println("SAVED??????");
        return "redirect:/index";
    }

//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        Users user = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        model.addAttribute("user", user);
//
//        return "update-user";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid Users user, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-user";
//        }
//
//        usersRepository.save(user);
//
//        return "redirect:/index";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        Users user = usersRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        usersRepository.delete(user);
//
//        return "redirect:/index";
//    }
}
