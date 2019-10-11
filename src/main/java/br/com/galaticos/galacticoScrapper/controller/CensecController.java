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

import br.com.galaticos.galacticoScrapper.model.Censec;
import br.com.galaticos.galacticoScrapper.repository.CensecRepository;

@RestController
@RequestMapping("/censec")
public class CensecController {

	@Autowired
	private CensecRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Censec>> getCadesp() {
		return ResponseEntity.ok().body(repository.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cpfCnpj").is(cnpj));
		List<Censec> users = mongoTemplate.find(query, Censec.class);
		if(!users.isEmpty()) {
			return ResponseEntity.ok().body(users);
		}else {
			return ResponseEntity.ok().body("No data found");
		}

	}

}
