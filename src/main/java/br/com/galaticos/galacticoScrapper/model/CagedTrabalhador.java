package br.com.galaticos.galacticoScrapper.model;

public class CagedTrabalhador {
	
	//identificacao
	private String nome;
	private String pis;
	private String pisConvertido;
	
	//resumo dos dados cadastrais
	private String cpf;
	private String dtNascimento;
	private String ctps;
	private String uf;
	private String situacaoPis;
	private String sexo;
	private String nacionalidade;
	private String racaCor;
	private String grauInstituicao;
	private String possuiDeficiencia;
	private String cep;
	
	//tempo de tabalho
	private String caged;
	private String rais;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public String getPisConvertido() {
		return pisConvertido;
	}
	public void setPisConvertido(String pisConvertido) {
		this.pisConvertido = pisConvertido;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getCtps() {
		return ctps;
	}
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getSituacaoPis() {
		return situacaoPis;
	}
	public void setSituacaoPis(String situacaoPis) {
		this.situacaoPis = situacaoPis;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getRacaCor() {
		return racaCor;
	}
	public void setRacaCor(String racaCor) {
		this.racaCor = racaCor;
	}
	public String getGrauInstituicao() {
		return grauInstituicao;
	}
	public void setGrauInstituicao(String grauInstituicao) {
		this.grauInstituicao = grauInstituicao;
	}
	public String getPossuiDeficiencia() {
		return possuiDeficiencia;
	}
	public void setPossuiDeficiencia(String possuiDeficiencia) {
		this.possuiDeficiencia = possuiDeficiencia;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCaged() {
		return caged;
	}
	public void setCaged(String caged) {
		this.caged = caged;
	}
	public String getRais() {
		return rais;
	}
	public void setRais(String rais) {
		this.rais = rais;
	}
	
	@Override
	public String toString() {
		return "CagedTrabalhador [nome=" + nome + ", pis=" + pis + ", pisConvertido=" + pisConvertido + ", cpf=" + cpf
				+ ", dtNascimento=" + dtNascimento + ", ctps=" + ctps + ", uf=" + uf + ", situacaoPis=" + situacaoPis
				+ ", sexo=" + sexo + ", nacionalidade=" + nacionalidade + ", racaCor=" + racaCor + ", grauInstituicao="
				+ grauInstituicao + ", possuiDeficiencia=" + possuiDeficiencia + ", cep=" + cep + ", caged=" + caged
				+ ", rais=" + rais + "]";
	}
	
}
