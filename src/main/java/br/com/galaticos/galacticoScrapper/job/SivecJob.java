package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Sivec;
import br.com.galaticos.galacticoScrapper.repository.SivecRepository;

@Service
public class SivecJob {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperJob.class);

	@Autowired
	private SivecRepository repository;
	
	public void getElementsFromScreenSivec(WebDriver driver) {
		Sivec sivec = populateSivec(driver);
		logger.info(sivec.toString());
		repository.save(sivec);
		logger.info("SIVEC Saved");
	}

	private Sivec populateSivec(WebDriver driver) {
		Sivec sivec = new Sivec();
		sivec.setNome(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[1]/td[2]/span")).getText());
		sivec.setSexo(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[1]/td[5]/span")).getText());
		sivec.setDtNascimento(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[2]/td[2]/span")).getText());
		sivec.setRg(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[2]/td[5]/span")).getText());
		sivec.setTipoRg(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[2]/table/tbody/tr[3]/td[5]/span")).getText());
		sivec.setEmissaoRg(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[1]/td[2]/span")).getText());
		sivec.setAlcunha(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[1]/td[5]/span")).getText());
		sivec.setEstadoCivil(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[2]/td[2]/span")).getText());
		sivec.setNaturalidade(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[2]/td[5]/span")).getText());
		sivec.setNaturalizado(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[3]/td[2]/span")).getText());
		sivec.setPostoIdentificacao(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[3]/td[5]")).getText());
		sivec.setGrauInstituicao(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[4]/td[2]/span")).getText());
		sivec.setFormulaFundamental(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[4]/td[5]/span")).getText());
		sivec.setNomePai(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[5]/td[2]/span")).getText());
		sivec.setNomeMae(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[6]/td[2]/span")).getText());
		sivec.setCorPele(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[7]/td[2]/span")).getText());
		sivec.setProfissao(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[7]/td[5]/span")).getText());
		sivec.setCabelo(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[6]/td[5]/span")).getText());
		sivec.setCorOlhos(driver.findElement(By.xpath("/html/body/form[1]/div/div[5]/div[4]/table/tbody/tr[5]/td[5]")).getText());
		//endereco
		sivec.setResidencial(driver.findElement(By.xpath("/html/body/form[1]/div/div[7]/div[2]/span")).getText());
		sivec.setTrabalho(driver.findElement(By.xpath("/html/body/form[1]/div/div[8]/div[2]/span")).getText());
		//outros
		sivec.setNomeOutros(driver.findElement(By.xpath("/html/body/form[1]/div/div[10]/div[2]/span")).getText());
		sivec.setNacionalidadeOutros(driver.findElement(By.xpath("/html/body/form[1]/div/div[13]/div[2]/span")).getText());
		sivec.setNomePaiOutros(driver.findElement(By.xpath("/html/body/form[1]/div/div[14]/div[2]/span")).getText());
		sivec.setNomeMaeOutros(driver.findElement(By.xpath("/html/body/form[1]/div/div[15]/div[2]/span")).getText());
		return sivec;
	}
}
