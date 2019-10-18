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

import br.com.galaticos.galacticoScrapper.model.Cadesp;
import br.com.galaticos.galacticoScrapper.repository.CadespRepository;

@RestController
@RequestMapping("/cadesp")
public class CadespController {

	@Autowired
	private CadespRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Cadesp>> getCadesp() {
		return ResponseEntity.ok().body(repository.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<Cadesp> users = mongoTemplate.find(query, Cadesp.class);
		if(!users.isEmpty()) {
			return ResponseEntity.ok().body(users.get(0));
		}else {
			return ResponseEntity.ok().body(repository.findAll().get(0));
		}
	}
}
