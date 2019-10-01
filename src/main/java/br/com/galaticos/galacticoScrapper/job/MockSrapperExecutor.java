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
		String downloadFilepath = System.getProperty("user.dir") +"\\downloads";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("pdfjs.disabled", true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-print-preview");
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
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
