package br.com.galaticos.galacticoScrapper.executor;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import br.com.galaticos.galacticoScrapper.config.ChromeDriverConfig;
import br.com.galaticos.galacticoScrapper.constants.MockConstants;
import br.com.galaticos.galacticoScrapper.job.MockSrapperJob;

/**
 * MPSP Scrapper System
 * 
 * @author Rafael Ferreira Silva Matos
 * @version 1.0
 * @rm 77899
 */

@Service
@Scope("prototype")
public class MockSrapperExecutor {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperExecutor.class);

	@Autowired
	private MockSrapperJob mockSrapperJob;
	
	@Autowired
	private ChromeDriverConfig chromeDriverConfig;

	public void execute() throws InterruptedException, IOException, DocumentException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		System.setProperty("java.net.preferIPv4Stack" , "true");
		WebDriver driver = new ChromeDriver();
		driver = chromeDriverConfig.setConfig(driver);
		
		// Navigate to URL
		driver.get(MockConstants.URL);

		if (!mockSrapperJob.login(driver)) {
			logger.info("[Login ERROR] - Invalid Username or Password");
		} else {
			logger.info("[Login SUCCESS] - Logged in successfully");
			executeScrapperForMocks(driver);
			driver.quit();
		}
		driver.quit();
	}


	private void executeScrapperForMocks(WebDriver driver) throws IOException, DocumentException, InterruptedException {
			mockSrapperJob.accessArisp(driver);
			mockSrapperJob.accessArpenp(driver);
			mockSrapperJob.accessCadesp(driver);
			mockSrapperJob.accessCaged(driver);
			mockSrapperJob.accessCensec(driver);
			mockSrapperJob.accessDetran(driver);
			mockSrapperJob.accessInfocrim(driver);
			mockSrapperJob.accessJucesp(driver);
			mockSrapperJob.accessSiel(driver);
			mockSrapperJob.accessSivec(driver);
	}

}
