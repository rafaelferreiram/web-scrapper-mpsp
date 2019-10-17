package br.com.galaticos.galacticoScrapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import br.com.galaticos.galacticoScrapper.repository.SystemsRepository;

@Service
public class SearchService {

	@Autowired
	private SystemsRepository repositories;

	@Autowired
	private ApiCallService apiCallService;

	public void getWithCpfFilter(Model model, String select, String cpfCnpj) {
		if ("Caged".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("caged", apiCallService.getToCagedCpf(cpfCnpj));
			}
		} else if ("Censec".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
			}
		}else if ("All".equalsIgnoreCase(select)) {
			model.addAttribute("caged", apiCallService.getToCagedCpf(cpfCnpj));
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
		}
	}

	public void getWithCnpjFilter(Model model, String select, String cpfCnpj) {
		if ("Jucesp".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("jucesp", apiCallService.getToJucesp(cpfCnpj));
			}
		} else if ("Cadesp".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("cadesp", apiCallService.getToCadesp(cpfCnpj));
			}
		} else if ("Arpenp".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("arpenp", apiCallService.getToArpenp(cpfCnpj));
			}
		} else if ("Caged".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("caged", apiCallService.getToCagedCnpj(cpfCnpj));
			}
		} else if ("Censec".equals(select)) {
			if("".equals(cpfCnpj)) {
				model.addAttribute("msg", "No data found ! [Either select 'All' instead of CNPJ/CPF or informe a CNPJ/CPF number ]");
			}else {
				model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
			}
		} else if ("All".equalsIgnoreCase(select)) {
			model.addAttribute("jucesp", apiCallService.getToJucesp(cpfCnpj));
			model.addAttribute("cadesp", apiCallService.getToCadesp(cpfCnpj));
			model.addAttribute("arpenp", apiCallService.getToArpenp(cpfCnpj));
			model.addAttribute("caged", apiCallService.getToCagedCnpj(cpfCnpj));
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));

		}
	}

	public void getAllWithNoFilter(Model model) {
		model.addAttribute("arpenp", repositories.arpenpRepository.findAll());
		model.addAttribute("cadesp", repositories.cadespRepository.findAll());
		model.addAttribute("caged", repositories.cagedRepository.findAll());
		model.addAttribute("censec", repositories.censecRepository.findAll());
		model.addAttribute("jucesp", repositories.jucespRepository.findAll());
		model.addAttribute("siel", repositories.sielRepository.findAll());
		model.addAttribute("sivec", repositories.sivecRepository.findAll());
		model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
		model.addAttribute("detran", "/downloads/detran.pdf");
		model.addAttribute("arisp", "/downloads/arisp.pdf");
	}

	public void getAllWithTypeFilter(Model model, String select) {
		if ("Jucesp".equals(select)) {
			model.addAttribute("jucesp", repositories.jucespRepository.findAll());
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadesp", repositories.cadespRepository.findAll());
		} else if ("Arpenp".equals(select)) {
			model.addAttribute("arpenp", repositories.arpenpRepository.findAll());
		} else if ("Caged".equals(select)) {
			model.addAttribute("caged", repositories.cagedRepository.findAll());
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", repositories.censecRepository.findAll());
		} else if ("Sivec".equals(select)) {
			model.addAttribute("sivec", repositories.sivecRepository.findAll());
		} else if ("Siel".equals(select)) {
			model.addAttribute("siel", repositories.sielRepository.findAll());
		} else if ("Arisp".equals(select)) {
			model.addAttribute("arisp", "/downloads/arisp.pdf");
		} else if ("Detran".equals(select)) {
			model.addAttribute("detran", "/downloads/detran.pdf");
		} else if ("Infocrim".equals(select)) {
			model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
		}
	}
}
