package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;

public interface CagedTrabalhadorRepository extends MongoRepository<CagedTrabalhador, String> {

}
