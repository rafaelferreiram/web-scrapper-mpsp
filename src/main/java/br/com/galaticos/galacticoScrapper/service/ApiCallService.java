package br.com.galaticos.galacticoScrapper.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.galaticos.galacticoScrapper.model.Arpenp;
import br.com.galaticos.galacticoScrapper.model.Caged;
import br.com.galaticos.galacticoScrapper.model.Censec;
import br.com.galaticos.galacticoScrapper.model.Jucesp;

@Service
public class ApiCallService {

	static final String BASE_URL = "http://localhost:18080/";

	public Jucesp getToJucesp(String cpfCnpj) {
		Jucesp jucesp = new Jucesp();
		try {
			URL apiUrl = new URL(BASE_URL + "jucesp/cnpj?cnpj=" + cpfCnpj);

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			StringBuilder b = new StringBuilder();
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				b.append(output);
			}
			jucesp = new Gson().fromJson(b.toString(), Jucesp.class);
			System.out.println(jucesp);
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return jucesp;
	}

	public Caged getToCadesp(String cpfCnpj) {
		Caged caged = new Caged();
		try {
			URL apiUrl = new URL(BASE_URL + "cadesp/cnpj?cnpj=" + cpfCnpj);

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = new StringBuilder();
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				b.append(output);
			}
			caged = new Gson().fromJson(b.toString(), Caged.class);
			System.out.println(caged);
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return caged;
	}

	public Arpenp getToArpenp(String cpfCnpj) {
		Arpenp arpenp = new Arpenp();
		try {
			URL apiUrl = new URL(BASE_URL + "arpend/cnpj?cnpj=" + cpfCnpj);

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = new StringBuilder();
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				b.append(output);
			}
			arpenp = new Gson().fromJson(b.toString(), Arpenp.class);
			System.out.println(arpenp);

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return arpenp;
	}

	public String getToCaged(String cpfCnpj) {
		String output = "";
		String concat = "";
		try {
			URL apiUrl = new URL(BASE_URL + "caged/cnpj?cnpj=" + cpfCnpj);

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				concat = "No data found".equals(output) ? null : output;
			}

			apiUrl = new URL(BASE_URL + "caged/cpf?cpf=" + cpfCnpj);

			conn = (HttpURLConnection) apiUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String outputCpf;
			System.out.println("Output from Server .... \n");
			while ((outputCpf = br.readLine()) != null) {
				System.out.println(outputCpf);
				concat += "No data found".equals(outputCpf) ? null : outputCpf;
			}
			System.out.println(concat);
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return concat;
	}

	public Censec getToCensec(String cpfCnpj) {
		Censec censec = new Censec();
		try {
			URL apiUrl = new URL(BASE_URL + "censec/cnpj?cnpj=" + cpfCnpj);

			HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder b = new StringBuilder();
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				b.append(output);
			}
			censec = new Gson().fromJson(b.toString(), Censec.class);
			System.out.println(censec);
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return censec;
	}

}
