package br.com.galaticos.galacticoScrapper.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="censec")
public class Censec {

	@Id
	private String id;
	// envio carga
	private String carga;
	private String dtMesAno;
	private String ato;
	private String dtAto;
	private String livro;
	private String complemento;
	private String folha;

	// partes
	private List<String> nome = new ArrayList<String>();
	private List<String> cpfCnpj = new ArrayList<String>();
	private List<String> qualidade = new ArrayList<String>();

	// dados cartorio
	private String uf;
	private String municipio;
	private String cartorio;
	private List<String> telefone = new ArrayList<String>();
	private List<String> tipo = new ArrayList<String>();
	private List<String> ramal = new ArrayList<String>();
	private List<String> contato = new ArrayList<String>();
	private List<String> status = new ArrayList<String>();

	public Censec() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}

	public String getDtMesAno() {
		return dtMesAno;
	}

	public void setDtMesAno(String dtMesAno) {
		this.dtMesAno = dtMesAno;
	}

	public String getAto() {
		return ato;
	}

	public void setAto(String ato) {
		this.ato = ato;
	}

	public String getDtAto() {
		return dtAto;
	}

	public void setDtAto(String dtAto) {
		this.dtAto = dtAto;
	}

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}

	public List<String> getNome() {
		return nome;
	}

	public void setNome(List<String> nome) {
		this.nome = nome;
	}

	public List<String> getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(List<String> cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public List<String> getQualidade() {
		return qualidade;
	}

	public void setQualidade(List<String> qualidade) {
		this.qualidade = qualidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getCartorio() {
		return cartorio;
	}

	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}

	public List<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	public List<String> getTipo() {
		return tipo;
	}

	public void setTipo(List<String> tipo) {
		this.tipo = tipo;
	}

	public List<String> getRamal() {
		return ramal;
	}

	public void setRamal(List<String> ramal) {
		this.ramal = ramal;
	}

	public List<String> getContato() {
		return contato;
	}

	public void setContato(List<String> contato) {
		this.contato = contato;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Censec [carga=" + carga + ", dtMesAno=" + dtMesAno + ", ato=" + ato + ", dtAto=" + dtAto + ", livro="
				+ livro + ", complemento=" + complemento + ", folha=" + folha + ", nome=" + nome + ", cpfCnpj="
				+ cpfCnpj + ", qualidade=" + qualidade + ", uf=" + uf + ", municipio=" + municipio + ", cartorio="
				+ cartorio + ", telefone=" + telefone + ", tipo=" + tipo + ", ramal=" + ramal + ", contato=" + contato
				+ ", status=" + status + "]";
	}

}
