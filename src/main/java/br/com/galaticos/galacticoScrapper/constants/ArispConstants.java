package br.com.galaticos.galacticoScrapper.constants;

import org.springframework.beans.factory.annotation.Value;

public class ArispConstants {

	@Value("${galaticos.webdriver.chrome.arisp.pag-one}")
	public String pageOne;

	@Value("${galaticos.webdriver.chrome.arisp.pag-two}")
	public String pageTwo;

	@Value("${galaticos.webdriver.chrome.arisp.pag-two.button}")
	public String pageTwoButton;

	@Value("${galaticos.webdriver.chrome.arisp.pag-three}")
	public String pageThree;

	@Value("${galaticos.webdriver.chrome.arisp.pag-four}")
	public String pageFour;

	@Value("${galaticos.webdriver.chrome.arisp.pag-five}")
	public String pageFive;

}
