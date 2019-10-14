package br.com.galaticos.galacticoScrapper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.model.Censec;
import br.com.galaticos.galacticoScrapper.repository.CensecRepository;

@RestController
@RequestMapping("/censec")
public class CensecController {

	@Autowired
	private CensecRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Censec>> getCensec() {
		return ResponseEntity.ok().body(repository.findAll());
	}

	@RequestMapping(value = "/cnpj{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getByCnpj(@RequestParam("cnpj") String cnpj) {
		Censec result = (Censec) repository.findAll().get(0);
		if (isInTheDocument(result.getCpfCnpj(), cnpj)) {
			return ResponseEntity.ok().body(result);
		} else {
			return ResponseEntity.ok().body("No data found");
		}
	}

	public boolean isInTheDocument(List<String> list, String cnpj) {
		boolean result = Boolean.FALSE;
		if (cnpj != null) {
			Censec censec = new Censec();
			List<String> cpfCnpj = new ArrayList<String>();
			cpfCnpj.add(cnpj);
			censec.setCpfCnpj(cpfCnpj);
			if (list.contains(censec.getCpfCnpj().get(0))) {
				result = Boolean.TRUE;
			}
		}
		return result;
	}

}
