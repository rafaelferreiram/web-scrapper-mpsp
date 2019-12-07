package br.com.galaticos.galacticoScrapper.constants;

import org.springframework.beans.factory.annotation.Value;

public class CadespConstants {

	@Value("${galaticos.webdriver.chrome.cadesp.pag-one}")
	public String pageOne;

	@Value("${galaticos.webdriver.chrome.cadesp.pag-two}")
	public String pageTwo;
}
