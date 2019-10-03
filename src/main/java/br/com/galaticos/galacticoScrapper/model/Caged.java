package br.com.galaticos.galacticoScrapper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "caged")
public class Caged {
	
	@Id
	private String id;

	// identificacao
	private String CnpjCeiCpf;
	private String razaoSocial;

	// resumo dados cadastrais
	private String logradouro;
	private String bairoo;
	private String municipio;
	private String uf;
	private String cep;

	// contato
	private String nome;
	private String cpf;
	private String telefone;
	private String ramal;
	private String email;

	// dados empresa
	private String cnpjCagedEmpresa;
	private String razaoSocialCagedEmpresa;
	private String atividadeEconomicaCagedEmpresa;

	// totais
	private String numeroFiliaisCagedEmpresa;
	private String totalVinculosCagedEmpresa;
	private String primeiroDiaCagedEmpresa;
	private String admissoesCagedEmpresa;
	private String desligamentosCagedEmpresa;
	private String ultimoDiaCagedEmpresa;
	private String variacaoAbsolutaCagedEmpresa;

	// identificacao
	private String nomeCagedTrabalhador;
	private String pisCagedTrabalhador;
	private String pisConvertidoCagedTrabalhador;

	// resumo dos dados cadastrais
	private String cpfCagedTrabalhador;
	private String dtNascimentoCagedTrabalhador;
	private String ctpsCagedTrabalhador;
	private String ufCagedTrabalhador;
	private String situacaoPisCagedTrabalhador;
	private String sexoCagedTrabalhador;
	private String nacionalidadeCagedTrabalhador;
	private String racaCorCagedTrabalhador;
	private String grauInstituicaoCagedTrabalhador;
	private String possuiDeficienciaCagedTrabalhador;
	private String cepCagedTrabalhador;

	// tempo de tabalho
	private String cagedCagedTrabalhador;
	private String raisCagedTrabalhador;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnpjCeiCpf() {
		return CnpjCeiCpf;
	}

