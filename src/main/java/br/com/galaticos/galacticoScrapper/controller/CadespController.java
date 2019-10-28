package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.CadespBusiness;
import br.com.galaticos.galacticoScrapper.model.Cadesp;

@RestController
@RequestMapping("/cadesp")
public class CadespController {

	@Autowired
	private CadespBusiness cadespBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cadesp>> getCadesp() {
		return ResponseEntity.ok().body(cadespBusiness.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		return ResponseEntity.ok().body(cadespBusiness.find(cnpj).get(0));
	}
}
