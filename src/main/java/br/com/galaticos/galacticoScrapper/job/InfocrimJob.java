package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Infocrim;

@Service
public class InfocrimJob {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(InfocrimJob.class);

	public void getElementsFromScreen(WebDriver driver) {
		Infocrim infoCrim = populateInfocrim(driver);
		logger.info(infoCrim.toString());
	}

	private Infocrim populateInfocrim(WebDriver driver) {
		Infocrim infoCrim = new Infocrim();
		infoCrim.setDependencia(driver.findElement(By.xpath("/html/body/pre[1]/text()[1]")).getText());
		infoCrim.getDependencia();
		return infoCrim;
	}
}
