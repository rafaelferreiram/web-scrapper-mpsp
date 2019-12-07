package br.com.galaticos.galacticoScrapper.constants;

import org.springframework.beans.factory.annotation.Value;

public class ArpenpConstants {

	@Value("${galaticos.webdriver.chrome.arpenp.pag-one}")
	public String pageOne;

	@Value("${galaticos.webdriver.chrome.arpenp.pag-two}")
	public String pageTwo;

}
