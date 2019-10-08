package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sivec {
	
	@Id
	private String id;

	//detalhes do reu
	private String nome;
	private String sexo;
	private String rg;
	private String tipoRg;
	private String dtNascimento;
	private String controleVec;
	private String emissaoRg;
	private String estadoCivil;
	private String naturalizado;
	private String naturalidade;
	private String grauInstituicao;
	private String nomePai;
	private String nomeMae;
	private String corPele;
	private String profissao;
	private String cabelo;
	private String corOlhos;
	private String formulaFundamental;
	private String postoIdentificacao;
	private String alcunha;
	
	//enderecos
	private String residencial;
	private String trabalho;
	
	//outros
	private String nomeOutros;
	private String rgOutros;
	private String dtNascimentoOutros;
	private String nacionalidadeOutros;
	private String nomePaiOutros;
	private String nomeMaeOutros;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTipoRg() {
		return tipoRg;
	}
	public void setTipoRg(String tipoRg) {
		this.tipoRg = tipoRg;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getControleVec() {
		return controleVec;
	}
	public void setControleVec(String controleVec) {
		this.controleVec = controleVec;
	}
	public String getEmissaoRg() {
		return emissaoRg;
	}
	public void setEmissaoRg(String emissaoRg) {
		this.emissaoRg = emissaoRg;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getNaturalizado() {
		return naturalizado;
	}
	public void setNaturalizado(String naturalizado) {
		this.naturalizado = naturalizado;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getGrauInstituicao() {
		return grauInstituicao;
	}
	public void setGrauInstituicao(String grauInstituicao) {
		this.grauInstituicao = grauInstituicao;
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
	public String getCorPele() {
		return corPele;
	}
	public void setCorPele(String corPele) {
		this.corPele = corPele;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getCabelo() {
		return cabelo;
	}
	public void setCabelo(String cabelo) {
		this.cabelo = cabelo;
	}
	public String getCorOlhos() {
		return corOlhos;
	}
	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
	}
	public String getFormulaFundamental() {
		return formulaFundamental;
	}
	public void setFormulaFundamental(String formulaFundamental) {
		this.formulaFundamental = formulaFundamental;
	}
	public String getPostoIdentificacao() {
		return postoIdentificacao;
	}
	public void setPostoIdentificacao(String postoIdentificacao) {
		this.postoIdentificacao = postoIdentificacao;
	}
	public String getAlcunha() {
		return alcunha;
	}
	public void setAlcunha(String alcunha) {
		this.alcunha = alcunha;
	}
	public String getResidencial() {
		return residencial;
	}
	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}
	public String getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(String trabalho) {
		this.trabalho = trabalho;
	}
	public String getNomeOutros() {
		return nomeOutros;
	}
	public void setNomeOutros(String nomeOutros) {
		this.nomeOutros = nomeOutros;
	}
	public String getRgOutros() {
		return rgOutros;
	}
	public void setRgOutros(String rgOutros) {
		this.rgOutros = rgOutros;
	}
	public String getDtNascimentoOutros() {
		return dtNascimentoOutros;
	}
	public void setDtNascimentoOutros(String dtNascimentoOutros) {
		this.dtNascimentoOutros = dtNascimentoOutros;
	}
	public String getNacionalidadeOutros() {
		return nacionalidadeOutros;
	}
	public void setNacionalidadeOutros(String nacionalidadeOutros) {
		this.nacionalidadeOutros = nacionalidadeOutros;
	}
	public String getNomePaiOutros() {
		return nomePaiOutros;
	}
	public void setNomePaiOutros(String nomePaiOutros) {
		this.nomePaiOutros = nomePaiOutros;
	}
	public String getNomeMaeOutros() {
		return nomeMaeOutros;
	}
	public void setNomeMaeOutros(String nomeMaeOutros) {
		this.nomeMaeOutros = nomeMaeOutros;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Sivec [nome=" + nome + ", sexo=" + sexo + ", rg=" + rg + ", tipoRg=" + tipoRg + ", dtNascimento="
				+ dtNascimento + ", controleVec=" + controleVec + ", emissaoRg=" + emissaoRg + ", estadoCivil="
				+ estadoCivil + ", naturalizado=" + naturalizado + ", naturalidade=" + naturalidade
				+ ", grauInstituicao=" + grauInstituicao + ", nomePai=" + nomePai + ", nomeMae=" + nomeMae
				+ ", corPele=" + corPele + ", profissao=" + profissao + ", cabelo=" + cabelo + ", corOlhos=" + corOlhos
				+ ", formulaFundamental=" + formulaFundamental + ", postoIdentificacao=" + postoIdentificacao
				+ ", alcunha=" + alcunha + ", residencial=" + residencial + ", trabalho=" + trabalho + ", nomeOutros="
				+ nomeOutros + ", rgOutros=" + rgOutros + ", dtNascimentoOutros=" + dtNascimentoOutros
				+ ", nacionalidadeOutros=" + nacionalidadeOutros + ", nomePaiOutros=" + nomePaiOutros
				+ ", nomeMaeOutros=" + nomeMaeOutros + "]";
	}
	
}
