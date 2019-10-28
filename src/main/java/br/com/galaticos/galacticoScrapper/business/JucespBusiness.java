package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Jucesp;
import br.com.galaticos.galacticoScrapper.repository.JucespRepository;

@Component
public class JucespBusiness {

	@Autowired
	private JucespRepository jucespRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Jucesp> findAll() {
		return jucespRepository.findAll();
	}

	public List<Jucesp> findCnpj(String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<Jucesp> users = mongoTemplate.find(query, Jucesp.class);
		if (!users.isEmpty()) {
			return users;
		} else {
			// Even when no data found , return mock result
			return findAll();
		}
	}

}
