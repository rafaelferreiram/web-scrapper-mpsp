package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.CagedAll;

public interface CagedAllRepository extends MongoRepository<CagedAll, String>{
	
}
