package br.com.galaticos.galacticoScrapper.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.galaticos.galacticoScrapper.business.ArpenpBusiness;
import br.com.galaticos.galacticoScrapper.model.Arpenp;
import junit.framework.Assert;

@SpringBootTest
public class ArpenpBusinessTest {

	@InjectMocks
	private ArpenpBusiness arpenpBusiness;

	@Mock
	private ArpenpRepository arpenpRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAll() {
		List<Arpenp> mockedList = new ArrayList<Arpenp>();
		Arpenp arpenp = new Arpenp();
		arpenp.setConjuge("Antonio TORRES Coutinho");
		mockedList.add(arpenp);
		Mockito.when(arpenpRepository.findAll()).thenReturn(mockedList);
		List<Arpenp> listReturn = arpenpBusiness.findAll();

		Assert.assertEquals("Antonio TORRES Coutinho", listReturn.get(0).getConjuge());
	}
}
