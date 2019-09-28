package br.com.galaticos.galacticoScrapper.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.galaticos.galacticoScrapper.service.MockScrapper;


@Controller
@RequestMapping("/mpsp")
public class ScrapperController {
	
	@Autowired
	private MockScrapper mockScrapper;
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/scrapping")
	public ResponseEntity scraping(@RequestParam(value = "active") boolean isActive) {
		boolean response = mockScrapper.initCrawaler(isActive);
		return  ResponseEntity.status(HttpStatus.OK).body(String.valueOf(response));
	}
	

}

