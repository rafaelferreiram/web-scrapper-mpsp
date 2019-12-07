package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Cadesp;
import br.com.galaticos.galacticoScrapper.repository.CadespRepository;

@Component
public class CadespBusiness {

	@Autowired
	private CadespRepository cadespRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Cadesp> findAll() {
		return cadespRepository.findAll();
	}

	public List<Cadesp> find(String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<Cadesp> users = mongoTemplate.find(query, Cadesp.class);
		return users.isEmpty() ? users : findAll();
	}

}
