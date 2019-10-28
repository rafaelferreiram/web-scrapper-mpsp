package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.ArpenpBusiness;
import br.com.galaticos.galacticoScrapper.model.Arpenp;

@RestController
@RequestMapping("/arpend")
public class ArpenpController {

	@Autowired
	private ArpenpBusiness arpenpBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Arpenp>> getArpenp() {
		return ResponseEntity.ok().body(arpenpBusiness.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		return ResponseEntity.ok().body(arpenpBusiness.find(cnpj).get(0));
	}

}
