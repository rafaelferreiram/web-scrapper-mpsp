package br.com.galaticos.galacticoScrapper.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.dto.LoginDTO;
import br.com.galaticos.galacticoScrapper.job.MockSrapperExecutor;

@Component
@Scope("prototype")
public class ScrapperAsync implements Runnable{
	
	@Autowired
	private MockSrapperExecutor mockSrapperExecutor;
	
	private LoginDTO login;
	
	public LoginDTO getLogin() {
		return login;
	}


	public void setLogin(LoginDTO login) {
		this.login = login;
	}


	@Override
	public void run() {
		try {
			mockSrapperExecutor.execute(login);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
