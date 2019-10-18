package br.com.galaticos.galacticoScrapper.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.galaticos.galacticoScrapper.model.Arpenp;
import br.com.galaticos.galacticoScrapper.model.Cadesp;
import br.com.galaticos.galacticoScrapper.model.CagedAll;
import br.com.galaticos.galacticoScrapper.model.Censec;
import br.com.galaticos.galacticoScrapper.model.Jucesp;

@Service
public class ApiCallService {

	static final String BASE_URL = "http://localhost:18080/";

	public Jucesp getToJucesp(String cpfCnpj) {
		Jucesp jucesp = new Jucesp();
		try {
			URL apiUrl = new URL(BASE_URL + "jucesp/cnpj?cnpj=" + cpfCnpj.trim());

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn = connectToWebService(apiUrl, conn);
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = parseApiReturnToJson(br);

			if(!"No data found".equals(b.toString())) {
				jucesp = new Gson().fromJson(b.toString(), Jucesp.class);
			}

			conn.disconnect();
		} catch (IOException e) {

		}
		
		return jucesp.getId() == null ? null : jucesp;
	}

	public Cadesp getToCadesp(String cpfCnpj) {
		Cadesp cadesp = new Cadesp();
		try {
			URL apiUrl = new URL(BASE_URL + "cadesp/cnpj?cnpj=" + cpfCnpj.trim());

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn = connectToWebService(apiUrl, conn);
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = parseApiReturnToJson(br);

			if(!"No data found".equals(b.toString())) {
				cadesp = new Gson().fromJson(b.toString(), Cadesp.class);
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return cadesp.getId() == null ? null : cadesp;
	}

	public Arpenp getToArpenp(String cpfCnpj) {
		Arpenp arpenp = new Arpenp();
		try {
			URL apiUrl = new URL(BASE_URL + "arpend/cnpj?cnpj=" + cpfCnpj.trim());

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn = connectToWebService(apiUrl, conn);
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = parseApiReturnToJson(br);

			if(!"No data found".equals(b.toString())) {
				arpenp = new Gson().fromJson(b.toString(), Arpenp.class);
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return arpenp.getId() == null ? null : arpenp;
	}

	public CagedAll getToCagedCnpj(String cpfCnpj) {
		CagedAll cagedAll = new CagedAll();
		try {
			URL apiUrl = new URL(BASE_URL + "caged/cnpj?cnpj=" + cpfCnpj.trim());

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn = connectToWebService(apiUrl, conn);
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = parseApiReturnToJson(br);

			if(!"No data found".equals(b.toString())) {
				cagedAll = new Gson().fromJson(b.toString(), CagedAll.class);
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return cagedAll.getCagedEmpresa() == null && cagedAll.getCaged() == null ? null : cagedAll;
	}

	public CagedAll getToCagedCpf(String cpfCnpj) {
		CagedAll cagedAllCpf = new CagedAll();
		try {
			URL apiUrl = new URL(BASE_URL + "caged/cpf?cpf=" + cpfCnpj.trim());

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn = connectToWebService(apiUrl, conn);

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = parseApiReturnToJson(br);
			
			if(!"No data found".equals(b.toString())) {
				cagedAllCpf = new Gson().fromJson(b.toString(), CagedAll.class);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return cagedAllCpf.getCagedTrabalhador()  == null && cagedAllCpf.getCaged()  == null ? null : cagedAllCpf;
	}

	public Censec getToCensec(String cpfCnpj) {
		Censec censec = new Censec();
		try {
			URL apiUrl = new URL(BASE_URL + "censec/cnpj?cnpj=" + cpfCnpj.trim());
			
			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn = connectToWebService(apiUrl, conn);
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = parseApiReturnToJson(br);

			if(!"No data found".equals(b.toString())) {
				censec = new Gson().fromJson(b.toString(), Censec.class);
			}

			conn.disconnect();

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return censec.getId() == null ? null : censec;
	}

	private StringBuilder parseApiReturnToJson(BufferedReader br) throws IOException {
		StringBuilder b = new StringBuilder();
		String output = "";
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			b.append(output);
		}
		return b;
	}

	private HttpURLConnection connectToWebService(URL apiUrl, HttpURLConnection conn) throws IOException {
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		return conn;

	}

}
