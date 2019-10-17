package br.com.galaticos.galacticoScrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.service.MockScrapper;

@RestController
@RequestMapping("/mpsp")
public class ScrapperController {

	@Autowired
	private MockScrapper mockScrapper;

	@SuppressWarnings("rawtypes")
	@GetMapping("/scrapping")
	public ResponseEntity scraping(@RequestParam(value = "active") boolean isActive) {
		if (isActive) {
			mockScrapper.initCrawaler(isActive);
			String responseMsg = "Scappred ON [isActive=" + String.valueOf(isActive) + "]";
			return ResponseEntity.status(HttpStatus.OK).body(responseMsg);
		} else {
			String responseMsg = "Scappred OFF [isActive=" + String.valueOf(isActive) + "]";
			return ResponseEntity.status(HttpStatus.OK).body(responseMsg);
		}
	}

}
