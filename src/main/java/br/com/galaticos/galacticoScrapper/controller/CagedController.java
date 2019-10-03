package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.CagedAll;
import br.com.galaticos.galacticoScrapper.model.CagedEmpresa;
import br.com.galaticos.galacticoScrapper.model.CagedTrabalhador;
import br.com.galaticos.galacticoScrapper.repository.CagedAllRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedEmpresaRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedRepository;
import br.com.galaticos.galacticoScrapper.repository.CagedTrabalhadorRepository;

@RestController
@RequestMapping("/caged")
public class CagedController {

	@Autowired
	private CagedRepository cagedRepository;

	@Autowired
	private CagedAllRepository allRepository;

	@Autowired
	private CagedEmpresaRepository cagedEmpresaRepository;

	@Autowired
	private CagedTrabalhadorRepository cagedTrabalhadorRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<CagedAll>> getAll() {
		return ResponseEntity.ok().body(allRepository.findAll());
	}

	@RequestMapping(value = "/caged", method = RequestMethod.GET)
	public ResponseEntity<List<Caged>> getCaged() {
		return ResponseEntity.ok().body(cagedRepository.findAll());
	}

	@RequestMapping(value = "/cagedEmpresa", method = RequestMethod.GET)
	public ResponseEntity<List<CagedEmpresa>> getCagedEmpresa() {
		return ResponseEntity.ok().body(cagedEmpresaRepository.findAll());
	}

	@RequestMapping(value = "/cagedTrabalhador", method = RequestMethod.GET)
	public ResponseEntity<List<CagedTrabalhador>> getCagedTrabalhador() {
		return ResponseEntity.ok().body(cagedTrabalhadorRepository.findAll());
	}
}
