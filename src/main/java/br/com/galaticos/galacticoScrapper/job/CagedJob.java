package br.com.galaticos.galacticoScrapper.job;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.CagedAll;
import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;
import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;
import br.com.galaticos.galacticoScrapper.repository.CagedAllRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedEmpresaRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedTrabalhadorRepository;

@Service
public class CagedJob {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CagedJob.class);
	
	private CagedAll cagedAll = new CagedAll();
	private Caged caged;
	private CagedEmpresa cagedEmpresa; 
	private CagedTrabalhador cagedTrabalhador; 
	
	@Autowired
	private CagedRepository cagedRepository;
	
	@Autowired
	private CagedEmpresaRepository cagedEmpresaRepository;
	
	@Autowired
	private CagedTrabalhadorRepository cagedTrabalhadorRepository;
	
	@Autowired
	private CagedAllRepository cadegAllRepository;

	public void getElementsFromScreenCaged(WebDriver driver) {
		
		if(driver.getCurrentUrl().equals("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/pagina7-dados-autorizado-responsavel.html?formPesquisarAutorizado=formPesquisarAutorizado&formPesquisarAutorizado%3AslctTipoPesquisaAutorizado=1&formPesquisarAutorizado%3Aj_idt40=1&formPesquisarAutorizado%3AslctPesquisarPrimeiroAutorizado=1&formPesquisarAutorizado%3AtxtChavePesquisaAutorizado014=&formPesquisarAutorizado%3Abt027_8=Consultar&formPesquisarAutorizado%3Aj_idt66=&javax.faces.ViewState=5832164626526760368%3A-3057975735432683263")) {
			logger.info("CAGED");
			caged = populateCaged(driver);
			cagedAll.setCaged(caged);
			logger.info(caged.toString());
			cagedRepository.save(caged);
			logger.info("CAGED Saved");
		}else if (driver.getCurrentUrl().equals("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/pagina8-dados-empresa.html?formPesquisarEmpresaCAGED=formPesquisarEmpresaCAGED&formPesquisarEmpresaCAGED%3AtxtcnpjRaiz=&formPesquisarEmpresaCAGED%3AslctIdPesquisarPrimeiro=1&formPesquisarEmpresaCAGED%3AbtConsultar=Consultar&javax.faces.ViewState=5832164626526760368%3A4039376737370855809")) {
			logger.info("CAGED EMPRESA");
			cagedEmpresa =  populateCagedEmpresa(driver);
			logger.info(cagedEmpresa.toString());
			cagedAll.setCagedEmpresa(cagedEmpresa);
			cagedEmpresaRepository.save(cagedEmpresa);
			logger.info("CAGED EMPRESA Saved");
		}else {
			logger.info("CAGED TRABALHO");
			cagedTrabalhador = populateCagedTrabalhador(driver);
			logger.info(cagedTrabalhador.toString());
			cagedAll.setCagedTrabalhador(cagedTrabalhador);
			cagedTrabalhadorRepository.save(cagedTrabalhador);
			logger.info("CAGED TRABALHADOR Saved");
		}
		logger.info(cagedAll.toString());
		cadegAllRepository.save(cagedAll);
		logger.info("CAGED ALL Saved");
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
