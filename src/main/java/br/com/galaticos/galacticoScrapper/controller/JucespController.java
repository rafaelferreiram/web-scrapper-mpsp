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

import br.com.galaticos.galacticoScrapper.model.Jucesp;
import br.com.galaticos.galacticoScrapper.repository.JucespRepository;

@RestController
@RequestMapping("/jucesp")
public class JucespController {

	@Autowired
	private JucespRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Jucesp>> getJucesp(){
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<Jucesp> users = mongoTemplate.find(query, Jucesp.class);
		if(!users.isEmpty()) {
			return ResponseEntity.ok().body(users.get(0));
		}else {
			//Even when no data found , return mock result
			return ResponseEntity.ok().body(repository.findAll().get(0));
		}
	}
	
}
