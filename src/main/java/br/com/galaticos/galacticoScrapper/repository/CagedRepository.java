package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.Caged;

public interface CagedRepository extends MongoRepository<Caged, String> {

}
