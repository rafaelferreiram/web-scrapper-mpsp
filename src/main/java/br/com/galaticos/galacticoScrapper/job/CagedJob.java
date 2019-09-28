package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Caged;

@Service
public class CagedJob {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CagedJob.class);

	public void getElementsFromScreenCagedTrabalhador(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void getElementsFromScreenCagedEmpresa(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void getElementsFromScreenCaged(WebDriver driver) {
		Caged caged = populateCaged(driver);
		logger.info(caged.toString());

	}

	private Caged populateCaged(WebDriver driver) {
		Caged caged = new Caged();

		caged.setCnpjCeiCpf(
				driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[1]/div[1]/div/div[2]/span")).getText());
		caged.setRazaoSocial(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[1]/div[2]/div/div[2]/span")).getText());
		caged.setLogradouro(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[1]/div/div[2]/span")).getText());
		caged.setBairoo(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[2]/div/div[2]/span")).getText());
		caged.setMunicipio(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[3]/div/div[2]")).getText());
		caged.setUf(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[4]/div[1]/div[2]/span")).getText());
		caged.setCep(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[4]/div[2]/div[2]/span")).getText());
		caged.setNome(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[1]/div/div[2]/span")).getText());
		caged.setCpf(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[2]/div/div[2]/span")).getText());
		caged.setTelefone(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[3]/div[1]/div[2]")).getText());
		caged.setRamal(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[3]/div[2]/div[2]/span")).getText());
		caged.setEmail(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div[4]/div/div[2]/span")).getText());
		return caged;
	}

}
