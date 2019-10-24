package br.com.galaticos.galacticoScrapper.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.galaticos.galacticoScrapper.model.Sivec;
import br.com.galaticos.galacticoScrapper.repository.SivecRepository;

@Component
public class SivecBusiness {

	@Autowired
	private SivecRepository sivecRepository;

	public List<Sivec> findAll() {
		return sivecRepository.findAll();
	}
}
