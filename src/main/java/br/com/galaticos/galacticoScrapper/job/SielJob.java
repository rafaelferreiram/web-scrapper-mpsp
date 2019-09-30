package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Siel;

@Service
public class SielJob {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SielJob.class);
	
	public void getElementsFromScreenSiel(WebDriver driver) {
		Siel siel = populateSiel(driver);
		logger.info(siel.toString());
	}

	private Siel populateSiel(WebDriver driver) {
		Siel siel = new Siel();
		siel.setNome(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[2]/td[2]")).getText());
		siel.setTitulo(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[3]/td[2]")).getText());
		siel.setDtNascimento(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[4]/td[2]")).getText());
		siel.setZone(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[5]/td[2]")).getText());
		siel.setEndereco(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[6]/td[2]")).getText());
		siel.setMunicipio(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[7]/td[2]")).getText());
		siel.setUf(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[8]/td[2]")).getText());
		siel.setDtDomicilio(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[9]/td[2]")).getText());
		siel.setNomePai(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[10]/td[2]")).getText());
		siel.setNomeMae(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[11]/td[2]")).getText());
		siel.setNaturalidade(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[12]/td[2]")).getText());
		siel.setCdValidacao(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/table/tbody/tr[13]/td[2]")).getText());
		return siel;
	}

	
}
