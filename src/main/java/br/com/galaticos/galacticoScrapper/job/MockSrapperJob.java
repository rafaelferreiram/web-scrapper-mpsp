package br.com.galaticos.galacticoScrapper.job;

import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jhonnymertz.wkhtmltopdf.wrapper.Pdf;
import com.github.jhonnymertz.wkhtmltopdf.wrapper.configurations.WrapperConfig;
import com.itextpdf.text.DocumentException;

import br.com.galaticos.galacticoScrapper.constants.ArispConstants;
import br.com.galaticos.galacticoScrapper.constants.ArpenpConstants;
import br.com.galaticos.galacticoScrapper.constants.CadespConstants;
import br.com.galaticos.galacticoScrapper.constants.CagedConstans;
import br.com.galaticos.galacticoScrapper.constants.MockConstants;

@Service
public class MockSrapperJob {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockSrapperJob.class);

	@Autowired
	private ArpenpJob arpenpJob;

	@Autowired
	private CadespJob cadespJob;

	@Autowired
	private CagedJob cagedJob;

	@Autowired
	private CensecJob censecJob;

	@Autowired
	private SielJob sielJob;

	@Autowired
	private SivecJob sivecJob;

	@Autowired
	private JucespJob jucespJob;

	@Autowired
	private DetranJob detranJob;

	public boolean login(WebDriver driver) {
		boolean logged = Boolean.FALSE;
		WebElement loginInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));

		loginInput.sendKeys(MockConstants.LOGIN);
		passwordInput.sendKeys(MockConstants.PASSWORD);

		driver.findElement(By.tagName("button")).click();
		if (!driver.getCurrentUrl().equals(MockConstants.URL)) {
			logged = Boolean.TRUE;
		}
		return logged;
	}
	

	public void accessArisp(WebDriver driver) throws IOException {
		ArispConstants arispConstants = new ArispConstants();
		driver.get(arispConstants.pageOne);
		logger.info("Got into ARISP");
		driver.get(arispConstants.pageTwo);
		driver.findElement(By.id("Prosseguir")).click();
		driver.findElement(By.className("selectorAll"));
		driver.findElement(
				By.xpath(arispConstants.pageTwoButton)).click();
		driver.get(arispConstants.pageThree);
		driver.findElement(By.id("btnPesquisar")).click();
		driver.get(arispConstants.pageFour);
		driver.get(arispConstants.pageFive);
		driver.findElement(By.xpath("/html/body/a")).click();
		goHome(driver);

	}

	public void accessArpenp(WebDriver driver) throws IOException {
		try {
			ArpenpConstants arpenpConstants = new ArpenpConstants();
			driver.get(arpenpConstants.pageOne);
			logger.info("Got into ARPENP");
			driver.get(arpenpConstants.pageTwo);
			driver.findElement(By.id("btn_pesquisar")).click();
			arpenpJob.getElementsFromScreenArpenp(driver);
			goHome(driver);
		} catch (Exception e) {

		}
	}

	public void accessCadesp(WebDriver driver) throws IOException {
		try {
			CadespConstants cadespConstants = new CadespConstants();
			driver.get(cadespConstants.pageOne);
			logger.info("Got into CADESP");
			driver.get(cadespConstants.pageTwo);
			driver.findElement(
					By.id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_btnConsultarEstabelecimento"))
					.click();
			cadespJob.getElementsFromScreenCadesp(driver);
			goHome(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void accessCaged(WebDriver driver) throws IOException {
		try {
			CagedConstans cagedConstants = new CagedConstans();
			driver.get(cagedConstants.pageOne);
			logger.info("Got into CAGED");
			driver.findElement(By.id("btn-submit")).click();
			driver.get(cagedConstants.pageTwo);
			driver.findElement(By.id("formPesquisarAutorizado:bt027_8")).click();
			cagedJob.getElementsFromScreenCaged(driver);
			driver.get(cagedConstants.pageThree);
			driver.findElement(By.id("formPesquisarEmpresaCAGED:btConsultar")).click();
			logger.info(driver.getCurrentUrl());
			cagedJob.getElementsFromScreenCaged(driver);
			driver.get(cagedConstants.pageFour);
			driver.findElement(By.id("formPesquisarTrabalhador:submitPesqTrab")).click();
			cagedJob.getElementsFromScreenCaged(driver);
			driver.get(cagedConstants.pageFive);
			goHome(driver);
		} catch (Exception e) {
		}
	}

	public void accessCensec(WebDriver driver) throws IOException {
		try {
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/censec/login.html");
			WebElement loginInput = driver.findElement(By.id("LoginTextBox"));
			WebElement passwordInput = driver.findElement(By.id("SenhaTextBox"));
			loginInput.sendKeys(MockConstants.LOGIN);
			passwordInput.sendKeys(MockConstants.PASSWORD);

			driver.findElement(By.id("EntrarButton")).click();
			if (!driver.getCurrentUrl().equals(MockConstants.URL)) {
				logger.info("Got into CENSEC");

				driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/censec/pagina3-pesquisa.html");
				driver.get(
						"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/censec/pagina5-dados.html?__VIEWSTATEGENERATOR=128406E2&__SCROLLPOSITIONX=0&__SCROLLPOSITIONY=670&ctl00%24ContentPlaceHolder1%24NomeTextBox=&ctl00%24ContentPlaceHolder1%24DocumentoTextBox=19.811.201%2F0001-05&ctl00%24ContentPlaceHolder1%24IdentidadeTextBox=&ctl00%24ContentPlaceHolder1%24ComplementoTextBox=&ctl00%24ContentPlaceHolder1%24LivroTextBox=&ctl00%24ContentPlaceHolder1%24FolhaTextBox=&ctl00%24ContentPlaceHolder1%24TipoAtoDropDownList=0&ctl00%24ContentPlaceHolder1%24DataDeTextBox=&ctl00%24ContentPlaceHolder1%24DataAteTextBox=&ctl00%24ContentPlaceHolder1%24UFDropDownList=0&ctl00%24ContentPlaceHolder1%24MunicipioDropDownList=0&ctl00%24ContentPlaceHolder1%24CartorioDropDownList=0&ctl00%24ContentPlaceHolder1%24txtCaptcha=&ctl00%24ContentPlaceHolder1%24VisualizarButton=Visualizar");
				censecJob.getElementsFromScreenCensec(driver);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void accessSiel(WebDriver driver) throws IOException {
		try {
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/siel/login.html");

			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/form/table/tbody/tr[3]/td[2]/input")).click();
			logger.info("Got into SIEL");
			WebElement inputName = driver.findElement(
					By.xpath("/html/body/div[1]/div[1]/div[4]/form[2]/fieldset[1]/table/tbody/tr[1]/td[2]/input"));
			inputName.sendKeys("KLAUS TORRES CAMARA");
			WebElement nmProcesso = driver.findElement(
					By.xpath("/html/body/div[1]/div[1]/div[4]/form[2]/fieldset[2]/table[1]/tbody/tr/td[2]/input"));
			nmProcesso.sendKeys("889532255");
			driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/form[2]/table/tbody/tr/td[2]/input")).click();
			driver.get(
					"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/siel/pagina3-dados.html?nome=KLAUS+TORRES+CAMARA&nome_mae=&dt_nascimento=&num_titulo=&num_processo=889532255&x=45&y=12");
			sielJob.getElementsFromScreenSiel(driver);
			goHome(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void accessSivec(WebDriver driver) throws IOException {
		try {
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/sivec/login.html");
			WebElement inputUsername = driver
					.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/div/div[2]/div[1]/input"));
			WebElement inputPassword = driver
					.findElement(By.xpath("/html/body/form/div/div[2]/div[1]/div/div[2]/div[2]/input"));
			inputUsername.sendKeys(MockConstants.LOGIN);
			inputPassword.sendKeys(MockConstants.PASSWORD);
			driver.findElement(By.id("Acessar")).click();
			if (!driver.getCurrentUrl().equals(MockConstants.URL)) {
				logger.info("Got into SIVEC");
				driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/sivec/pagina3-pesquisa-rg.html");
				WebElement inputRG = driver.findElement(By.xpath("/html/body/form/div/div[5]/div/div/input"));
				inputRG.sendKeys("12312321");
				driver.findElement(By.id("procurar")).click();

				driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/sivec/pagina7-dados.html");
				sivecJob.getElementsFromScreenSivec(driver);
				goHome(driver);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void accessDetran(WebDriver driver) throws InterruptedException {
		try {
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/detran/login.html");
			logger.info("Got into DETRAN");
			WebElement input = driver.findElement(By.xpath(
					"/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[2]/div[2]/table[1]/tbody/tr[1]/td[2]/input"));
			input.sendKeys(MockConstants.LOGIN);
			WebElement password = driver.findElement(By.xpath(
					"/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[2]/div[2]/table[1]/tbody/tr[2]/td[2]/input"));
			password.sendKeys(MockConstants.PASSWORD);
			driver.findElement(By.id("form:j_id563205015_44efc15b")).click();
			driver.get(
					"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/detran/pagina6-relat%C3%B3rio-linha-de-vida.pdf");
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/detran/pagina5-pesquisa-veiculo.html");
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/detran/pagina7-relatório-veiculo.pdf");
			Thread.sleep(2000);
			driver.get(
					"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/detran/pagina4-pesquisa-imagem-cnh.html");
			driver.findElement(By
					.xpath("/html/body/div[4]/div/table/tbody/tr/td/div/div/form/div[1]/div[2]/table[3]/tbody/tr/td/a"))
					.click();
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/detran/pagina7-imagem-cnh.html");
			String img = driver.findElement(By.id("form:imgFoto")).getAttribute("src");
			System.out.println(img);
			detranJob.getElementsFromScreenDetran(driver, img);
			goHome(driver);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void accessInfocrim(WebDriver driver) throws IOException, DocumentException {
		try {
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/login.html");
			logger.info("Got into INFOCRIM");
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina2-pesquisa.html");
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina3-dados.html");
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina4-detalhes-bo.html");
			String urlAtual = driver.getCurrentUrl();
			try {
				logger.info("Got into PDF page INFOCRIM");
				getPdf(driver, urlAtual);
				logger.info("Wrote PDF file base on " + driver.getTitle());
			} catch (BadLocationException e) {
				logger.error("ERROR writing the PDF file base on " + driver.getTitle());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void accessJucesp(WebDriver driver) {
		try {
			driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/jucesp/index.html");
			driver.findElement(
					By.xpath("/html/body/div[4]/form/div[3]/div[4]/div[1]/div/div[1]/table/tbody/tr/td[2]/input"))
					.click();
			driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[2]/div/div/table/tbody/tr[2]/td/input"))
					.click();
			driver.findElement(By.id("ctl00_cphContent_gdvResultadoBusca_gdvContent_ctl02_lbtSelecionar")).click();
			jucespJob.getElementsFromScreenJucesp(driver);
			driver.get(
					"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/jucesp/pagina6-ficha-cadastral-simplificada-relatorio.pdf");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void goHome(WebDriver driver) {
		driver.get(MockConstants.URL_HOME);
	}

	private void getPdf(WebDriver driver, String urlPdf) throws IOException, DocumentException, BadLocationException {
		try {
			Pdf pdf = new Pdf(new WrapperConfig("/usr/local/bin/wkhtmltopdf"));//
			pdf.addPageFromUrl(driver.getCurrentUrl());
			pdf.saveAs(System.getProperty("user.dir") + "/downloads/" + driver.getTitle() + ".pdf");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
