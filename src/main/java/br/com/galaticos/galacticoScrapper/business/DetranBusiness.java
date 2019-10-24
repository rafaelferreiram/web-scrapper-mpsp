package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

	public List<Detran> findCpf(Query query) {
		return mongoTemplate.find(query, Detran.class);
	}
	
	
}
