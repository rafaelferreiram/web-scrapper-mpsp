<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

<head>
<title>MPSP</title>

<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/result-page.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Raleway&display=swap"
	rel="stylesheet">

<script src="/js/jspdf.js"></script>
<script src="/js/jquery-2.1.3.js"></script>
<script src="/js/pdfFromHTML.js"></script>
</head>

<body>
	<nav class="navbar d-flex justify-content-between">
		<div>
			<a href="${contextPath}/research" class="navbar-brand"> MPSP
				Scrapper </a>
		</div>
		<div class="block-button">
			<form class="form-button" action="${contextPath}/logout">
				<input class="button btn btn-outline-light btn-sm" type="submit"
					value="Logout" />
			</form>
		</div>
	</nav>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<!-- Heading Row -->
			<div class="col-10">
				<div id="HTMLtoPDF">
					<!-- BEGIN ARPENP DATA -->
					<c:if test="${not empty arpenp }">
						<h2>Arpenp</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<!-- ARPENP  -->
							<label><b>Cartorio : </b>${arpenp.cartorio} </label> <br> <label><b>CNS
									:</b>${arpenp.cns} </label> <br> <label><b>UF : </b>${arpenp.uf}
							</label> <br> <label><b>Nome Conjuge : </b>${arpenp.conjuge}
							</label> <br> <label><b>Novo nome Conjuge :</b>
								${arpenp.conjugeNovoNome} </label> <br> <label><b>Nome
									Conjuge 2 :</b> ${arpenp.conjuge2} </label> <br> <label><b>Novo
									nome Conjuge 2 :</b> ${arpenp.conjuge2NovoNome} </label> <br> <label><b>Data
									Casamento :</b> ${arpenp.dtCasamento} </label> <br> <label><b>Matricula
									: </b>${arpenp.matricula} </label> <br> <label><b>Data da
									Entrada : </b>${arpenp.dtEntrada} </label> <br> <label><b>Data
									do Registro : </b>${arpenp.dtRegistro} </label> <br> <label><b>Acervo
									:</b> ${arpenp.acervo} </label> <br> <label><b>Numero do
									Livro :</b> ${arpenp.numeroLivro} </label> <br> <label><b>Numero
									da Folha :</b> ${arpenp.numeroFolha} </label> <br> <label><b>Numero
									do Registro :</b> ${arpenp.numeroRegistro} </label> <br> <label><b>Tipo
									da Folha : </b>${arpenp.tipoLivro} </label> <br>
							<!-- END ARPENP  -->
						</div>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty arpenpList }">
							<h2>Arpenp</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${arpenpList}" var="arpenp">
									<!-- ARPENP  -->
									<label><b>Cartorio : </b>${arpenp.cartorio} </label>
									<br>
									<label><b>CNS : </b>${arpenp.cns} </label>
									<br>
									<label><b>UF :</b> ${arpenp.uf} </label>
									<br>
									<label><b>Nome Conjuge :</b> ${arpenp.conjuge} </label>
									<br>
									<label><b>Novo nome Conjuge :</b>
										${arpenp.conjugeNovoNome} </label>
									<br>
									<label><b>Nome Conjuge 2 : </b>${arpenp.conjuge2} </label>
									<br>
									<label><b>Novo nome Conjuge 2 :</b>
										${arpenp.conjuge2NovoNome} </label>
									<br>
									<label><b>Data Casamento :</b> ${arpenp.dtCasamento} </label>
									<br>
									<label><b>Matricula :</b> ${arpenp.matricula} </label>
									<br>
									<label><b>Data da Entrada :</b> ${arpenp.dtEntrada} </label>
									<br>
									<label><b>Data do Registro : </b>${arpenp.dtRegistro} </label>
									<br>
									<label><b>Acervo : </b>${arpenp.acervo} </label>
									<br>
									<label><b>Numero do Livro : </b>${arpenp.numeroLivro} </label>
									<br>
									<label><b>Numero da Folha :</b> ${arpenp.numeroFolha} </label>
									<br>
									<label><b>Numero do Registro : </b>${arpenp.numeroRegistro}
									</label>
									<br>
									<label><b>Tipo da Folha : </b>${arpenp.tipoLivro} </label>
									<br>
									<!-- END ARPENP  -->
								</c:forEach>
							</div>
						</c:if>
					</div>
					<!-- END ARPENP DATA -->
					
					<!-- BEGIN DETRAN DATA -->
					<c:if test="${not empty detranInfo}">
						<h2>Detran :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<!-- DETRAN  -->
							<img src="${detranInfo.caminhoImg}" alt="imgProfiel" height="200"
								width="150"> <br> <label><b>Nome Condutor
									:</b> ${detranInfo.nomeCondutor} </label> <br> <label><b>CPF
									: </b>${detranInfo.cpf} </label> <br> <label><b>Identidade
									: </b>${detranInfo.identidade} </label> <br> <label><b>Renach
									:</b> ${detranInfo.renach} </label> <br> <label><b>Categoria
									:</b> ${detranInfo.categoria} </label> <br> <label><b>Emissao
									: </b>${detranInfo.emissao} </label> <br> <label><b>Nascimento
									:</b> ${detranInfo.nascimento} </label> <br> <label><b>Nome
									do Pai :</b>${detranInfo.nomePai} </label> <br> <label><b>Nome
									da Mae : </b>${detranInfo.nomeMae} </label> <br> <label><b>Registro
									: </b>${detranInfo.registro} </label> <br> <label><b>Tipo
									Grafico : </b>${detranInfo.tipografico} </label> <br>
							<!-- END DETRAN  -->
						</div>

						<object width="700" height="500" data="${detran}" width="400"
							height="300"></object>
						<object width="700" height="500" data="${detran2}" width="400"
							height="300"></object>
						<br>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty detranList}">
							<h2>Detran :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${detranList}" var="detran">
									<img src="${detran.caminhoImg}" alt="imgProfiel" height="200"
										width="150">
									<!-- DETRAN  -->
									<label><b>Nome Condutor :</b> ${detran.nomeCondutor} </label>
									<br>
									<label><b>CPF :</b> ${detran.cpf} </label>
									<br>
									<label><b>Identidade : </b>${detran.identidade} </label>
									<br>
									<label><b>Renach : </b>${detran.renach} </label>
									<br>
									<label><b>Categoria :</b> ${detran.categoria} </label>
									<br>
									<label><b>Emissao : </b>${detran.emissao} </label>
									<br>
									<label><b>Nascimento : </b>${detran.nascimento} </label>
									<br>
									<label><b>Nome do Pai :</b> ${detran.nomePai} </label>
									<br>
									<label><b>Nome da Mae : </b>${detran.nomeMae} </label>
									<br>
									<label><b>Registro : </b>${detran.registro} </label>
									<br>
									<label><b>Tipo Grafico :</b> ${detran.tipografico} </label>
									<br>
									<!-- END DETRAN  -->
									<br>
								</c:forEach>
								<object width="700" height="500" data="${detran}" width="400"
									height="300"></object>
								<object width="700" height="500" data="${detran2}" width="400"
									height="300"></object>
							</div>
							<br>
						</c:if>
					</div>
					<!-- END DETRAN DATA -->
					
					<!-- BEGIN CADESP DATA -->
					<c:if test="${not empty cadesp}">
						<h2>Cadesp :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<!-- CADESP  -->
							<label><b>IE :</b> ${cadesp.ie} </label> <br> <label><b>CNPJ
									: </b>${cadesp.cnpj} </label> <br> <label><b>Situacao :</b>
								${cadesp.situacao} </label> <br> <label><b>Data
									Inscricao Estado :</b> ${cadesp.dtInscricaoEstado} </label> <br> <label><b>Nome
									Empresarial :</b> ${cadesp.nomeEmpresarial} </label> <br> <label><b>Regime
									Estadual:</b> ${cadesp.regimeEstadual} </label> <br> <label><b>DRT
									:</b> ${cadesp.drt} </label> <br> <label><b>Posto Fiscal :</b>
								${cadesp.postoFiscal} </label> <br> <label><b>Data
									Inicio IE :</b> ${cadesp.dtInicioIE} </label> <br> <label><b>NIRE
									:</b> ${cadesp.nire} </label> <br> <label><b>Ocorrencia
									Fiscal :</b> ${cadesp.ocorrenciaFiscal} </label> <br> <label><b>Tipo
									de Unidade :</b> ${cadesp.tipoUnidade} </label> <br> <label><b>Forma
									de Atuacao :</b> ${cadesp.formaAtuacao} </label> <br>
							<!-- END CADESP  -->
						</div>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty cadespList}">
							<h2>Cadesp :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${cadespList}" var="cadesp">
									<!-- CADESP  -->
									<label><b>IE :</b> ${cadesp.ie} </label>
									<br>
									<label><b>CNPJ :</b> ${cadesp.cnpj} </label>
									<br>
									<label><b>Situacao : </b>${cadesp.situacao} </label>
									<br>
									<label><b>Data Inscricao Estado :</b>
										${cadesp.dtInscricaoEstado} </label>
									<br>
									<label><b>Nome Empresarial : </b>${cadesp.nomeEmpresarial}
									</label>
									<br>
									<label><b>Regime Estadual: </b>${cadesp.regimeEstadual}
									</label>
									<br>
									<label><b>DRT : </b>${cadesp.drt} </label>
									<br>
									<label><b>Posto Fiscal : </b>${cadesp.postoFiscal} </label>
									<br>
									<label><b>Data Inicio IE : </b>${cadesp.dtInicioIE} </label>
									<br>
									<label><b>NIRE :</b> ${cadesp.nire} </label>
									<br>
									<label><b>Ocorrencia Fiscal :</b>
										${cadesp.ocorrenciaFiscal} </label>
									<br>
									<label><b>Tipo de Unidade :</b>${cadesp.tipoUnidade} </label>
									<br>
									<label><b>Forma de Atuacao :</b> ${cadesp.formaAtuacao}
									</label>
									<br>
									<!-- END CADESP  -->
								</c:forEach>
							</div>
						</c:if>
					</div>
					<!-- END CADESP DATA -->
					
					<!-- BEGIN ARISP DATA -->
					<div style="margin-top: 50px">
						<c:if test="${not empty arisp}">
							<h2>Arisp :</h2>
							<hr>
							<object width="700" height="500" data="${arisp}" width="400"
								height="300"></object>
							<br>
						</c:if>
					</div>
					<!-- END ARISP DATA -->
					
					<!-- BEGIN INFOCRIM DATA -->
					<div style="margin-top: 50px">
						<c:if test="${not empty infocrim}">
							<h2>Infocrim :</h2>
							<hr>
							<object width="700" height="500" data="${infocrim}" width="400"
								height="300"></object>
							<br>
						</c:if>
					</div>
					<!-- END INFOCRIM DATA -->
					
					<!-- BEGIN JUCESP DATA -->
					<c:if test="${not empty jucesp}">
						<h2>Jucesp :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<br> <label><b>Nire Matriz :</b> ${jucesp.nire} </label> <br>
							<label><b>Tipo de Empresa : </b>${jucesp.tipoEmpresa} </label> <br>
							<label><b>Data da constituição : </b>${jucesp.dtConst} </label> <br>
							<label><b>Inicio da Atividade :</b>
								${jucesp.inicioAtividade} </label> <br> <label><b>CNPJ
									: </b>${jucesp.cnpj} </label> <br> <label><b>Inscricao
									Estadual :</b> ${jucesp.incricaoEstadual} </label> <br> <label><b>Objeto
									Descricao :</b> ${jucesp.objetoDescricao} </label> <br> <label><b>Capital
									: </b>${jucesp.capital} </label> <br> <label><b>Logradouro
									:</b> ${jucesp.logradouro} </label> <br> <label><b>Numero
									:</b> ${jucesp.numero} </label> <br> <label><b>Bairro :</b>
								${jucesp.bairro} </label> <br> <label><b>Complemento :</b>
								${jucesp.complemento} </label> <br> <label><b>Municipio
									:</b> ${jucesp.municipio} </label> <br> <label><b>CEP :</b>
								${jucesp.cep} </label> <br> <label><b>UF :</b> ${jucesp.uf}
							</label><br>
						</div>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty jucespList}">
							<h2>Jucesp :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${jucespList}" var="jucesp">
									<br>
									<label><b>Nire Matriz :</b> ${jucesp.nire} </label>
									<br>
									<label><b>Tipo de Empresa : </b>${jucesp.tipoEmpresa} </label>
									<br>
									<label><b>Data da constituição : </b>${jucesp.dtConst}
									</label>
									<br>
									<label><b>Inicio da Atividade :</b>
										${jucesp.inicioAtividade} </label>
									<br>
									<label><b>CNPJ : </b>${jucesp.cnpj} </label>
									<br>
									<label><b>Inscricao Estadual : </b>${jucesp.incricaoEstadual}
									</label>
									<br>
									<label><b>Objeto Descricao : </b>${jucesp.objetoDescricao}
									</label>
									<br>
									<label><b>Capital : </b>${jucesp.capital} </label>
									<br>
									<label><b>Logradouro :</b> ${jucesp.logradouro} </label>
									<br>
									<label><b>Numero : </b>${jucesp.numero} </label>
									<br>
									<label><b>Bairro :</b> ${jucesp.bairro} </label>
									<br>
									<label><b>Complemento : </b>${jucesp.complemento} </label>
									<br>
									<label><b>Municipio : </b>${jucesp.municipio} </label>
									<br>
									<label><b>CEP :</b> ${jucesp.cep} </label>
									<br>
									<label><b>UF : </b>${jucesp.uf} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<div style="margin-top: 50px">
						<c:if test="${not empty jucespPDF}">
							<h2>Jucesp :</h2>
							<hr>
							<object width="700" height="500" data="${jucespPDF}" width="400"
								height="300"></object>
							<br>
						</c:if>
					</div>
					<!-- END JUCESP DATA -->
					
					<!-- BEGIN SIVEC DATA -->
					<c:if test="${not empty sivec}">
						<h2>Sivec :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<label><b>Nome : </b>${sivec.nome} </label> <br> <label><b>Sexo
									:</b> ${sivec.sexo} </label> <br> <label><b>RG :</b>
								${sivec.rg} </label> <br> <label><b>Tipo de RG :</b>
								${sivec.tipoRg} </label> <br> <label><b>Data de
									Nascimento : </b>${sivec.dtNascimento} </label> <br> <label><b>Controle
									: </b>${sivec.controleVec} </label> <br> <label><b>Emissao
									do RG :</b> ${sivec.emissaoRg} </label> <br> <label><b>Estado
									Civil :</b> ${sivec.estadoCivil} </label> <br> <label><b>Naturalizado
									:</b> ${sivec.naturalizado} </label> <br> <label><b>Naturalidade
									:</b> ${sivec.naturalidade} </label> <br> <label><b>Grau
									de Instituicao : </b>${sivec.grauInstituicao} </label> <br> <label><b>Nome
									do Pai :</b> ${sivec.nomePai} </label> <br> <label><b>Nome
									da Mae :</b> ${sivec.nomeMae} </label> <br> <label><b>Cor
									da Pele :</b> ${sivec.corPele} </label> <br> <label><b>Profissao
									:</b> ${sivec.profissao} </label> <br> <label><b>Cabelo :</b>
								${sivec.cabelo} </label> <br> <label><b>Cor dos Olhos :</b>
								${sivec.corOlhos} </label> <br> <label><b>Formula
									Fundamental</b> : ${sivec.formulaFundamental} </label> <br> <label><b>Posto
									de Identificacao :</b> ${sivec.postoIdentificacao} </label> <br> <label><b>Alcunha
									:</b> ${sivec.alcunha} </label> <br> <label><b>Endereco
									Residencial : </b>${sivec.residencial} </label> <br> <label><b>Endereco
									Trabalho : </b>${sivec.trabalho} </label> <br> <label><b>Nome
									Outros : </b>${sivec.nomeOutros} </label> <br> <label><b>RG
									Outros : </b>${sivec.rgOutros} </label> <br> <label><b>Data
									de Nacimento Outros :</b> ${sivec.dtNascimentoOutros} </label> <br> <label><b>Nacionalidade
									Outros : </b>${sivec.nacionalidadeOutros} </label> <br> <label><b>Nome
									do Pai Outros :</b> ${sivec.nomePaiOutros} </label> <br> <label><b>Nome
									do Mae Outros : </b>${sivec.nomeMaeOutros} </label><br>
						</div>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty sivecList}">
							<h2>Sivec :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${sivecList}" var="sivec">
									<br>
									<label><b>Nome :</b> ${sivec.nome} </label>
									<br>
									<label><b>Sexo : </b>${sivec.sexo} </label>
									<br>
									<label><b>RG : </b>${sivec.rg} </label>
									<br>
									<label><b>Tipo de RG :</b> ${sivec.tipoRg} </label>
									<br>
									<label><b>Data de Nascimento : </b>${sivec.dtNascimento}
									</label>
									<br>
									<label><b>Controle : </b>${sivec.controleVec} </label>
									<br>
									<label><b>Emissao do RG : </b>${sivec.emissaoRg} </label>
									<br>
									<label><b>Estado Civil : </b>${sivec.estadoCivil} </label>
									<br>
									<label><b>Naturalizado : </b>${sivec.naturalizado} </label>
									<br>
									<label><b>Naturalidade :</b>${sivec.naturalidade} </label>
									<br>
									<label><b>Grau de Instituicao :</b>
										${sivec.grauInstituicao} </label>
									<br>
									<label><b>Nome do Pai : </b>${sivec.nomePai} </label>
									<br>
									<label><b>Nome da Mae : </b>${sivec.nomeMae} </label>
									<br>
									<label><b>Cor da Pele :</b> ${sivec.corPele} </label>
									<br>
									<label><b>Profissao :</b> ${sivec.profissao} </label>
									<br>
									<label><b>Cabelo : </b>${sivec.cabelo} </label>
									<br>
									<label><b>Cor dos Olhos : </b>${sivec.corOlhos} </label>
									<br>
									<label><b>Formula Fundamental :</b>
										${sivec.formulaFundamental} </label>
									<br>
									<label><b>Posto de Identificacao :</b>
										${sivec.postoIdentificacao} </label>
									<br>
									<label><b>Alcunha :</b> ${sivec.alcunha} </label>
									<br>
									<label><b>Endereco Residencial :</b>
										${sivec.residencial} </label>
									<br>
									<label><b>Endereco Trabalho :</b> ${sivec.trabalho} </label>
									<br>
									<label><b>Nome Outros : </b>${sivec.nomeOutros} </label>
									<br>
									<label><b>RG Outros :</b> ${sivec.rgOutros} </label>
									<br>
									<label><b>Data de Nacimento Outros :</b>
										${sivec.dtNascimentoOutros} </label>
									<br>
									<label><b>Nacionalidade Outros :</b>
										${sivec.nacionalidadeOutros} </label>
									<br>
									<label><b>Nome do Pai Outros : </b>${sivec.nomePaiOutros}
									</label>
									<br>
									<label><b>Nome do Mae Outros :</b>
										${sivec.nomeMaeOutros} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<!-- END SIVEC DATA -->
					
					<!-- BEGIN SIEL DATA -->
					<c:if test="${not empty siel}">
						<h2>Siel :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<label><b>Nome : </b>${siel.nome} </label> <br> <label><b>Titulo
									de Eleitor :</b> ${siel.titulo} </label> <br> <label><b>Data
									de Nascimento : </b>${siel.dtNascimento} </label> <br> <label><b>Zona
									:</b> ${siel.zone} </label> <br> <label><b>Endereco :</b>
								${siel.endereco} </label> <br> <label><b>Municipio :</b>
								${siel.municipio} </label> <br> <label><b>UF : </b>${siel.uf}
							</label> <br> <label>Data Domicilio : ${siel.dtDomicilio} </label> <br>
							<label><b>Nome do Pai :</b> ${siel.nomePai} </label> <br> <label><b>Nome
									da Mae : </b>${siel.nomeMae} </label> <br> <label><b>Naturalidade
									:</b> ${siel.naturalidade} </label> <br> <label><b>Codigo
									Validacao : </b>${siel.cdValidacao} </label><br>
						</div>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty sielList}">
							<h2>Siel :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${sielList}" var="siel">
									<br>
									<label><b>Nome :</b> ${siel.nome} </label>
									<br>
									<label><b>Titulo de Eleitor :</b> ${siel.titulo} </label>
									<br>
									<label><b>Data de Nascimento :</b> ${siel.dtNascimento}
									</label>
									<br>
									<label><b>Zona :</b> ${siel.zone} </label>
									<br>
									<label><b>Endereco : </b>${siel.endereco} </label>
									<br>
									<label><b>Municipio : </b>${siel.municipio} </label>
									<br>
									<label><b>UF :</b> ${siel.uf} </label>
									<br>
									<label><b>Data Domicilio :</b> ${siel.dtDomicilio} </label>
									<br>
									<label><b>Nome do Pai :</b> ${siel.nomePai} </label>
									<br>
									<label><b>Nome da Mae :</b> ${siel.nomeMae} </label>
									<br>
									<label><b>Naturalidade :</b> ${siel.naturalidade} </label>
									<br>
									<label><b>Codigo Validacao : </b>${siel.cdValidacao} </label>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<!-- END SIEL DATA -->
					
					<!-- BEGIN CENSEC DATA -->
					<c:if test="${not empty censec}">
						<h2>Censec :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<label><b>Carga :</b> ${censec.carga} </label> <br> <label><b>Data
									:</b> ${censec.dtMesAno} </label> <br> <label><b>Ato :</b>
								${censec.ato} </label> <br> <label><b>Data do Ato :</b>
								${censec.dtAto} </label> <br> <label><b>Livro :</b>
								${censec.livro} </label> <br> <label><b>Complemento :</b>
								${censec.complemento} </label> <br> <label><b>Folha :</b>
								${censec.folha} </label> <br> <label><b>Nome : </b>${censec.nome}
							</label> <br> <label>CNPJ : ${censec.cpfCnpj} </label> <br> <label><b>Qualidade
									: </b>${censec.qualidade} </label> <br> <label><b>Telefone
									:</b> ${censec.telefone} </label> <br> <label><b>Tipo :</b>
								${censec.tipo} </label> <br> <label><b>Ramal :</b>
								${censec.ramal} </label> <br> <label><b>Contato :</b>
								${censec.contato} </label> <br> <label><b>Status :</b>
								${censec.status} </label> <br> <label><b>UF :</b>
								${censec.uf} </label> <br> <label><b>Municipio :</b>
								${censec.municipio} </label> <br> <label><b>Cartorio :
							</b>${censec.cartorio} </label><br>
						</div>
					</c:if>
					
					<div style="margin-top: 50px">
						<c:if test="${not empty censecList}">
							<h2>Censec :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${censecList}" var="censec">
									<br>
									<label><b>Carga :</b> ${censec.carga} </label>
									<br>
									<label><b>Data : </b>${censec.dtMesAno} </label>
									<br>
									<label><b>Ato :</b> ${censec.ato} </label>
									<br>
									<label><b>Data do Ato : </b>${censec.dtAto} </label>
									<br>
									<label><b>Livro : </b>${censec.livro} </label>
									<br>
									<label><b>Complemento :</b> ${censec.complemento} </label>
									<br>
									<label><b>Folha :</b> ${censec.folha} </label>
									<br>
									<label><b>Nome :</b> ${censec.nome} </label>
									<br>
									<label><b>CNPJ : </b>${censec.cpfCnpj} </label>
									<br>
									<label><b>Qualidade : </b>${censec.qualidade} </label>
									<br>
									<label><b>Telefone :</b> ${censec.telefone} </label>
									<br>
									<label><b>Tipo :</b> ${censec.tipo} </label>
									<br>
									<label><b>Ramal : </b>${censec.ramal} </label>
									<br>
									<label><b>Contato :</b> ${censec.contato} </label>
									<br>
									<label><b>Status : </b>${censec.status} </label>
									<br>
									<label><b>UF : </b>${censec.uf} </label>
									<br>
									<label><b>Municipio :</b> ${censec.municipio} </label>
									<br>
									<label><b>Cartorio : </b>${censec.cartorio} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<!-- END CENSEC DATA -->
					
					<!-- BEGIN CAGED DATA -->
					<c:if test="${not empty caged}">
						<h2>Caged :</h2>
						<hr>
						<div align="left" style="width: 100%; height: 100%">
							<!-- CAGED  -->
							<c:if test="${not empty caged.caged}">
								<h4>Caged</h4>
								<label><b>CPF / CNPJ :</b> ${caged.caged.cnpjCeiCpf} </label>
								<br>
								<label><b>Razao Social :</b>${caged.caged.razaoSocial} </label>
								<br>
								<label><b>Logradouro :</b> ${caged.caged.logradouro} </label>
								<br>
								<label><b>Bairro :</b> ${caged.caged.bairoo} </label>
								<br>
								<label><b>Municipio :</b> ${caged.caged.municipio} </label>
								<br>
								<label><b>UF : </b>${caged.caged.municipio} </label>
								<br>
								<label><b>CEP :</b> ${caged.caged.cep} </label>
								<br>
								<label><b>Nome do Contato : </b>${caged.caged.nome} </label>
								<br>
								<label><b>CPF do Contato : </b>${caged.caged.cpf} </label>
								<br>
								<label><b>Telefone do Contato : </b>${caged.caged.telefone}
								</label>
								<br>
								<label><b>Ramal do Contato:</b> ${caged.caged.ramal} </label>
								<br>
								<label><b>E-mail : </b>${caged.caged.email} </label>
								<br>
							</c:if>
							<!--END CAGED  -->
							<!-- CAGED TRABALHADO -->
							<c:if test="${not empty caged.cagedTrabalhador}">
								<h4>Caged Trabalhador</h4>
								<label><b>Nome :</b> ${caged.cagedTrabalhador.nome} </label>
								<br>
								<label><b>CPF :</b> ${caged.cagedTrabalhador.cpf} </label>
								<br>
								<label><b>PIS :</b> ${caged.cagedTrabalhador.pis} </label>
								<br>
								<label><b>PIS Convertido :</b>
									${caged.cagedTrabalhador.pisConvertido} </label>
								<br>
								<label><b>Nascimento :</b>
									${caged.cagedTrabalhador.dtNascimento} </label>
								<br>
								<label><b>CTPS : </b>${caged.cagedTrabalhador.ctps} </label>
								<br>
								<label><b>UF :</b> ${caged.cagedTrabalhador.uf} </label>
								<br>
								<label><b>CEP :</b> ${caged.cagedTrabalhador.cep} </label>
								<br>
								<label><b>Situacao PIS :</b>
									${caged.cagedTrabalhador.situacaoPis} </label>
								<br>
								<label><b>Sexo : </b>${caged.cagedTrabalhador.sexo} </label>
								<br>
								<label><b>Nacionalidade :</b>
									${caged.cagedTrabalhador.nacionalidade} </label>
								<br>
								<label><b>Raca / Cor :</b>
									${caged.cagedTrabalhador.racaCor} </label>
								<br>
								<label><b>Grau Instituicao :</b>
									${caged.cagedTrabalhador.grauInstituicao} </label>
								<br>
								<label><b>PDC :</b>
									${caged.cagedTrabalhador.possuiDeficiencia} </label>
								<br>
								<label><b>Caged :</b> ${caged.cagedTrabalhador.caged} </label>
								<br>
								<label><b>Rais :</b> ${caged.cagedTrabalhador.rais} </label>
								<br>
								<c:if test="${not empty cagedPDF}">
									<hr>
									<object width="700" height="500" data="${cagedPDF}" width="400"
										height="300"></object>
									<br>
								</c:if>
							</c:if>
							<!--END CAGED TRABALHADO -->
							<!-- CAGED EMPRESA -->
							<c:if test="${not empty caged.cagedEmpresa}">
								<h4>Caged Empresa</h4>
								<label><b>CNPJ :</b> ${caged.cagedEmpresa.cnpj} </label>
								<br>
								<label><b>Razao Social :</b>
									${caged.cagedEmpresa.razaoSocial} </label>
								<br>
								<label><b>Atividade Economica :</b>
									${caged.cagedEmpresa.atividadeEconomica} </label>
								<br>
								<label><b>Filiais : </b>${caged.cagedEmpresa.numeroFiliais}
								</label>
								<br>
								<label><b>Vinculos :</b>
									${caged.cagedEmpresa.totalVinculos} </label>
								<br>
								<label><b>Primeiro Dia :</b>
									${caged.cagedEmpresa.primeiroDia} </label>
								<br>
								<label><b>Admissoes :</b>
									${caged.cagedEmpresa.admissoes} </label>
								<br>
								<label><b>Desligamentos :</b>
									${caged.cagedEmpresa.desligamentos} </label>
								<br>
								<label><b>Ultimo Dia :</b>
									${caged.cagedEmpresa.ultimoDia} </label>
								<br>
								<label><b>Variacao Absoluta :</b>
									${caged.cagedEmpresa.variacaoAbsoluta} </label>
								<br>
							</c:if>
						</div>
					</c:if>

					<div style="margin-top: 50px">
						<c:if test="${not empty cagedList}">
							<h2>Caged :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${cagedList}" var="caged">
									<!-- CAGED  -->
									<c:if test="${not empty caged.caged}">
										<h4>Caged</h4>
										<label><b>CPF / CNPJ :</b> ${caged.caged.cnpjCeiCpf} </label>
										<br>
										<label><b>Razao Social : </b>${caged.caged.razaoSocial}
										</label>
										<br>
										<label><b>Logradouro : </b>${caged.caged.logradouro} </label>
										<br>
										<label><b>Bairro : </b>${caged.caged.bairoo} </label>
										<br>
										<label><b>Municipi : </b>${caged.caged.municipio} </label>
										<br>
										<label><b>UF :</b> ${caged.caged.municipio} </label>
										<br>
										<label><b>CEP :</b> ${caged.caged.cep} </label>
										<br>
										<label><b>Nome do Contato : </b>${caged.caged.nome} </label>
										<br>
										<label><b>CPF do Contato : </b>${caged.caged.cpf} </label>
										<br>
										<label><b>Telefone do Contato : </b>${caged.caged.telefone}
										</label>
										<br>
										<label><b>Ramal do Contato:</b> ${caged.caged.ramal} </label>
										<br>
										<label><b>E-mail :</b> ${caged.caged.email} </label>
										<br>
									</c:if>
									<!--END CAGED  -->
									<!-- CAGED TRABALHADO -->
									<c:if test="${not empty caged.cagedTrabalhador}">
										<h4>Caged Trabalhador</h4>
										<label><b>Nome : </b>${caged.cagedTrabalhador.nome} </label>
										<br>
										<label><b>CPF :</b> ${caged.cagedTrabalhador.cpf} </label>
										<br>
										<label><b>PIS :</b>${caged.cagedTrabalhador.pis} </label>
										<br>
										<label><b>PIS Convertido :</b>
											${caged.cagedTrabalhador.pisConvertido} </label>
										<br>
										<label><b>Nascimento :</b>
											${caged.cagedTrabalhador.dtNascimento} </label>
										<br>
										<label><b>CTPS : </b>${caged.cagedTrabalhador.ctps} </label>
										<br>
										<label><b>UF : </b>${caged.cagedTrabalhador.uf} </label>
										<br>
										<label><b>CEP :</b> ${caged.cagedTrabalhador.cep} </label>
										<br>
										<label><b>Situacao PIS :</b>
											${caged.cagedTrabalhador.situacaoPis} </label>
										<br>
										<label><b>Sexo : </b>${caged.cagedTrabalhador.sexo} </label>
										<br>
										<label><b>Nacionalidade :</b>
											${caged.cagedTrabalhador.nacionalidade} </label>
										<br>
										<label><b>Raca / Cor : </b>${caged.cagedTrabalhador.racaCor}
										</label>
										<br>
										<label><b>Grau Instituicao :</b>
											${caged.cagedTrabalhador.grauInstituicao} </label>
										<br>
										<label><b>PDC :</b>
											${caged.cagedTrabalhador.possuiDeficiencia} </label>
										<br>
										<label><b>Caged :</b> ${caged.cagedTrabalhador.caged}
										</label>
										<br>
										<label><b>Rais :</b> ${caged.cagedTrabalhador.rais} </label>
										<br>
										<c:if test="${not empty cagedPDF}">
											<hr>
											<object width="700" height="500" data="${cagedPDF}"
												width="400" height="300"></object>
											<br>
										</c:if>
									</c:if>
									<!--END CAGED TRABALHADO -->
									<!-- CAGED EMPRESA -->
									<c:if test="${not empty caged.cagedEmpresa}">
										<h4>Caged Empresa</h4>
										<label><b>CNPJ :</b> ${caged.cagedEmpresa.cnpj} </label>
										<br>
										<label><b>Razao Social :</b>
											${caged.cagedEmpresa.razaoSocial} </label>
										<br>
										<label><b>Atividade Economica :</b>
											${caged.cagedEmpresa.atividadeEconomica} </label>
										<br>
										<label><b>Filiais : </b>${caged.cagedEmpresa.numeroFiliais}
										</label>
										<br>
										<label><b>Vinculos :</b>
											${caged.cagedEmpresa.totalVinculos} </label>
										<br>
										<label><b>Primeiro Dia :</b>
											${caged.cagedEmpresa.primeiroDia} </label>
										<br>
										<label><b>Admissoes :</b>
											${caged.cagedEmpresa.admissoes} </label>
										<br>
										<label><b>Desligamentos :</b>
											${caged.cagedEmpresa.desligamentos} </label>
										<br>
										<label><b>Ultimo Dia : </b>${caged.cagedEmpresa.ultimoDia}
										</label>
										<br>
										<label><b>Variacao Absoluta :</b>
											${caged.cagedEmpresa.variacaoAbsoluta} </label>
										<br>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<!-- BEGIN CAGED DATA -->
				</div>
			</div>
			<div class="col-2 button-result-function">
				<div class="block-button">
					<form class="form-button" action="${contextPath}/research">
						<input class="button btn btn-outline-light btn-sm" type="submit"
							value="Nova Pesquisa" />
					</form>
				</div>
				<div class="d-flex align-">
					<form class="form-button">
						<a class="button btn btn-outline-light btn-sm" href="#"
							onClick="HTMLtoPDF()">Download PDF</a>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/js/bootstrap.min.js"></script>

</body>

</html>
