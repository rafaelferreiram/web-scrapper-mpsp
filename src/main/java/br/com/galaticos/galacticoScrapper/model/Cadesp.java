package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cadesp")
public class Cadesp {

	@Id
	private String id;
	private String ie;
	private String cnpj;
	private String situacao;
	private String dtInscricaoEstado;
	private String nomeEmpresarial;
	private String regimeEstadual;
	private String drt;
	private String postoFiscal;
	private String dtInicioIE;
	private String nire;
	private String ocorrenciaFiscal;
	private String tipoUnidade;
	private String formaAtuacao;

	public Cadesp() {
		super();
	}

	public Cadesp(String id, String ie, String cnpj, String situacao, String dtInscricaoEstado, String nomeEmpresarial,
			String regimeEstadual, String drt, String postoFiscal, String dtInicioIE, String nire,
			String ocorrenciaFiscal, String tipoUnidade, String formaAtuacao) {
		super();
		this.id = id;
		this.ie = ie;
		this.cnpj = cnpj;
		this.situacao = situacao;
		this.dtInscricaoEstado = dtInscricaoEstado;
		this.nomeEmpresarial = nomeEmpresarial;
		this.regimeEstadual = regimeEstadual;
		this.drt = drt;
		this.postoFiscal = postoFiscal;
		this.dtInicioIE = dtInicioIE;
		this.nire = nire;
		this.ocorrenciaFiscal = ocorrenciaFiscal;
		this.tipoUnidade = tipoUnidade;
		this.formaAtuacao = formaAtuacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDtInscricaoEstado() {
		return dtInscricaoEstado;
	}

	public void setDtInscricaoEstado(String dtInscricaoEstado) {
		this.dtInscricaoEstado = dtInscricaoEstado;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public void setNomeEmpresarial(String nomeEmpresarial) {
		this.nomeEmpresarial = nomeEmpresarial;
	}

	public String getRegimeEstadual() {
		return regimeEstadual;
	}

	public void setRegimeEstadual(String regimeEstadual) {
		this.regimeEstadual = regimeEstadual;
	}

	public String getDrt() {
		return drt;
	}

	public void setDrt(String drt) {
		this.drt = drt;
	}

	public String getPostoFiscal() {
		return postoFiscal;
	}

	public void setPostoFiscal(String postoFiscal) {
		this.postoFiscal = postoFiscal;
	}

	public String getDtInicioIE() {
		return dtInicioIE;
	}

	public void setDtInicioIE(String dtInicioIE) {
		this.dtInicioIE = dtInicioIE;
	}

	public String getNire() {
		return nire;
	}

	public void setNire(String nire) {
		this.nire = nire;
	}

	public String getOcorrenciaFiscal() {
		return ocorrenciaFiscal;
	}

	public void setOcorrenciaFiscal(String ocorrenciaFiscal) {
		this.ocorrenciaFiscal = ocorrenciaFiscal;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getFormaAtuacao() {
		return formaAtuacao;
	}

	public void setFormaAtuacao(String formaAtuacao) {
		this.formaAtuacao = formaAtuacao;
	}

	@Override
	public String toString() {
		return "Cadesp [ie=" + ie + ", cnpj=" + cnpj + ", situacao=" + situacao + ", dtInscricaoEstado="
				+ dtInscricaoEstado + ", nomeEmpresarial=" + nomeEmpresarial + ", regimeEstadual=" + regimeEstadual
				+ ", drt=" + drt + ", postoFiscal=" + postoFiscal + ", dtInicioIE=" + dtInicioIE + ", nire=" + nire
				+ ", ocorrenciaFiscal=" + ocorrenciaFiscal + ", tipoUnidade=" + tipoUnidade + ", formaAtuacao="
				+ formaAtuacao + "]";
	}
}
