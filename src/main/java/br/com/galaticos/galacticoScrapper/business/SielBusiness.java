package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Siel;
import br.com.galaticos.galacticoScrapper.repository.SielRepository;

@Component
public class SielBusiness {

	@Autowired
	private SielRepository sielRepository;
	
	public List<Siel> findAll(){
		return sielRepository.findAll();
	}
}
