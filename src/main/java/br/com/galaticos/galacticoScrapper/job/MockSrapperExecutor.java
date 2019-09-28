package br.com.galaticos.galacticoScrapper.job;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.dto.LoginDTO;

@Service
@Scope("prototype")
public class MockSrapperExecutor {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperExecutor.class);
	
	@Autowired
	private MockSrapperJob mockSrapperJob;

	public void execute(LoginDTO login) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// Navigate to URL
		driver.get(login.getUrl());
		
		mockSrapperJob.login(login,driver);
		logger.info("logged in ");
		try {
			TimeUnit.SECONDS.sleep(2);
			mockSrapperJob.accessArisp(driver);
			mockSrapperJob.accessArpenp(driver);
			mockSrapperJob.accessCadesp(driver);
			mockSrapperJob.accessCaged(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
