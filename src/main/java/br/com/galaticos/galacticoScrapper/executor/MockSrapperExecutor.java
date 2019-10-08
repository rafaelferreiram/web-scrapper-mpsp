package br.com.galaticos.galacticoScrapper.executor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.config.ChromeDriverConfig;
import br.com.galaticos.galacticoScrapper.dto.LoginDTO;
import br.com.galaticos.galacticoScrapper.job.MockSrapperJob;

@Service
@Scope("prototype")
public class MockSrapperExecutor {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperExecutor.class);

	@Autowired
	private MockSrapperJob mockSrapperJob;
	
	@Autowired
	private ChromeDriverConfig chromeDriverConfig;

	public void execute(LoginDTO login) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		System.setProperty("java.net.preferIPv4Stack" , "true");
		WebDriver driver = new ChromeDriver();
		driver = chromeDriverConfig.setConfig(driver);
		
		// Navigate to URL
		driver.get(login.getUrl());

		if (!mockSrapperJob.login(login, driver)) {
			logger.info("[Login ERROR] - Invalid Username or Password");
		} else {
			logger.info("[Login SUCCESS] - Logged in successfully");
			Thread.sleep(2000);
			executeScrapperForMocks(driver);
			driver.quit();
		}
		TimeUnit.SECONDS.sleep(2);
		driver.quit();
	}


	private void executeScrapperForMocks(WebDriver driver) throws IOException {

			//mockSrapperJob.accessArisp(driver);
			//mockSrapperJob.accessArpenp(driver);
			mockSrapperJob.accessCadesp(driver);
			//mockSrapperJob.accessCaged(driver);
			//mockSrapperJob.accessCensec(driver);
			//mockSrapperJob.accessDetran(driver);
			//mockSrapperJob.accessInfocrim(driver);
			//mockSrapperJob.accessJucesp(driver);
			//mockSrapperJob.accessSiel(driver);
			//mockSrapperJob.accessSivec(driver);

	}

}
