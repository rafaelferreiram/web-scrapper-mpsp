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

import br.com.galaticos.galacticoScrapper.business.DetranBusiness;
import br.com.galaticos.galacticoScrapper.model.Detran;

@RestController
@RequestMapping("/detran")
public class DetranController {

	@Autowired
	private DetranBusiness detranBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Detran>> getDetran() {
		return ResponseEntity.ok().body(detranBusiness.findAll());
	}

	@RequestMapping(value = "/cpf{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cpf") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cnpj));
		List<Detran> users = detranBusiness.findCpf(query);
		if (!users.isEmpty()) {
			return ResponseEntity.ok().body(users.get(0));
		} else {
			// Even when no data found , return mock result
			return ResponseEntity.ok().body(detranBusiness.findAll().get(0));
		}
	}
}
