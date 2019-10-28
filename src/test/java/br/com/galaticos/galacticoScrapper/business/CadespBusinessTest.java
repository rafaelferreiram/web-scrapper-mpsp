package br.com.galaticos.galacticoScrapper.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.galaticos.galacticoScrapper.model.Cadesp;
import br.com.galaticos.galacticoScrapper.repository.CadespRepository;
import junit.framework.Assert;

@SpringBootTest
public class CadespBusinessTest {

	@InjectMocks
	private CadespBusiness cadespBusiness;

	@Mock
	private CadespRepository cadespRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		List<Cadesp> mockedList = new ArrayList<Cadesp>();
		Cadesp cadesp = new Cadesp();
		cadesp.setCnpj("19.811.201/0001-05");
		mockedList.add(cadesp);
		Mockito.when(cadespRepository.findAll()).thenReturn(mockedList);
		List<Cadesp> listReturn = cadespBusiness.findAll();

		Assert.assertEquals("19.811.201/0001-05", listReturn.get(0).getCnpj());
	}
	
}
