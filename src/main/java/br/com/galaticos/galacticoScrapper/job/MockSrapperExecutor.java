package br.com.galaticos.galacticoScrapper.job;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import br.com.galaticos.galacticoScrapper.dto.LoginDTO;

@Service
@Scope("prototype")
public class MockSrapperExecutor {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperExecutor.class);

	@Autowired
	private MockSrapperJob mockSrapperJob;

	public void execute(LoginDTO login) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		String downloadFilepath = "/Users/rafaelferreira/Projetos/AMWebCrawler/galacticoScrapper/downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--print-to-pdf"); // to disable browser extension popup
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(cap);
		
		// Navigate to URL
		driver.get(login.getUrl());

		if (!mockSrapperJob.login(login, driver)) {
			logger.info("[Login ERROR] - Invalid Username or Password");
		} else {
			logger.info("[Login SUCCESS] - Logged in successfully");
			try {
				TimeUnit.SECONDS.sleep(2);
				executeScrapperForMocks(driver);
			} catch (IOException e) {
				driver.quit();
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		TimeUnit.SECONDS.sleep(2);
		driver.quit();
	}

	private void executeScrapperForMocks(WebDriver driver) throws IOException {

		// mockSrapperJob.accessArisp(driver);
		// mockSrapperJob.accessArpenp(driver);
		// mockSrapperJob.accessCadesp(driver);
		// mockSrapperJob.accessCaged(driver);
		// mockSrapperJob.accessCensec(driver);
		// mockSrapperJob.accessDetran(driver);
		try {
			mockSrapperJob.accessInfocrim(driver);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mockSrapperJob.accessSiel(driver);
		// mockSrapperJob.accessSivec(driver);

	}

}
