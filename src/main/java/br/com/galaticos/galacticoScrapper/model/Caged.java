package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "caged")
public class Caged {

	@Id
	private String id;

	// identificacao
	private String CnpjCeiCpf;
	private String razaoSocial;

	// resumo dados cadastrais
	private String logradouro;
	private String bairoo;
	private String municipio;
	private String uf;
	private String cep;

	// contato
	private String nome;
	private String cpf;
	private String telefone;
	private String ramal;
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnpjCeiCpf() {
		return CnpjCeiCpf;
	}

	public void setCnpjCeiCpf(String cnpjCeiCpf) {
		CnpjCeiCpf = cnpjCeiCpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairoo() {
		return bairoo;
	}

	public void setBairoo(String bairoo) {
		this.bairoo = bairoo;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Caged [id=" + id + ", CnpjCeiCpf=" + CnpjCeiCpf + ", razaoSocial=" + razaoSocial + ", logradouro="
				+ logradouro + ", bairoo=" + bairoo + ", municipio=" + municipio + ", uf=" + uf + ", cep=" + cep
				+ ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", ramal=" + ramal + ", email=" + email
				+ "]";
	}

}
