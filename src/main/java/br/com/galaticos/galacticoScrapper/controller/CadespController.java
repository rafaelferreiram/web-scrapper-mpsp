package br.com.galaticos.galacticoScrapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import br.com.galaticos.galacticoScrapper.model.Cadesp;
import br.com.galaticos.galacticoScrapper.repository.CadespRepository;

@RestController
@RequestMapping("/cadesp")
public class CadespController {

	@Autowired
	private CadespRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Cadesp>> getCadesp() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@RequestMapping(value = "/one{id}", method = RequestMethod.GET)
	public ResponseEntity<Cadesp> getByCnpj(@RequestParam("cnpj") String cnpj){
		return ResponseEntity.ok().body(repository.findByCnpj(cnpj));
	}
}


