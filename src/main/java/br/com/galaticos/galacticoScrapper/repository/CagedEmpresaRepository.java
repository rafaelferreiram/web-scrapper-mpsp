package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;

public interface CagedEmpresaRepository extends MongoRepository<CagedEmpresa, String> {

}
