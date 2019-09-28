package br.com.galaticos.galacticoScrapper.model;

public class CagedEmpresa {

	//dados empresa
	private String cnpj;
	private String razaoSocial;
	private String atividadeEconomica;
	
	//totais
	private String numeroFiliais;
	private String totalVinculos;
	private String primeiroDia;
	private String admissoes;
	private String desligamentos;
	private String ultimoDia;
	private String variacaoAbsoluta;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getAtividadeEconomica() {
		return atividadeEconomica;
	}
	public void setAtividadeEconomica(String atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}
	public String getNumeroFiliais() {
		return numeroFiliais;
	}
	public void setNumeroFiliais(String numeroFiliais) {
		this.numeroFiliais = numeroFiliais;
	}
	public String getTotalVinculos() {
		return totalVinculos;
	}
	public void setTotalVinculos(String totalVinculos) {
		this.totalVinculos = totalVinculos;
	}
	public String getPrimeiroDia() {
		return primeiroDia;
	}
	public void setPrimeiroDia(String primeiroDia) {
		this.primeiroDia = primeiroDia;
	}
	public String getAdmissoes() {
		return admissoes;
	}
	public void setAdmissoes(String admissoes) {
		this.admissoes = admissoes;
	}
	public String getDesligamentos() {
		return desligamentos;
	}
	public void setDesligamentos(String desligamentos) {
		this.desligamentos = desligamentos;
	}
	public String getUltimoDia() {
		return ultimoDia;
	}
	public void setUltimoDia(String ultimoDia) {
		this.ultimoDia = ultimoDia;
	}
	public String getVariacaoAbsoluta() {
		return variacaoAbsoluta;
	}
	public void setVariacaoAbsoluta(String variacaoAbsoluta) {
		this.variacaoAbsoluta = variacaoAbsoluta;
	}
	@Override
	public String toString() {
		return "CagedEmpresa [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", atividadeEconomica="
				+ atividadeEconomica + ", numeroFiliais=" + numeroFiliais + ", totalVinculos=" + totalVinculos
				+ ", primeiroDia=" + primeiroDia + ", admissoes=" + admissoes + ", desligamentos=" + desligamentos
				+ ", ultimoDia=" + ultimoDia + ", variacaoAbsoluta=" + variacaoAbsoluta + "]";
	}
	
}
