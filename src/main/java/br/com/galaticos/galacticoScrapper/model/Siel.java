package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="siel")
public class Siel {
	
	@Id
	private String id;
	private String nome;
	private String titulo;
	private String dtNascimento;
	private String zone;
	private String endereco;
	private String municipio;
	private String uf;
	private String dtDomicilio;
	private String nomePai;
	private String nomeMae;
	private String naturalidade;
	private String cdValidacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getDtDomicilio() {
		return dtDomicilio;
	}

	public void setDtDomicilio(String dtDomicilio) {
		this.dtDomicilio = dtDomicilio;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getCdValidacao() {
		return cdValidacao;
	}

	public void setCdValidacao(String cdValidacao) {
		this.cdValidacao = cdValidacao;
	}

	@Override
	public String toString() {
		return "Siel [nome=" + nome + ", titulo=" + titulo + ", dtNascimento=" + dtNascimento + ", zone=" + zone
				+ ", endereco=" + endereco + ", municipio=" + municipio + ", uf=" + uf + ", dtDomicilio=" + dtDomicilio
				+ ", nomePai=" + nomePai + ", nomeMae=" + nomeMae + ", naturalidade=" + naturalidade + ", cdValidacao="
				+ cdValidacao + "]";
	}
}
