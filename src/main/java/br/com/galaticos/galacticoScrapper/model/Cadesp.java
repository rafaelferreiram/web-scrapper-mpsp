package br.com.galaticos.galacticoScrapper.model;

public class Cadesp {

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
