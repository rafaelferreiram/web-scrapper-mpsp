package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return ResponseEntity.ok().body(cagedBusiness.findCagedCnpjCpf(cnpj).get(0));

	}

	@RequestMapping(value = "/cpf{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCpf(@RequestParam("cpf") String cpf) {
		return ResponseEntity.ok().body(cagedBusiness.findCagedTrabalhadorCnpjCpf(cpf).get(0));

	}
}
