package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Jucesp;
import br.com.galaticos.galacticoScrapper.repository.JucespRepository;

@Service
public class JucespJob {

	@Autowired
	private JucespRepository repository;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(JucespJob.class);
	
	public void getElementsFromScreenJucesp(WebDriver driver) {
		Jucesp jucesp = populateJucesp(driver);
		logger.info(jucesp.toString());
		repository.save(jucesp);
		logger.info("JUCESP Saved");

	}

	private Jucesp populateJucesp(WebDriver driver) {
		Jucesp jucesp = new Jucesp();
		
		jucesp.setNire(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[1]/td[1]/p[2]/span")).getText());
		jucesp.setTipoEmpresa(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[1]/td[2]/p[2]/span")).getText());
		jucesp.setDtConst(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[3]/td[1]/p[2]/span")).getText());
		jucesp.setInicioAtividade(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[3]/td[2]/p[2]/span")).getText());
		jucesp.setCnpj(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[3]/td[3]/p[2]/span")).getText());
		jucesp.setObjetoDescricao(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[5]/td/p[2]/span")).getText());
		jucesp.setCapital(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[1]/tbody/tr[7]/td/p[2]/span")).getText());
		jucesp.setLogradouro(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[1]/td[1]/p[2]/span")).getText());
		jucesp.setNumero(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[1]/td[2]/p[2]/span")).getText());
		jucesp.setBairro(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[2]/td[1]/p[2]/span")).getText());
		jucesp.setComplemento(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[2]/td[2]/p[2]/span")).getText());
		jucesp.setMunicipio(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[3]/td[1]/p[2]/span")).getText());
		jucesp.setCep(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[3]/td[2]/p[2]/span")).getText());
		jucesp.setUf(driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div/div[1]/div[1]/table[2]/tbody/tr[3]/td[3]/p[2]/span")).getText());
		return jucesp;
	}

	
}
