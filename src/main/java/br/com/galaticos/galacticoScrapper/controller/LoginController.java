package br.com.galaticos.galacticoScrapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "LoginPage";
    }
    
    @PostMapping("/login")
    public String loginParam(Model model, String username, String password) {
        String returnPage = "LoginPage";
    	if (isLoginValid(username,password)) {
    		returnPage = "welcome";
        }

        return returnPage;
    }

	private boolean isLoginValid(String username, String password) {
		boolean isValid = Boolean.FALSE;
		if("fiap".equals(username) && "mpsp".equals(password)) {
			isValid = Boolean.TRUE;
		}
		return isValid;
	}
}
