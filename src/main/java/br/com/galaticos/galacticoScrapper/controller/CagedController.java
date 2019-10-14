package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.CagedAll;
import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;
import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;
import br.com.galaticos.galacticoScrapper.repository.CagedAllRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedEmpresaRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedTrabalhadorRepository;

@RestController
@RequestMapping("/caged")
public class CagedController {

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

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CagedAll>> getAll() {
		return ResponseEntity.ok().body(allRepository.findAll());
	}

	@RequestMapping(value = "/caged", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Caged>> getCaged() {
		return ResponseEntity.ok().body(cagedRepository.findAll());
	}

	@RequestMapping(value = "/cagedEmpresa", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CagedEmpresa>> getCagedEmpresa() {
		return ResponseEntity.ok().body(cagedEmpresaRepository.findAll());
	}

	@RequestMapping(value = "/cagedTrabalhador", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CagedTrabalhador>> getCagedTrabalhador() {
		return ResponseEntity.ok().body(cagedTrabalhadorRepository.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
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
			return ResponseEntity.ok().body(cagedAll);
		} else {
			return ResponseEntity.ok().body("No data found");
		}

	}

	@RequestMapping(value = "/cpf{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCpf(@RequestParam("cpf") String cpf) {
		Query query = new Query();
		// get Caged
		query.addCriteria(Criteria.where("CnpjCeiCpf").is(cpf));
		List<Caged> caged = mongoTemplate.find(query, Caged.class);

		// get CagedTrabalhador
		query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cpf));
		List<CagedTrabalhador> cagedTrabalhador = mongoTemplate.find(query, CagedTrabalhador.class);
		Caged cagedObj = new Caged();
		cagedObj = caged.isEmpty() ? null : caged.get(0);
		CagedTrabalhador cagedTrabalhadorObj = new CagedTrabalhador();
		cagedTrabalhadorObj = cagedTrabalhador.isEmpty() ? null : cagedTrabalhador.get(0);
		CagedAll cagedAll = new CagedAll(cagedObj, cagedTrabalhadorObj);

		if (cagedTrabalhadorObj != null || cagedObj != null) {
			return ResponseEntity.ok().body(cagedAll);
		} else {
			return ResponseEntity.ok().body("No data found");
		}

	}
}
