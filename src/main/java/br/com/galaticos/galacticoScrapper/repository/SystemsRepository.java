package br.com.galaticos.galacticoScrapper.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemsRepository {

	@Autowired
	public ArpenpRepository arpenpRepository;

	@Autowired
	public CadespRepository cadespRepository;

	@Autowired
	public CagedAllRepository cagedRepository;

	@Autowired
	public CensecRepository censecRepository;

	@Autowired
	public JucespRepository jucespRepository;

	@Autowired
	public SielRepository sielRepository;

	@Autowired
	public SivecRepository sivecRepository;

	@Autowired
	public DetranRepository detranRepository;
}
