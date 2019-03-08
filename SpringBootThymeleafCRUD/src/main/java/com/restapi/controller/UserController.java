package com.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.restapi.model.User;
import com.restapi.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService studentService;

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}
		studentService.saveUser(user);
		List<User> users = studentService.findAllUser();
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		User user = studentService.getUserById(id);
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}
		studentService.saveUser(user);
		List<User> users = studentService.findAllUser();
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		User user = studentService.getUserById(id);
		studentService.deleteUser(user);
		List<User> users = studentService.findAllUser();
		model.addAttribute("users", users);
		return "index";
	}
}
