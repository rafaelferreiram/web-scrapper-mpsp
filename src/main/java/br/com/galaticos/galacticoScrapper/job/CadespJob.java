package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Cadesp;
import br.com.galaticos.galacticoScrapper.repository.CadespRepository;

@Service
public class CadespJob {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CadespJob.class);

	@Autowired
	private CadespRepository repository;
	
	public void getElementsFromScreenCadesp(WebDriver driver) {
		Cadesp cadesp = populateCadesp(driver);
		logger.info(cadesp.toString());
		repository.save(cadesp);
		logger.info("CADESP Saved");
	}

	private Cadesp populateCadesp(WebDriver driver) {
		Cadesp cadesp = new Cadesp();
		cadesp.setIe(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]")).getText());
		cadesp.setCnpj(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]")).getText());
		cadesp.setNomeEmpresarial(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText());
		cadesp.setDrt(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText());
		cadesp.setSituacao(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[3]")).getText());
		cadesp.setDtInscricaoEstado(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[3]/td[3]")).getText());
		cadesp.setRegimeEstadual(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/table[1]/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[4]/td[3]")).getText());
		cadesp.setPostoFiscal(driver.findElement(By.xpath("//*[@id=\"ctl00_conteudoPaginaPlaceHolder_dlCabecalho\"]/tbody/tr/td/table/tbody/tr[5]/td[3]")).getText());
		cadesp.setNire(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/a")).getText());
		cadesp.setOcorrenciaFiscal(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]")).getText());
		cadesp.setTipoUnidade(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[10]/td[2]")).getText());
		cadesp.setFormaAtuacao(driver.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/table[2]/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[10]/td[4]/table/tbody/tr/td/table/tbody/tr/td")).getText());
		return cadesp;
	}
}
