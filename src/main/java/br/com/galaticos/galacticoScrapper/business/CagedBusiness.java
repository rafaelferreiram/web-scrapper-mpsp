package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.CagedAll;
import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;
import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;
import br.com.galaticos.galacticoScrapper.repository.CagedAllRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedEmpresaRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedTrabalhadorRepository;

@Component
public class CagedBusiness {

	@Autowired
	private CagedRepository cagedRepository;

	@Autowired
	private CagedAllRepository allRepository;

	@Autowired
	private CagedEmpresaRepository cagedEmpresaRepository;

	@Autowired
	private CagedTrabalhadorRepository cagedTrabalhadorRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<CagedAll> findCagedAll() {
		return allRepository.findAll();
	}

	public List<Caged> findCaged() {
		return cagedRepository.findAll();
	}

	public List<CagedEmpresa> findCagedEmpresa() {
		return cagedEmpresaRepository.findAll();
	}

	public List<CagedTrabalhador> findCagedTrabalhador() {
		return cagedTrabalhadorRepository.findAll();
	}

	public List<Caged> findCagedCnpjCpf(Query query) {
		return mongoTemplate.find(query, Caged.class);
	}

	public List<CagedEmpresa> findCagedEmpresaCnpjCpf(Query query) {
		return mongoTemplate.find(query, CagedEmpresa.class);
	}

	public List<CagedTrabalhador> findCagedTrabalhadorCnpjCpf(Query query) {
		return mongoTemplate.find(query, CagedTrabalhador.class);
	}

}
