package br.com.galaticos.galacticoScrapper.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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

	public List<CagedAll> findCagedCnpjCpf(String cnpj) {
		Query query = new Query();
		List<CagedAll> listaCagedAll = new ArrayList<CagedAll>();
		// get Caged
		query.addCriteria(Criteria.where("CnpjCeiCpf").is(cnpj));
		List<Caged> caged = mongoTemplate.find(query, Caged.class);

		query = new Query();
		// get CagedEmpresa
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<CagedEmpresa> cagedEmpresa = mongoTemplate.find(query, CagedEmpresa.class);

		Caged cagedObj = new Caged();
		cagedObj = caged.isEmpty() ? null : caged.get(0);
		CagedEmpresa cagedEmpresaObj = new CagedEmpresa();
		cagedEmpresaObj = cagedEmpresa.isEmpty() ? null : cagedEmpresa.get(0);
		CagedAll cagedAll = new CagedAll(cagedObj, cagedEmpresaObj, null);
		if (cagedEmpresaObj != null || cagedObj != null) {
			listaCagedAll.add(cagedAll);
			return listaCagedAll;
		} else {
			// Even when no data found , return mock result
			return findCagedAll();
		}
	}

	public List<CagedEmpresa> findCagedEmpresaCnpjCpf(Query query) {
		return mongoTemplate.find(query, CagedEmpresa.class);
	}

	public List<CagedAll> findCagedTrabalhadorCnpjCpf(String cnpj) {
		Query query = new Query();
		List<CagedAll> listaCagedAll = new ArrayList<CagedAll>();
		// get Caged
		query.addCriteria(Criteria.where("CnpjCeiCpf").is(cnpj));
		List<Caged> caged = mongoTemplate.find(query, Caged.class);

		query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cnpj));
		List<CagedTrabalhador> cagedTrabalhador = mongoTemplate.find(query, CagedTrabalhador.class);
		Caged cagedObj = new Caged();
		cagedObj = caged.isEmpty() ? null : caged.get(0);
		CagedTrabalhador cagedTrabalhadorObj = new CagedTrabalhador();
		cagedTrabalhadorObj = cagedTrabalhador.isEmpty() ? null : cagedTrabalhador.get(0);
		CagedAll cagedAll = new CagedAll(cagedObj, cagedTrabalhadorObj);
		if (cagedTrabalhadorObj != null || cagedObj != null) {
			listaCagedAll.add(cagedAll);
			return listaCagedAll;
		} else {
			// Even when no data found , return mock result
			return findCagedAll();
		}
	}

}