	public void setCnpjCeiCpf(String cnpjCeiCpf) {
		CnpjCeiCpf = cnpjCeiCpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairoo() {
		return bairoo;
	}

	public void setBairoo(String bairoo) {
		this.bairoo = bairoo;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpjCagedEmpresa() {
		return cnpjCagedEmpresa;
	}

	public void setCnpjCagedEmpresa(String cnpjCagedEmpresa) {
		this.cnpjCagedEmpresa = cnpjCagedEmpresa;
	}

	public String getRazaoSocialCagedEmpresa() {
		return razaoSocialCagedEmpresa;
	}

	public void setRazaoSocialCagedEmpresa(String razaoSocialCagedEmpresa) {
		this.razaoSocialCagedEmpresa = razaoSocialCagedEmpresa;
	}

	public String getAtividadeEconomicaCagedEmpresa() {
		return atividadeEconomicaCagedEmpresa;
	}

	public void setAtividadeEconomicaCagedEmpresa(String atividadeEconomicaCagedEmpresa) {
		this.atividadeEconomicaCagedEmpresa = atividadeEconomicaCagedEmpresa;
	}

	public String getNumeroFiliaisCagedEmpresa() {
		return numeroFiliaisCagedEmpresa;
	}

	public void setNumeroFiliaisCagedEmpresa(String numeroFiliaisCagedEmpresa) {
		this.numeroFiliaisCagedEmpresa = numeroFiliaisCagedEmpresa;
	}

	public String getTotalVinculosCagedEmpresa() {
		return totalVinculosCagedEmpresa;
	}

	public void setTotalVinculosCagedEmpresa(String totalVinculosCagedEmpresa) {
		this.totalVinculosCagedEmpresa = totalVinculosCagedEmpresa;
	}

	public String getPrimeiroDiaCagedEmpresa() {
		return primeiroDiaCagedEmpresa;
	}

	public void setPrimeiroDiaCagedEmpresa(String primeiroDiaCagedEmpresa) {
		this.primeiroDiaCagedEmpresa = primeiroDiaCagedEmpresa;
	}

	public String getAdmissoesCagedEmpresa() {
		return admissoesCagedEmpresa;
	}

	public void setAdmissoesCagedEmpresa(String admissoesCagedEmpresa) {
		this.admissoesCagedEmpresa = admissoesCagedEmpresa;
	}

	public String getDesligamentosCagedEmpresa() {
		return desligamentosCagedEmpresa;
	}

	public void setDesligamentosCagedEmpresa(String desligamentosCagedEmpresa) {
		this.desligamentosCagedEmpresa = desligamentosCagedEmpresa;
	}

	public String getUltimoDiaCagedEmpresa() {
		return ultimoDiaCagedEmpresa;
	}

	public void setUltimoDiaCagedEmpresa(String ultimoDiaCagedEmpresa) {
		this.ultimoDiaCagedEmpresa = ultimoDiaCagedEmpresa;
	}

	public String getVariacaoAbsolutaCagedEmpresa() {
		return variacaoAbsolutaCagedEmpresa;
	}

	public void setVariacaoAbsolutaCagedEmpresa(String variacaoAbsolutaCagedEmpresa) {
		this.variacaoAbsolutaCagedEmpresa = variacaoAbsolutaCagedEmpresa;
	}

	public String getNomeCagedTrabalhador() {
		return nomeCagedTrabalhador;
	}

	public void setNomeCagedTrabalhador(String nomeCagedTrabalhador) {
		this.nomeCagedTrabalhador = nomeCagedTrabalhador;
	}

	public String getPisCagedTrabalhador() {
		return pisCagedTrabalhador;
	}

	public void setPisCagedTrabalhador(String pisCagedTrabalhador) {
		this.pisCagedTrabalhador = pisCagedTrabalhador;
	}

	public String getPisConvertidoCagedTrabalhador() {
		return pisConvertidoCagedTrabalhador;
	}

	public void setPisConvertidoCagedTrabalhador(String pisConvertidoCagedTrabalhador) {
		this.pisConvertidoCagedTrabalhador = pisConvertidoCagedTrabalhador;
	}

	public String getCpfCagedTrabalhador() {
		return cpfCagedTrabalhador;
	}

	public void setCpfCagedTrabalhador(String cpfCagedTrabalhador) {
		this.cpfCagedTrabalhador = cpfCagedTrabalhador;
	}

	public String getDtNascimentoCagedTrabalhador() {
		return dtNascimentoCagedTrabalhador;
	}

	public void setDtNascimentoCagedTrabalhador(String dtNascimentoCagedTrabalhador) {
		this.dtNascimentoCagedTrabalhador = dtNascimentoCagedTrabalhador;
	}

	public String getCtpsCagedTrabalhador() {
		return ctpsCagedTrabalhador;
	}

	public void setCtpsCagedTrabalhador(String ctpsCagedTrabalhador) {
		this.ctpsCagedTrabalhador = ctpsCagedTrabalhador;
	}

	public String getUfCagedTrabalhador() {
		return ufCagedTrabalhador;
	}

	public void setUfCagedTrabalhador(String ufCagedTrabalhador) {
		this.ufCagedTrabalhador = ufCagedTrabalhador;
	}

	public String getSituacaoPisCagedTrabalhador() {
		return situacaoPisCagedTrabalhador;
	}

	public void setSituacaoPisCagedTrabalhador(String situacaoPisCagedTrabalhador) {
		this.situacaoPisCagedTrabalhador = situacaoPisCagedTrabalhador;
	}

	public String getSexoCagedTrabalhador() {
		return sexoCagedTrabalhador;
	}

	public void setSexoCagedTrabalhador(String sexoCagedTrabalhador) {
		this.sexoCagedTrabalhador = sexoCagedTrabalhador;
	}

	public String getNacionalidadeCagedTrabalhador() {
		return nacionalidadeCagedTrabalhador;
	}

	public void setNacionalidadeCagedTrabalhador(String nacionalidadeCagedTrabalhador) {
		this.nacionalidadeCagedTrabalhador = nacionalidadeCagedTrabalhador;
	}

	public String getRacaCorCagedTrabalhador() {
		return racaCorCagedTrabalhador;
	}

	public void setRacaCorCagedTrabalhador(String racaCorCagedTrabalhador) {
		this.racaCorCagedTrabalhador = racaCorCagedTrabalhador;
	}

	public String getGrauInstituicaoCagedTrabalhador() {
		return grauInstituicaoCagedTrabalhador;
	}

	public void setGrauInstituicaoCagedTrabalhador(String grauInstituicaoCagedTrabalhador) {
		this.grauInstituicaoCagedTrabalhador = grauInstituicaoCagedTrabalhador;
	}

	public String getPossuiDeficienciaCagedTrabalhador() {
		return possuiDeficienciaCagedTrabalhador;
	}

	public void setPossuiDeficienciaCagedTrabalhador(String possuiDeficienciaCagedTrabalhador) {
		this.possuiDeficienciaCagedTrabalhador = possuiDeficienciaCagedTrabalhador;
	}

	public String getCepCagedTrabalhador() {
		return cepCagedTrabalhador;
	}

	public void setCepCagedTrabalhador(String cepCagedTrabalhador) {
		this.cepCagedTrabalhador = cepCagedTrabalhador;
	}

	public String getCagedCagedTrabalhador() {
		return cagedCagedTrabalhador;
	}

	public void setCagedCagedTrabalhador(String cagedCagedTrabalhador) {
		this.cagedCagedTrabalhador = cagedCagedTrabalhador;
	}

	public String getRaisCagedTrabalhador() {
		return raisCagedTrabalhador;
	}

	public void setRaisCagedTrabalhador(String raisCagedTrabalhador) {
		this.raisCagedTrabalhador = raisCagedTrabalhador;
	}

	@Override
	public String toString() {
		return "Caged [CnpjCeiCpf=" + CnpjCeiCpf + ", razaoSocial=" + razaoSocial + ", logradouro=" + logradouro
				+ ", bairoo=" + bairoo + ", municipio=" + municipio + ", uf=" + uf + ", cep=" + cep + ", nome=" + nome
				+ ", cpf=" + cpf + ", telefone=" + telefone + ", ramal=" + ramal + ", email=" + email
				+ ", cnpjCagedEmpresa=" + cnpjCagedEmpresa + ", razaoSocialCagedEmpresa=" + razaoSocialCagedEmpresa
				+ ", atividadeEconomicaCagedEmpresa=" + atividadeEconomicaCagedEmpresa + ", numeroFiliaisCagedEmpresa="
				+ numeroFiliaisCagedEmpresa + ", totalVinculosCagedEmpresa=" + totalVinculosCagedEmpresa
				+ ", primeiroDiaCagedEmpresa=" + primeiroDiaCagedEmpresa + ", admissoesCagedEmpresa="
				+ admissoesCagedEmpresa + ", desligamentosCagedEmpresa=" + desligamentosCagedEmpresa
				+ ", ultimoDiaCagedEmpresa=" + ultimoDiaCagedEmpresa + ", variacaoAbsolutaCagedEmpresa="
				+ variacaoAbsolutaCagedEmpresa + ", nomeCagedTrabalhador=" + nomeCagedTrabalhador
				+ ", pisCagedTrabalhador=" + pisCagedTrabalhador + ", pisConvertidoCagedTrabalhador="
				+ pisConvertidoCagedTrabalhador + ", cpfCagedTrabalhador=" + cpfCagedTrabalhador
				+ ", dtNascimentoCagedTrabalhador=" + dtNascimentoCagedTrabalhador + ", ctpsCagedTrabalhador="
				+ ctpsCagedTrabalhador + ", ufCagedTrabalhador=" + ufCagedTrabalhador + ", situacaoPisCagedTrabalhador="
				+ situacaoPisCagedTrabalhador + ", sexoCagedTrabalhador=" + sexoCagedTrabalhador
				+ ", nacionalidadeCagedTrabalhador=" + nacionalidadeCagedTrabalhador + ", racaCorCagedTrabalhador="
				+ racaCorCagedTrabalhador + ", grauInstituicaoCagedTrabalhador=" + grauInstituicaoCagedTrabalhador
				+ ", possuiDeficienciaCagedTrabalhador=" + possuiDeficienciaCagedTrabalhador + ", cepCagedTrabalhador="
				+ cepCagedTrabalhador + ", cagedCagedTrabalhador=" + cagedCagedTrabalhador + ", raisCagedTrabalhador="
				+ raisCagedTrabalhador + "]";
	}

}
