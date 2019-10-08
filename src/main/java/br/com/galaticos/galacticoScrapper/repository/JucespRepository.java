package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.Jucesp;

public interface JucespRepository extends MongoRepository<Jucesp, String> {

}
