package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Detran;
import br.com.galaticos.galacticoScrapper.repository.DetranRepository;

@Service
public class DetranJob {

	@Autowired
	private DetranRepository repository;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DetranJob.class);

	public void getElementsFromScreenDetran(WebDriver driver, String img) {
		Detran detran = populateDetran(driver);
		detran.setCaminhoImg(img);
		logger.info(detran.toString());
		repository.save(detran);
		logger.info("Detran Saved");

	}

	private Detran populateDetran(WebDriver driver) {
		Detran detran = new Detran();
		detran.setRenach(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/span")).getText());
		detran.setCategoria(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[2]/span")).getText());
		detran.setEmissao(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[3]/span")).getText());
		detran.setNascimento(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/table/tbody/tr/td[4]/span")).getText());
		detran.setNomeCondutor(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/span")).getText());
		detran.setNomePai(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/span")).getText());
		detran.setNomeMae(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td/span")).getText());
		detran.setRegistro(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[1]/span")).getText());
		detran.setTipografico(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[2]/span")).getText());
		detran.setIdentidade(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[3]/span")).getText());
		detran.setCpf(driver.findElement(By.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr/td[4]/span")).getText());
		return detran;
	}
}
