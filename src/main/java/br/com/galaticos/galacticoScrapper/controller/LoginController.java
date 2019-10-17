package br.com.galaticos.galacticoScrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.galaticos.galacticoScrapper.service.LoginValidadorService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginValidadorService loginValidadorService;

	@GetMapping("/")
	public String login(Model model, String error, String logout) {
		return "LoginPage";
	}
	
	@GetMapping("/research")
	public String research() {
		return "welcome";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "LoginPage";
	}

	@PostMapping("/login")
	public String loginParam(Model model, String username, String password) {
		String returnPage = "LoginPage";
		if (loginValidadorService.isLoginValid(username, password)) {
			returnPage = "welcome";
		}

		return returnPage;
	}
	
}
