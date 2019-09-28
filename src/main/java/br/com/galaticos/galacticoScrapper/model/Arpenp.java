package br.com.galaticos.galacticoScrapper.model;

public class Arpenp {

	private String cartorio;
	private String cns;
	private String uf;
	private String conjuge;
	private String conjugeNovoNome;
	private String conjuge2;
	private String conjuge2NovoNome;
	private String dtCasamento;
	private String matricula;
	private String dtEntrada;
	private String dtRegistro;
	private String acervo;
	private String numeroLivro;
	private String numeroFolha;
	private String numeroRegistro;
	private String tipoLivro;

	public String getCartorio() {
		return cartorio;
	}

	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}

	public String getCns() {
		return cns;
	}

	public void setCns(String cns) {
		this.cns = cns;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getConjuge() {
		return conjuge;
	}

	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}

	public String getConjugeNovoNome() {
		return conjugeNovoNome;
	}

	public void setConjugeNovoNome(String conjugeNovoNome) {
		this.conjugeNovoNome = conjugeNovoNome;
	}

	public String getConjuge2() {
		return conjuge2;
	}

	public void setConjuge2(String conjuge2) {
		this.conjuge2 = conjuge2;
	}

	public String getConjuge2NovoNome() {
		return conjuge2NovoNome;
	}

	public void setConjuge2NovoNome(String conjuge2NovoNome) {
		this.conjuge2NovoNome = conjuge2NovoNome;
	}

	public String getDtCasamento() {
		return dtCasamento;
	}

	public void setDtCasamento(String dtCasamento) {
		this.dtCasamento = dtCasamento;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public String getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(String dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public String getAcervo() {
		return acervo;
	}

	public void setAcervo(String acervo) {
		this.acervo = acervo;
	}

	public String getNumeroLivro() {
		return numeroLivro;
	}

	public void setNumeroLivro(String numeroLivro) {
		this.numeroLivro = numeroLivro;
	}

	public String getNumeroFolha() {
		return numeroFolha;
	}

	public void setNumeroFolha(String numeroFolha) {
		this.numeroFolha = numeroFolha;
	}

	public String getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(String numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	@Override
	public String toString() {
		return "Arpenp [cartorio=" + cartorio + ", cns=" + cns + ", uf=" + uf + ", conjuge=" + conjuge
				+ ", conjugeNovoNome=" + conjugeNovoNome + ", conjuge2=" + conjuge2 + ", conjuge2NovoNome="
				+ conjuge2NovoNome + ", dtCasamento=" + dtCasamento + ", matricula=" + matricula + ", dtEntrada="
				+ dtEntrada + ", dtRegistro=" + dtRegistro + ", acervo=" + acervo + ", numeroLivro=" + numeroLivro
				+ ", numeroFolha=" + numeroFolha + ", numeroRegistro=" + numeroRegistro + ", tipoLivro=" + tipoLivro
				+ "]";
	}

}
