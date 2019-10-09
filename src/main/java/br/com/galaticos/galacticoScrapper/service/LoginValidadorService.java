package br.com.galaticos.galacticoScrapper.service;

import org.springframework.stereotype.Service;

@Service
public class LoginValidadorService {

	public boolean isLoginValid(String username, String password) {
		boolean isValid = Boolean.FALSE;
		if ("fiap".equals(username) && "mpsp".equals(password)) {
			isValid = Boolean.TRUE;
		}
		return isValid;
	}
}
