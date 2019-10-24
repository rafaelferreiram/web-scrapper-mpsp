package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.SielBusiness;
import br.com.galaticos.galacticoScrapper.model.Siel;

@RestController
@RequestMapping("/siel")
public class SielController {

	@Autowired
	private SielBusiness sielBusiness;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Siel>> getSiel(){
		return ResponseEntity.ok().body(sielBusiness.findAll());
	}
	
}
