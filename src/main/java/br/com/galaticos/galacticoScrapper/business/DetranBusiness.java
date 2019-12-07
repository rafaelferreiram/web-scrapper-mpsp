package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Detran;
import br.com.galaticos.galacticoScrapper.repository.DetranRepository;

@Component
public class DetranBusiness {

	@Autowired
	private DetranRepository detranRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Detran> findAll() {
		return detranRepository.findAll();
	}

	public List<Detran> findCpf(String cnpj) {
		Query query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cnpj));
		List<Detran> users = mongoTemplate.find(query, Detran.class);
		return users.isEmpty() ? findAll() : users;
	}

}
