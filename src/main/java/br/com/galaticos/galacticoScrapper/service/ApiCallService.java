package br.com.galaticos.galacticoScrapper.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class ApiCallService {

	static final String BASE_URL = "http://localhost:18080/";

	public String getToJucesp(String cpfCnpj) {
		String output = "";
		try {
			URL apiUrl = new URL(BASE_URL + "jucesp/cnpj?cnpj=" + cpfCnpj);

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
				return "No data found".equals(output) ? null : output;
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return output;
	}

	public String getToCadesp(String cpfCnpj) {
		String output = "";
		try {
			URL apiUrl = new URL(BASE_URL + "cadesp/cnpj?cnpj=" + cpfCnpj);

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
				return "No data found".equals(output) ? null : output;
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return output;
	}

	public String getToArpenp(String cpfCnpj) {
		String output = "";
		try {
			URL apiUrl = new URL(BASE_URL + "arpend/cnpj?cnpj=" + cpfCnpj);

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
				return "No data found".equals(output) ? null : output;
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return output;
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
				concat+= "No data found".equals(outputCpf) ? null : outputCpf;
			}
			System.out.println(concat);
			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return concat;
	}

	public String getToCensec(String cpfCnpj) {
		String output = "";
		try {
			URL apiUrl = new URL(BASE_URL + "censec/cnpj?cnpj=" + cpfCnpj);

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
				return "No data found".equals(output) ? null : output;
			}

			conn.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return output;
	}

}
