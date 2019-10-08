package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.model.Jucesp;
import br.com.galaticos.galacticoScrapper.repository.JucespRepository;

@RestController
@RequestMapping("/jucesp")
public class JucespController {

	@Autowired
	private JucespRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Jucesp>> getJucesp(){
		return ResponseEntity.ok().body(repository.findAll());
	}
}
