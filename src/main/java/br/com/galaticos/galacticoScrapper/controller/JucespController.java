package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.JucespBusiness;
import br.com.galaticos.galacticoScrapper.model.Jucesp;

@RestController
@RequestMapping("/jucesp")
public class JucespController {

	@Autowired
	private JucespBusiness jucespBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Jucesp>> getJucesp() {
		return ResponseEntity.ok().body(jucespBusiness.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<Jucesp> users = jucespBusiness.findCnpj(query);
		if (!users.isEmpty()) {
			return ResponseEntity.ok().body(users.get(0));
		} else {
			// Even when no data found , return mock result
			return ResponseEntity.ok().body(jucespBusiness.findAll().get(0));
		}
	}

}
