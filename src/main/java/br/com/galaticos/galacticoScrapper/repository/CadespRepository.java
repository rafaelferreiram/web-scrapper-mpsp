package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.galaticos.galacticoScrapper.model.Cadesp;

public interface CadespRepository extends MongoRepository<Cadesp, String> {

	//@Query("{'cnpj':'?'}")
	@Query("{cnpj : ?0}")
	Cadesp findByCnpj(String cnpj);

}
