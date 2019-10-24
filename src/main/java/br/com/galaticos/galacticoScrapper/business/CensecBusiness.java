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
}
