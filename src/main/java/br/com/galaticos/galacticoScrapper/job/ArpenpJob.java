package br.com.galaticos.galacticoScrapper.job;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClients;

import br.com.galaticos.galacticoScrapper.model.Arpenp;
import br.com.galaticos.galacticoScrapper.repository.ArpenpRepository;

@Service
public class ArpenpJob {

	@Autowired
	private ArpenpRepository repository;

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ArpenpJob.class);

	public void getElementsFromScreenArpenp(WebDriver driver) {
		Arpenp arpenp = new Arpenp();
		WebElement table = driver.findElement(By.name("form_registro"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				if (cell.getText().contains(":")) {
					continue;
				} else {
					arpenp = populateArpenp(cell, arpenp);
				}
			}
		}
		repository.save(arpenp);
		logger.info("ARPENP Saved");

	}

	private Arpenp populateArpenp(WebElement cell, Arpenp arpenp) {
		if ("S�o Paulo - 8� Subdistrito - Santana".equals(cell.getText())) {
			arpenp.setCartorio(cell.getText().toString());
		} else if ("11914-9".equals(cell.getText())) {
			arpenp.setCns(cell.getText());
		} else if ("SP".equals(cell.getText())) {
			arpenp.setUf(cell.getText());
		} else if ("Antonio TORRES Coutinho".equals(cell.getText())) {
			arpenp.setConjuge(cell.getText());
			arpenp.setConjugeNovoNome("");
		} else if ("Ellen MARCIA FERNANDES SILVEIRA".equals(cell.getText())) {
			arpenp.setConjuge2(cell.getText());
		} else if ("Ellen MARCIA FERNANDES SILVEIRA Coutinho".equals(cell.getText())) {
			arpenp.setConjuge2NovoNome(cell.getText());
		} else if ("19/03/2015".equals(cell.getText())) {
			arpenp.setDtCasamento(cell.getText());
		} else if ("11914901552015200133237003919491".equals(cell.getText())) {
			arpenp.setMatricula(cell.getText());
		} else if ("23/03/2015".equals(cell.getText())) {
			arpenp.setDtEntrada(cell.getText());
		} else if ("19/03/2015".equals(cell.getText())) {
			arpenp.setDtRegistro(cell.getText());
		} else if ("01".equals(cell.getText())) {
			arpenp.setAcervo(cell.getText());
		} else if ("00133".equals(cell.getText())) {
			arpenp.setNumeroLivro(cell.getText());
		} else if ("237".equals(cell.getText())) {
			arpenp.setNumeroFolha(cell.getText());
		} else if ("0039194".equals(cell.getText())) {
			arpenp.setNumeroRegistro(cell.getText());
		} else if ("B".equals(cell.getText())) {
			arpenp.setTipoLivro(cell.getText());
		}
		return arpenp;
	}
}
