package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.SivecBusiness;
import br.com.galaticos.galacticoScrapper.model.Sivec;

@RestController
@RequestMapping(value = "/sivec")
public class SivecController {

	@Autowired
	private SivecBusiness sivecBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Sivec>> getSivec() {
		return ResponseEntity.ok().body(sivecBusiness.findAll());
	}
}
