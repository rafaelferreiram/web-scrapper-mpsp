package br.com.galaticos.galacticoScrapper.service;

import java.io.IOException;
import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import br.com.galaticos.galacticoScrapper.executor.MockSrapperExecutor;


@Service
public class MockScrapper {

	@Autowired
	private MockSrapperExecutor mockSrapperExecutor;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MockScrapper.class);

	public boolean initCrawaler(boolean isActive) {
		boolean valid = Boolean.FALSE;
		try {
			logger.info("Scrapper initialized at "+new Date());
			mockSrapperExecutor.execute();
			logger.info("Scrapper finished at "+new Date());
			valid = Boolean.TRUE;
		} catch (InterruptedException | IOException | DocumentException e) {
			//Silence error enableing to keep execution
		}
		return valid;
	}


}