package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.CensecBusiness;
import br.com.galaticos.galacticoScrapper.model.Censec;

@RestController
@RequestMapping("/censec")
public class CensecController {

	@Autowired
	private CensecBusiness censecBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Censec>> getCensec() {
		return ResponseEntity.ok().body(censecBusiness.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		return ResponseEntity.ok().body(censecBusiness.find(cnpj));
	}

}
