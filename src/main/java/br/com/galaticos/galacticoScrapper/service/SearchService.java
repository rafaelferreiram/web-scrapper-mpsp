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
			model.addAttribute("caged", apiCallService.getToCagedCpf(cpfCnpj));
		} else if ("Jucesp".equals(select)) {
			model.addAttribute("jucesp", apiCallService.getToJucesp(cpfCnpj));
			model.addAttribute("jucespPDF", "/downloads/jucesp.pdf");
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadesp", apiCallService.getToCadesp(cpfCnpj));
		} else if ("Caged".equals(select)) {
			model.addAttribute("caged", apiCallService.getToCagedCnpj(cpfCnpj));
			model.addAttribute("cagedPDF", "/downloads/cagedTrabalhador.pdf");
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
		} else if ("Sivec".equals(select)) {
			model.addAttribute("sivecList", repositories.sivecRepository.findAll());
		} else if ("Siel".equals(select)) {
			model.addAttribute("sielList", repositories.sielRepository.findAll());
		} else if ("Arisp".equals(select)) {
			model.addAttribute("arisp", "/downloads/arisp.pdf");
		} else if ("Detran".equals(select)) {
			model.addAttribute("detran", "/downloads/detran.pdf");
		} else if ("Arpenp".equals(select)) {
			model.addAttribute("arpenp", apiCallService.getToArpenp(cpfCnpj));
		}else if ("Infocrim".equals(select)) {
			model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
		} else if ("All".equalsIgnoreCase(select)) {
			model.addAttribute("arpenpList", repositories.arpenpRepository.findAll());
			model.addAttribute("cadespList", repositories.cadespRepository.findAll());
			model.addAttribute("cagedList", repositories.cagedRepository.findAll());
			model.addAttribute("censecList", repositories.censecRepository.findAll());
			model.addAttribute("jucespList", repositories.jucespRepository.findAll());
			model.addAttribute("sielList", repositories.sielRepository.findAll());
			model.addAttribute("sivecList", repositories.sivecRepository.findAll());
			model.addAttribute("cagedPDF", "/downloads/cagedTrabalhador.pdf");
			model.addAttribute("jucespPDF", "/downloads/jucesp.pdf");
			model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
			model.addAttribute("detran", "/downloads/detran.pdf");
			model.addAttribute("arisp", "/downloads/arisp.pdf");

		}
	}

	public void getWithCnpjFilter(Model model, String select, String cpfCnpj) {
		if ("Jucesp".equals(select)) {
			model.addAttribute("jucesp", apiCallService.getToJucesp(cpfCnpj));
			model.addAttribute("jucespPDF", "/downloads/jucesp.pdf");
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadesp", apiCallService.getToCadesp(cpfCnpj));
		} else if ("Arpenp".equals(select)) {
			model.addAttribute("arpenp", apiCallService.getToArpenp(cpfCnpj));
		} else if ("Caged".equals(select)) {
			model.addAttribute("caged", apiCallService.getToCagedCnpj(cpfCnpj));
			model.addAttribute("cagedPDF", "/downloads/cagedTrabalhador.pdf");
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", apiCallService.getToCensec(cpfCnpj));
		} else if ("Sivec".equals(select)) {
			model.addAttribute("sivecList", repositories.sivecRepository.findAll());
		} else if ("Siel".equals(select)) {
			model.addAttribute("sielList", repositories.sielRepository.findAll());
		} else if ("Arisp".equals(select)) {
			model.addAttribute("arisp", "/downloads/arisp.pdf");
		} else if ("Detran".equals(select)) {
			model.addAttribute("detran", "/downloads/detran.pdf");
		} else if ("Infocrim".equals(select)) {
			model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
		} else if ("All".equalsIgnoreCase(select)) {
			model.addAttribute("arpenpList", repositories.arpenpRepository.findAll());
			model.addAttribute("cadespList", repositories.cadespRepository.findAll());
			model.addAttribute("cagedList", repositories.cagedRepository.findAll());
			model.addAttribute("censecList", repositories.censecRepository.findAll());
			model.addAttribute("jucespList", repositories.jucespRepository.findAll());
			model.addAttribute("sielList", repositories.sielRepository.findAll());
			model.addAttribute("sivecList", repositories.sivecRepository.findAll());
			model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
			model.addAttribute("cagedPDF", "/downloads/cagedTrabalhador.pdf");
			model.addAttribute("jucespPDF", "/downloads/jucesp.pdf");
			model.addAttribute("detran", "/downloads/detran.pdf");
			model.addAttribute("arisp", "/downloads/arisp.pdf");

		}
	}

	public void getAllWithNoFilter(Model model) {
		model.addAttribute("arpenpList", repositories.arpenpRepository.findAll());
		model.addAttribute("cadespList", repositories.cadespRepository.findAll());
		model.addAttribute("cagedList", repositories.cagedRepository.findAll());
		model.addAttribute("censecList", repositories.censecRepository.findAll());
		model.addAttribute("jucespList", repositories.jucespRepository.findAll());
		model.addAttribute("sielList", repositories.sielRepository.findAll());
		model.addAttribute("sivecList", repositories.sivecRepository.findAll());
		model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
		model.addAttribute("cagedPDF", "/downloads/cagedTrabalhador.pdf");
		model.addAttribute("jucespPDF", "/downloads/jucesp.pdf");
		model.addAttribute("detran", "/downloads/detran.pdf");
		model.addAttribute("arisp", "/downloads/arisp.pdf");
	}

	public void getAllWithTypeFilter(Model model, String select) {
		if ("Jucesp".equals(select)) {
			model.addAttribute("jucespList", repositories.jucespRepository.findAll());
			model.addAttribute("jucespPDF", "/downloads/jucesp.pdf");
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadespList", repositories.cadespRepository.findAll());
		} else if ("Arpenp".equals(select)) {
			model.addAttribute("arpenpList", repositories.arpenpRepository.findAll());
		} else if ("Caged".equals(select)) {
			model.addAttribute("cagedList", repositories.cagedRepository.findAll());
			model.addAttribute("cagedPDF", "/downloads/cagedTrabalhador.pdf");
		} else if ("Censec".equals(select)) {
			model.addAttribute("censecList", repositories.censecRepository.findAll());
		} else if ("Sivec".equals(select)) {
			model.addAttribute("sivecList", repositories.sivecRepository.findAll());
		} else if ("Siel".equals(select)) {
			model.addAttribute("sielList", repositories.sielRepository.findAll());
		} else if ("Arisp".equals(select)) {
			model.addAttribute("arisp", "/downloads/arisp.pdf");
		} else if ("Detran".equals(select)) {
			model.addAttribute("detran", "/downloads/detran.pdf");
		} else if ("Infocrim".equals(select)) {
			model.addAttribute("infocrim", "/downloads/Detalhe do BO Escolhido.pdf");
		}
	}
}
