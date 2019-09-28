package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;
import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;

@Service
public class CagedJob {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CagedJob.class);

	public void getElementsFromScreenCagedTrabalhador(WebDriver driver) {
		CagedTrabalhador cagedTrabalhador = populateCagedTrabalhador(driver);
		logger.info(cagedTrabalhador.toString());
	}

	private CagedTrabalhador populateCagedTrabalhador(WebDriver driver) {
		CagedTrabalhador cagedTrabalhador = new CagedTrabalhador();
		cagedTrabalhador.setNome(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[1]/div[1]/div/div[2]/span")).getText());
		cagedTrabalhador.setPis(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[1]/div[2]/div/div[2]/span")).getText());
		cagedTrabalhador.setCpf(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[1]/div[1]/div[2]/span")).getText());
		cagedTrabalhador.setDtNascimento(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[1]/div[2]/div[2]/span")).getText());
		cagedTrabalhador.setCtps(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[2]/div[1]/div[2]/span")).getText());
		cagedTrabalhador.setSituacaoPis(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[3]/div[1]/div[2]/span")).getText());
		cagedTrabalhador.setSexo(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[3]/div[2]/div[2]/span")).getText());
		cagedTrabalhador.setNacionalidade(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[4]/div[1]/div[2]")).getText());
		cagedTrabalhador.setRacaCor(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[4]/div[2]/div[2]")).getText());
		cagedTrabalhador.setGrauInstituicao(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[5]/div/div[2]")).getText());
		cagedTrabalhador.setPossuiDeficiencia(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[2]/div[6]/div[1]/div[2]/span")).getText());
		cagedTrabalhador.setCaged(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div/div[1]/div[2]/span")).getText());
		cagedTrabalhador.setRais(driver.findElement(By.xpath("/html/body/div[2]/div[6]/fieldset[3]/div/div[2]/div[2]/span")).getText());
		return cagedTrabalhador;
	}

	public void getElementsFromScreenCagedEmpresa(WebDriver driver) {
		CagedEmpresa cagedEmpresa = populateCagedEmpresa(driver);
		logger.info(cagedEmpresa.toString());
	}

	public void getElementsFromScreenCaged(WebDriver driver) {
		Caged caged = populateCaged(driver);
		logger.info(caged.toString());

	}

	private CagedEmpresa populateCagedEmpresa(WebDriver driver) {
		CagedEmpresa cagedEmpresa = new CagedEmpresa();
		cagedEmpresa.setCnpj(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[1]/div[1]/div/div[2]/span")).getText());
		cagedEmpresa.setRazaoSocial(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[1]/div[2]/div/div[2]/span")).getText());
		cagedEmpresa.setAtividadeEconomica(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[1]/div[3]/div/div[2]")).getText());
		cagedEmpresa.setNumeroFiliais(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[1]/div[1]/div[2]/span")).getText());
		cagedEmpresa.setTotalVinculos(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[1]/div[2]/div[2]/span")).getText());
		cagedEmpresa.setPrimeiroDia(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[1]/div[3]/div[2]/span")).getText());
		cagedEmpresa.setAdmissoes(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[2]/div[1]/div[2]/span")).getText());
		cagedEmpresa.setDesligamentos(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[2]/div[2]/div[2]/span")).getText());
		cagedEmpresa.setUltimoDia(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[2]/div[3]/div[2]/span")).getText());
		cagedEmpresa.setVariacaoAbsoluta(driver.findElement(By.xpath("/html/body/div[2]/div[6]/form/fieldset[2]/div[3]/div/div[2]/span")).getText());
		return cagedEmpresa;
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
