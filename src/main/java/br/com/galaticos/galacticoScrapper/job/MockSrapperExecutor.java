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
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import br.com.galaticos.galacticoScrapper.dto.LoginDTO;

@Service
@Scope("prototype")
public class MockSrapperExecutor {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperExecutor.class);

	@Autowired
	private MockSrapperJob mockSrapperJob;

	public void execute(LoginDTO login) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver = setChromeDriverConfig(driver);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		String downloadFilepath = "/Users/rafaelferreira/Projetos/AMWebCrawler/galacticoScrapper/downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.directory_upgrade", true);
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--print-to-pdf"); // to disable browser extension popup
		options.addArguments("disable-popup-blocking");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		WebDriver driver = new ChromeDriver(cap);
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

	private WebDriver setChromeDriverConfig(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		String downloadFilepath = "/Users/rafaelferreira/Projetos/AMWebCrawler/galacticoScrapper/downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		//chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.directory_upgrade", true);
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--print-to-pdf"); // to disable browser extension popup
		options.addArguments("disable-popup-blocking");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);
		driver = new ChromeDriver(cap);
		return driver;
	}

	private void executeScrapperForMocks(WebDriver driver) {

		try {
			//mockSrapperJob.accessArisp(driver);
			mockSrapperJob.accessArpenp(driver);
//			mockSrapperJob.accessCadesp(driver);
//			mockSrapperJob.accessCaged(driver);
//			mockSrapperJob.accessCensec(driver);
//			mockSrapperJob.accessDetran(driver);
//			mockSrapperJob.accessInfocrim(driver);
//			mockSrapperJob.accessSiel(driver);
//			mockSrapperJob.accessSivec(driver);
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
