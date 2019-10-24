package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Arpenp;
import br.com.galaticos.galacticoScrapper.repository.ArpenpRepository;

@Component
public class ArpenpBusiness {

	@Autowired
	private ArpenpRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Arpenp> findAll() {
		return repository.findAll();
	}

	public List<Arpenp> find(Query query) {
		return mongoTemplate.find(query, Arpenp.class);
	}

}
