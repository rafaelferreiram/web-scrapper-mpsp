package br.com.galaticos.galacticoScrapper.controller;

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
			//Even when no data found , return mock result
			return ResponseEntity.ok().body(repository.findAll().get(0));
		}
	}

	public boolean isInTheDocument(List<String> list, String cnpj) {
		boolean result = Boolean.FALSE;
		if (cnpj != null) {
			for(String cpfDoc : list) {
				if(cpfDoc.trim().equalsIgnoreCase(cnpj.toString())) {
					return Boolean.TRUE;
				}
			}
		}
		return result;
	}

}
