package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="jucesp")
public class Jucesp {
	
	@Id
	private String id;

	private String nire;
	private String tipoEmpresa;
	private String dtConst;
	private String inicioAtividade;
	@Field("cnpj")
	private String cnpj;
	private String incricaoEstadual;
	private String objetoDescricao;
	private String capital;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
	private String municipio;
	private String cep;
	private String uf;
	
	public Jucesp() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNire() {
		return nire;
	}
	public void setNire(String nire) {
		this.nire = nire;
	}
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}
	public String getDtConst() {
		return dtConst;
	}
	public void setDtConst(String dtConst) {
		this.dtConst = dtConst;
	}
	public String getInicioAtividade() {
		return inicioAtividade;
	}
	public void setInicioAtividade(String inicioAtividade) {
		this.inicioAtividade = inicioAtividade;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getIncricaoEstadual() {
		return incricaoEstadual;
	}
	public void setIncricaoEstadual(String incricaoEstadual) {
		this.incricaoEstadual = incricaoEstadual;
	}
	public String getObjetoDescricao() {
		return objetoDescricao;
	}
	public void setObjetoDescricao(String objetoDescricao) {
		this.objetoDescricao = objetoDescricao;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Jucesp [id=" + id + ", nire=" + nire + ", tipoEmpresa=" + tipoEmpresa + ", dtConst=" + dtConst
				+ ", inicioAtividade=" + inicioAtividade + ", cnpj=" + cnpj + ", incricaoEstadual=" + incricaoEstadual
				+ ", objetoDescricao=" + objetoDescricao + ", capital=" + capital + ", logradouro=" + logradouro
				+ ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + ", municipio="
				+ municipio + ", cep=" + cep + ", uf=" + uf + "]";
	}
	
}
