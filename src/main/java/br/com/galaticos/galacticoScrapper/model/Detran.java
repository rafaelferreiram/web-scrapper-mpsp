package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "detran")
public class Detran {

	@Id
	private String id;
	
	private String renach;
	private String categoria;
	private String emissao;
	private String nascimento;
	private String nomeCondutor;
	private String nomePai;
	private String nomeMae;
	private String registro;
	private String tipografico;
	private String identidade;
	@Field("cpf")
	private String cpf;
	private String caminhoImg;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRenach() {
		return renach;
	}
	public void setRenach(String renach) {
		this.renach = renach;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEmissao() {
		return emissao;
	}
	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getNomeCondutor() {
		return nomeCondutor;
	}
	public void setNomeCondutor(String nomeCondutor) {
		this.nomeCondutor = nomeCondutor;
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
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getTipografico() {
		return tipografico;
	}
	public void setTipografico(String tipografico) {
		this.tipografico = tipografico;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCaminhoImg() {
		return caminhoImg;
	}
	public void setCaminhoImg(String caminhoImg) {
		this.caminhoImg = caminhoImg;
	}
	
}
