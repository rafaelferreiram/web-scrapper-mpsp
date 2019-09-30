package br.com.galaticos.galacticoScrapper.job;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.galaticos.galacticoScrapper.model.Censec;

@Service
public class CensecJob {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CensecJob.class);

	public void getElementsFromScreenCensec(WebDriver driver) {
		Censec censec = populateCensec(driver);
		logger.info(censec.toString());
	}

	private Censec populateCensec(WebDriver driver) {
		Censec censec = new Censec();
		censec.setCarga(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[1]/div/input"))
				.getAttribute("value"));
		censec.setDtMesAno(driver
				.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[2]/div/select[1]")).getText()
				+ driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[2]/div/select[2]"))
						.getText());
		censec.setAto(
				driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[3]/div/div/select"))
						.getText());
		censec.setDtAto(driver
				.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[6]/div/input[1]"))
				.getAttribute("value")
				+ "/"
				+ driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[6]/div/input[3]"))
						.getAttribute("value")
				+ "/"
				+ driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[6]/div/input[4]"))
						.getAttribute("value"));
		censec.setLivro(
				driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[7]/div/input[1]"))
						.getAttribute("value"));
		censec.setComplemento(
				driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[8]/div/div/input"))
						.getAttribute("value"));
		censec.setFolha(
				driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[3]/div[9]/div/input[1]"))
						.getAttribute("value"));
		censec.setUf(driver
				.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[1]/div[1]/div/input"))
				.getAttribute("value"));
		censec.setMunicipio(driver
				.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[1]/div[2]/div/input"))
				.getAttribute("value"));
		censec.setCartorio(driver
				.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[1]/div[3]/div/input"))
				.getAttribute("value"));
		censec.setNome(getListOfNames(driver));	
		censec.setCpfCnpj(getListOfCps(driver));
		censec.setQualidade(getListOfQualities(driver));
		censec.setTelefone(getListOfNumbers(driver));
		censec.setTipo(getListOfTypes(driver));
		censec.setContato(getListOfContacts(driver));
		censec.setStatus(getListOfStatus(driver));
		return censec;
	}

	private List<String> getListOfStatus(WebDriver driver) {
		List<String> listStatus =  new ArrayList<String>();
		listStatus.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[1]/td[5]")).getText());
		listStatus.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[2]/td[5]")).getText());
		return listStatus;
	}

	private List<String> getListOfContacts(WebDriver driver) {
		List<String> listContacts =  new ArrayList<String>();
		listContacts.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[1]/td[4]")).getText());
		listContacts.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[2]/td[4]")).getText());
		return listContacts;
	}

	private List<String> getListOfTypes(WebDriver driver) {
		List<String> listTypes =  new ArrayList<String>();
		listTypes.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
		listTypes.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[2]/td[2]")).getText());
		return listTypes;
	}

	private List<String> getListOfNumbers(WebDriver driver) {
		List<String> listNumbers =  new ArrayList<String>();
		listNumbers.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]")).getText());
		listNumbers.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[7]/div[2]/div[2]/div/table/tbody/tr[2]/td[1]")).getText());
		return listNumbers;
	}

	private List<String> getListOfQualities(WebDriver driver) {
		List<String> listQualities =  new ArrayList<String>();
		listQualities.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[1]/td[4]")).getText());
		listQualities.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[2]/td[4]")).getText());
		listQualities.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[3]/td[4]")).getText());
		listQualities.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[4]/td[4]")).getText());
		return listQualities;
	}

	private List<String> getListOfCps(WebDriver driver) {
		List<String> listCpfs =  new ArrayList<String>();
		listCpfs.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[1]/td[3]")).getText());
		listCpfs.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[2]/td[3]")).getText());
		listCpfs.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[3]/td[3]")).getText());
		listCpfs.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[4]/td[3]")).getText());
		return listCpfs;
	}

	private List<String> getListOfNames(WebDriver driver) {
		List<String> listNames =  new ArrayList<String>();
		listNames.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[1]/td[2]")).getText());
		listNames.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[2]/td[2]")).getText());
		listNames.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[3]/td[2]")).getText());
		listNames.add(driver.findElement(By.xpath("/html/body/form/div[5]/div/div[3]/div[2]/div[6]/div[1]/div/div/table/tbody/tr[4]/td[2]")).getText());
		return listNames;
	}

}
