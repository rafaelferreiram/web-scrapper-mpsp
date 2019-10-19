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

	@GetMapping(value={"/", "/logout"})
	public String login() {
		return "LoginPage";
	}
	
	@GetMapping(value={"/research", "/search"})
	public String research() {
		return "welcome";
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
