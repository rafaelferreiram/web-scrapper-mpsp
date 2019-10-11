package br.com.galaticos.galacticoScrapper.controller;

import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.galaticos.galacticoScrapper.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;

	@PostMapping("/search")
	public String loginParam(Model model, String cpfCnpj, String tipoBusca, String select)
			throws MalformedURLException {
		if (isCpf(tipoBusca)) {
			searchService.getWithCpfFilter(model, select, cpfCnpj);
		} else if (isCnpj(tipoBusca)) {
			searchService.getWithCnpjFilter(model, select, cpfCnpj);
		} else {
			if (isTypeSelected(select)) {
				searchService.getAllWithNoFilter(model);
			} else {
				searchService.getAllWithTypeFilter(model, select);
			}
		}
		return "resultPage";
	}

	private boolean isTypeSelected(String select) {
		return "All".equalsIgnoreCase(select) ? true : false;
	}

	private boolean isCnpj(String tipoBusca) {
		return "cnpj".equalsIgnoreCase(tipoBusca) ? true : false;
	}

	private boolean isCpf(String tipoBusca) {
		return "cpf".equalsIgnoreCase(tipoBusca) ? true : false;
	}

}
