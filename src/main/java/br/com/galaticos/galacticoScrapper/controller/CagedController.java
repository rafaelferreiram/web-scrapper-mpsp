package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.business.CagedBusiness;
import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.CagedAll;
import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;
import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;

@RestController
@RequestMapping("/caged")
public class CagedController {

	@Autowired
	private CagedBusiness cagedBusiness;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CagedAll>> getAll() {
		return ResponseEntity.ok().body(cagedBusiness.findCagedAll());
	}

	@RequestMapping(value = "/caged", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Caged>> getCaged() {
		return ResponseEntity.ok().body(cagedBusiness.findCaged());
	}

	@RequestMapping(value = "/cagedEmpresa", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CagedEmpresa>> getCagedEmpresa() {
		return ResponseEntity.ok().body(cagedBusiness.findCagedEmpresa());
	}

	@RequestMapping(value = "/cagedTrabalhador", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CagedTrabalhador>> getCagedTrabalhador() {
		return ResponseEntity.ok().body(cagedBusiness.findCagedTrabalhador());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Query query = new Query();
		// get Caged
		query.addCriteria(Criteria.where("CnpjCeiCpf").is(cnpj));
		List<Caged> caged = cagedBusiness.findCagedCnpjCpf(query);

		query = new Query();
		// get CagedEmpresa
		query.addCriteria(Criteria.where("cnpj").is(cnpj));
		List<CagedEmpresa> cagedEmpresa = cagedBusiness.findCagedEmpresaCnpjCpf(query);

		Caged cagedObj = new Caged();
		cagedObj = caged.isEmpty() ? null : caged.get(0);
		CagedEmpresa cagedEmpresaObj = new CagedEmpresa();
		cagedEmpresaObj = cagedEmpresa.isEmpty() ? null : cagedEmpresa.get(0);
		CagedAll cagedAll = new CagedAll(cagedObj, cagedEmpresaObj, null);
		if (cagedEmpresaObj != null || cagedObj != null) {
			return ResponseEntity.ok().body(cagedAll);
		} else {
			//Even when no data found , return mock result
			return ResponseEntity.ok().body(cagedBusiness.findCagedAll().get(0));
		}

	}

	@RequestMapping(value = "/cpf{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCpf(@RequestParam("cpf") String cpf) {
		Query query = new Query();
		// get Caged
		query.addCriteria(Criteria.where("CnpjCeiCpf").is(cpf));
		List<Caged> caged = cagedBusiness.findCagedCnpjCpf(query);

		// get CagedTrabalhador
		query = new Query();
		query.addCriteria(Criteria.where("cpf").is(cpf));
		List<CagedTrabalhador> cagedTrabalhador = cagedBusiness.findCagedTrabalhadorCnpjCpf(query);
		Caged cagedObj = new Caged();
		cagedObj = caged.isEmpty() ? null : caged.get(0);
		CagedTrabalhador cagedTrabalhadorObj = new CagedTrabalhador();
		cagedTrabalhadorObj = cagedTrabalhador.isEmpty() ? null : cagedTrabalhador.get(0);
		CagedAll cagedAll = new CagedAll(cagedObj, cagedTrabalhadorObj);

		if (cagedTrabalhadorObj != null || cagedObj != null) {
			return ResponseEntity.ok().body(cagedAll);
		} else {
			//Even when no data found , return mock result
			return ResponseEntity.ok().body(cagedBusiness.findCagedAll().get(0));
		}

	}
}
