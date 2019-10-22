package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.Detran;

public interface DetranRepository extends MongoRepository<Detran, String> {

}
