package br.com.galaticos.galacticoScrapper.job;

import java.awt.print.PageFormat;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.text.BadLocationException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.qoppa.pdfWriter.PDFDocument;

import br.com.galaticos.galacticoScrapper.constants.MockConstants;
import br.com.galaticos.galacticoScrapper.dto.LoginDTO;

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

	public boolean login(LoginDTO login, WebDriver driver) {
		boolean logged = Boolean.FALSE;
		WebElement loginInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		loginInput.sendKeys(login.getUser());
		passwordInput.sendKeys(login.getPassword());

		driver.findElement(By.tagName("button")).click();
		if (!driver.getCurrentUrl().equals(login.getUrl())) {
			logged = Boolean.TRUE;
		}
		return logged;

	}

	public void accessArisp(WebDriver driver) throws IOException {
		driver.get(
				"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arisp/pagina2-escolha-estado.html?Challenge=Ii4le6%2F%2BdqRYd7gQKClUHg%3D%3D&Response=&Certificate=&Method=new");
		logger.info("Got into ARISP");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arisp/pagina4-tipo-de-pesquisa.html");
		driver.findElement(By.id("Prosseguir")).click();
		driver.findElement(By.className("selectorAll"));
		driver.findElement(
				By.xpath("/html/body/section/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div/input")).click();
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arisp/pagina6-escolha-cartorios.html");
		driver.findElement(By.id("btnPesquisar")).click();
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arisp/pagina8-matriculas.html");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arisp/pagina10-visualizar-matriculas.htm");
		takeScreenShot(driver, "Arisp");
		driver.findElement(By.xpath("/html/body/a")).click();
		goHome(driver);

	}

	public void accessArpenp(WebDriver driver) throws IOException {
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arpensp/pagina2-pesquisa.html");
		logger.info("Got into ARPENP");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arpensp/pagina3-busca.html");
		driver.findElement(By.id("btn_pesquisar")).click();
		arpenpJob.getElementsFromScreenArpenp(driver);
		takeScreenShot(driver, "Arpenp");
		goHome(driver);
	}

	public void accessCadesp(WebDriver driver) throws IOException {
		driver.get(
				"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/cadesp/pagina2-pesquisa.html?__LASTFOCUS=&__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUKMTc2NDcwNjI0Ng9kFgJmD2QWBAIBD2QWAgIMDxUFMS8oUyhncnVseTJ1eG90amZmZzQ1bHo0dWNpejIpKS9TY3JpcHRzL2ZhemVuZGEuanM9LyhTKGdydWx5MnV4b3RqZmZnNDVsejR1Y2l6MikpL1NjcmlwdHMvTW9uaXRvckludGVyZmFjZVJGQi5qczQvKFMoZ3J1bHkydXhvdGpmZmc0NWx6NHVjaXoyKSkvU2NyaXB0cy9DYWRlc3BVdGlsLmpzRi8oUyhncnVseTJ1eG90amZmZzQ1bHo0dWNpejIpKS9TY3JpcHRzL1Byb2Nlc3NhbWVudG9Tb2xpY2l0YWNvZXNSRkIuanNGLyhTKGdydWx5MnV4b3RqZmZnNDVsejR1Y2l6MikpL1NjcmlwdHMvQWx0ZXJhY29lcy9BbHRlcmFjYW9EZU9maWNpby5qc2QCAw9kFgQCCw9kFgRmD2QWAmYPZBYEAgEPPCsACgEADxYCHgtGYWlsdXJlVGV4dGVkFgJmD2QWDAIBDxAPFgIeC18hRGF0YUJvdW5kZ2QQFQocU2VsZWNpb25lIG8gdGlwbyBkZSB1c3XDoXJpbwxDb250YWJpbGlzdGEMQ29udHJpYnVpbnRlA0NSQwtGYXplbmTDoXJpbwZKdWNlc3ADUEdFClByb21vdG9yaWEPUmVjZWl0YSBGZWRlcmFsA1RSVBUKAi0xBUNPTlRBBUNPTlRSA0NSQwVTRUZBWgVKVUNFUwVQUk9DVQVQUk9NTwNSRkIDVFJUFCsDCmdnZ2dnZ2dnZ2cWAQIHZAILDxYCHgdWaXNpYmxlaGQCEQ8PFgIeBFRleHRlZGQCEw8PFgIeB0VuYWJsZWRoZGQCFQ8PFgIfA2VkZAIXDw8WBB8EaB8CaGRkAgMPDxYCHwNlZGQCAg8PFgIfAwUNQ29udHJpYnVpbnRlc2RkAg0PDxYCHwMFD1ZlcnPDo286IDMuNjMuMGRkGAEFHl9fQ29udHJvbHNSZXF1aXJlUG9zdEJhY2tLZXlfXxYDBVRjdGwwMCRjb250ZXVkb1BhZ2luYVBsYWNlSG9sZGVyJGxvZ2luQ29udHJvbCRGZWRlcmF0ZWRQYXNzaXZlU2lnbkluQ2VydGlmaWNhZG8kY3RsMDQFWWN0bDAwJGNvbnRldWRvUGFnaW5hUGxhY2VIb2xkZXIkbG9naW5Db250cm9sJEZlZGVyYXRlZFBhc3NpdmVTaWduSW5DZXJ0aWZpY2FkbyRyZW1lbWJlck1lBTZjdGwwMCRjb250ZXVkb1BhZ2luYVBsYWNlSG9sZGVyJGxvZ2luQ29udHJvbCRmYXFCdXR0b258UkM0PzzCjEk%2BocM5AFdyOekwvw%3D%3D&__VIEWSTATEGENERATOR=D44F3332&__EVENTVALIDATION=%2FwEWFQKtiI%2F1BgL2y5R1AvWk8pgMAv6%2Fmp0LAoO4mp0LAq7Cma8MAoOK9Z8LArLO7LsKAtapoMYDAvypuKMHArjri7ECAqSU2e4EApaY3dkKAqqh%2BtgGAvf8xI8DApuYwPcDAvjProMLAqfczoMHAriv9IYNAp3G1vECAoLduNwIMoLFOrUr3LV2JMuz1LU344wz%2B9Q%3D&ctl00%24conteudoPaginaPlaceHolder%24loginControl%24TipoUsuarioDropDownList=PROMO&ctl00%24conteudoPaginaPlaceHolder%24loginControl%24UserName=fiap&ctl00%24conteudoPaginaPlaceHolder%24loginControl%24Password=mpsp");
		logger.info("Got into CADESP");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/cadesp/pagina3-pesquisa.html");
		driver.findElement(
				By.id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_btnConsultarEstabelecimento"))
				.click();
		cadespJob.getElementsFromScreenCadesp(driver);
		takeScreenShot(driver, "Cadesp");
		goHome(driver);
	}

	public void accessCaged(WebDriver driver) throws IOException {
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/login.html");
		logger.info("Got into CAGED");
		driver.findElement(By.id("btn-submit")).click();
		driver.get(
				"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/pagina3-consulta-autorizado-responsavel.html");
		driver.findElement(By.id("formPesquisarAutorizado:bt027_8")).click();
		cagedJob.getElementsFromScreenCaged(driver);
		takeScreenShot(driver, "Caged");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/pagina4-consulta-empresa.html");
		driver.findElement(By.id("formPesquisarEmpresaCAGED:btConsultar")).click();
		logger.info(driver.getCurrentUrl());
		cagedJob.getElementsFromScreenCaged(driver);
		takeScreenShot(driver, "Caged/Empresa");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/pagina6-consulta-trabalhador.html");
		driver.findElement(By.id("formPesquisarTrabalhador:submitPesqTrab")).click();
		cagedJob.getElementsFromScreenCaged(driver);
		takeScreenShot(driver, "Caged/Trabalhador");
		driver.get(
				"http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/pagina10-relatorio-vinculos-trabalhador.pdf");
		takeScreenShot(driver, "Caged/Trabalhador/pdf");
		goHome(driver);
	}

	public void accessCensec(WebDriver driver) throws IOException {
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
			takeScreenShot(driver, "Censec");
		}

	}

	public void accessSiel(WebDriver driver) throws IOException {
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
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/siel/pagina3-dados.html?nome=KLAUS+TORRES+CAMARA&nome_mae=&dt_nascimento=&num_titulo=&num_processo=889532255&x=45&y=12");
		sielJob.getElementsFromScreenSiel(driver);
		takeScreenShot(driver, "Siel");
		goHome(driver);
	}

	public void accessSivec(WebDriver driver) throws IOException {
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
			takeScreenShot(driver, "Sivec");
			goHome(driver);
		}

	}

	// Private Methods
	private static void goHome(WebDriver driver) {
		driver.get(MockConstants.URL_HOME);
	}

	private static void takeScreenShot(WebDriver driver, String folder) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "/screeShots/" + folder);
		FileUtils.copyFileToDirectory(SrcFile, DestFile);
	}

	public void accessDetran(WebDriver driver) {
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
	}

	public void accessInfocrim(WebDriver driver) throws IOException, DocumentException {
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/login.html");
		logger.info("Got into INFOCRIM");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina2-pesquisa.html");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina3-dados.html");
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina4-detalhes-bo.html");
		String urlAtual = driver.getCurrentUrl();
		try {
			logger.info("Got into PDF page INFOCRIM");
			getPdf(driver,urlAtual);
			logger.info("Wrote PDF file base on "+driver.getTitle());
		} catch (BadLocationException e) {
			logger.error("ERROR writing the PDF file base on "+driver.getTitle());
		}
	}

	public void accessJucesp(WebDriver driver) {
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/jucesp/index.html");
		driver.findElement(By.xpath("/html/body/div[4]/form/div[3]/div[4]/div[1]/div/div[1]/table/tbody/tr/td[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[4]/div[2]/div/div/table/tbody/tr[2]/td/input")).click();
		driver.findElement(By.id("ctl00_cphContent_gdvResultadoBusca_gdvContent_ctl02_lbtSelecionar")).click();
		//jucespJob.getElementsFromScreenJucesp(driver);
		driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/jucesp/pagina6-ficha-cadastral-simplificada-relatorio.pdf");
	}

	private void getPdf(WebDriver driver, String urlPdf) throws IOException, DocumentException, BadLocationException {
		URL url = new URL("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/infocrim/pagina4-detalhes-bo.html");
		String downloadFilepath = System.getProperty("user.dir") + "/downloads";
		logger.info("File path: "+downloadFilepath);
		PageFormat pf = new PageFormat();
		PDFDocument pdfDoc = PDFDocument.loadHTML(url, pf, true);
		pdfDoc.saveDocument(downloadFilepath + "/" + driver.getTitle() + ".pdf");
	}


}
