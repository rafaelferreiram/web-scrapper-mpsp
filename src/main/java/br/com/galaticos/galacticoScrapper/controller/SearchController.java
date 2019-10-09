package br.com.galaticos.galacticoScrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.galaticos.galacticoScrapper.repository.SystemsRepository;

@Controller
public class SearchController {

	@Autowired
	private SystemsRepository repositories;

	@PostMapping("/search")
	public String loginParam(Model model, String cpfCnpj, String tipoBusca, String select) {
		if ("Arpenp".equals(select)) {
			model.addAttribute("arpenp", repositories.arpenpRepository.findAll());
		} else if ("Cadesp".equals(select)) {
			model.addAttribute("cadesp", repositories.cadespRepository.findAll());
		} else if ("Caged".equals(select)) {
			model.addAttribute("caged", repositories.cagedRepository.findAll());
		} else if ("Censec".equals(select)) {
			model.addAttribute("censec", repositories.censecRepository.findAll());
		} else if ("Jucesp".equals(select)) {
			model.addAttribute("jucesp", repositories.jucespRepository.findAll());
		} else if ("Siel".equals(select)) {
			model.addAttribute("siel", repositories.sielRepository.findAll());
		} else if ("Sivec".equals(select)) {
			model.addAttribute("sivec", repositories.sivecRepository.findAll());
		}else if("All".equals(select)) {
			model.addAttribute("arpenp", repositories.arpenpRepository.findAll());
			model.addAttribute("cadesp", repositories.cadespRepository.findAll());
			model.addAttribute("caged", repositories.cagedRepository.findAll());
			model.addAttribute("censec", repositories.censecRepository.findAll());
			model.addAttribute("jucesp", repositories.jucespRepository.findAll());
			model.addAttribute("siel", repositories.sielRepository.findAll());
			model.addAttribute("sivec", repositories.sivecRepository.findAll());
		}
		return "resultPage";
	}
	
}
