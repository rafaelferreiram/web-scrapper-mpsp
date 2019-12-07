package br.com.galaticos.galacticoScrapper.constants;

import org.springframework.beans.factory.annotation.Value;

public class CagedConstans {
	
	@Value("${galaticos.webdriver.chrome.caged.pag-one}")
	public String pageOne;

	@Value("${galaticos.webdriver.chrome.caged.pag-two}")
	public String pageTwo;
	
	@Value("${galaticos.webdriver.chrome.caged.pag-three}")
	public String pageThree;
	
	@Value("${galaticos.webdriver.chrome.caged.pag-four}")
	public String pageFour;

	@Value("${galaticos.webdriver.chrome.caged.pag-five}")
	public String pageFive;
}
