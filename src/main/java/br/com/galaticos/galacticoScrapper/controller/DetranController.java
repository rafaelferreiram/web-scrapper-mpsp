package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.model.Detran;
import br.com.galaticos.galacticoScrapper.repository.DetranRepository;

@RestController
@RequestMapping("/detran")
public class DetranController {

	@Autowired
	DetranRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Detran>> getDetran() {
		return ResponseEntity.ok().body(repository.findAll());
	}

	@RequestMapping(value = "/cpf{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cpf") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cnpj));
		List<Detran> users = mongoTemplate.find(query, Detran.class);
		if (!users.isEmpty()) {
			return ResponseEntity.ok().body(users.get(0));
		} else {
			// Even when no data found , return mock result
			return ResponseEntity.ok().body(repository.findAll().get(0));
		}
	}
}
