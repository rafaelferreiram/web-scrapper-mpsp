package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.Cadesp;

public interface CadespRepository extends MongoRepository<Cadesp, String> {

}
