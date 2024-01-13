package com.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.entities.User;
import com.flight.repositories.UserRepository;

@Controller
public class UserController {

	@RequestMapping("/home")
	public String homePage() {
		return "Home";
	}

	@RequestMapping("/showLoginPage")
	public String loginPage() {
		return "Login";
	}

	@RequestMapping("/showReg")
	public String ShowRegPage() {
		return "ShowReg";
	}

	@Autowired
	UserRepository userRepo;

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "Login";
	}

	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap model) {
		User user = userRepo.findByEmail(emailId);
		if (user != null) {
			if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
				return "findFlight";
			} else {
				model.addAttribute("error", "Invalid username/password");
				return "Login";
			}
		} else {
			model.addAttribute("error", "Invalid username/password");
			return "Login";

		}

	}
}
