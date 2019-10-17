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

import br.com.galaticos.galacticoScrapper.model.Arpenp;
import br.com.galaticos.galacticoScrapper.repository.ArpenpRepository;

@RestController
@RequestMapping("/arpend")
public class ArpenpController {

	@Autowired
	private ArpenpRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Arpenp>> getArpenp() {
		return ResponseEntity.ok().body(repository.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<Arpenp> users = mongoTemplate.find(query, Arpenp.class);
		if (!users.isEmpty()) {
			return ResponseEntity.ok().body(users.get(0));
		} else {
			return ResponseEntity.ok().body("No data found");
		}

	}
}
