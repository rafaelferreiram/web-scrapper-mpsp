package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Censec;
import br.com.galaticos.galacticoScrapper.repository.CensecRepository;

@Component
public class CensecBusiness {

	@Autowired
	private CensecRepository censecRepository;

	public List<Censec> findAll() {
		return censecRepository.findAll();
	}

	public Censec find(String cnpj) {
		Censec resultSearch = (Censec) censecRepository.findAll().get(0);
		if (isInTheDocument(resultSearch.getCpfCnpj(), cnpj)) {
			return resultSearch;
		} else {
			// Even when no data found , return mock result
			return censecRepository.findAll().get(0);
		}
	}

	public boolean isInTheDocument(List<String> list, String cnpj) {
		return cnpj != null ? alreadyExists(list, cnpj) : false;
	}

	public boolean alreadyExists(List<String> list, String cnpj) {
		for (String cpfDoc : list) {
			if (cpfDoc.trim().equalsIgnoreCase(cnpj.toString())) {
				return Boolean.TRUE;
			}
		}
		return false;
	}
}
