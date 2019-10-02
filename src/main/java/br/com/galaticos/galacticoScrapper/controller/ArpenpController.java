package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.model.Arpenp;
import br.com.galaticos.galacticoScrapper.repository.ArpenpRepository;

@RestController
@RequestMapping("/arpend")
public class ArpenpController {

	@Autowired
	  private ArpenpRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<Arpenp> getArpenp() {
	    return repository.findAll();
	  }
}
