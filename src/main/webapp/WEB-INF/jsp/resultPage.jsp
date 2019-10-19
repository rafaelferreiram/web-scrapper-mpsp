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
					<div>
						<br> <br>
						<c:if test="${not empty arpenp }">
							<h2>Arpenp</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<!-- ARPENP  -->
								<label>Cartorio : ${arpenp.cartorio} </label> <br> <label>CNS
									: ${arpenp.cns} </label> <br> <label>UF : ${arpenp.uf} </label> <br>
								<label>Nome Conjuge : ${arpenp.conjuge} </label> <br> <label>Novo
									nome Conjuge : ${arpenp.conjugeNovoNome} </label> <br> <label>Nome
									Conjuge 2 : ${arpenp.conjuge2} </label> <br> <label>Novo
									nome Conjuge 2 : ${arpenp.conjuge2NovoNome} </label> <br> <label>Data
									Casamento : ${arpenp.dtCasamento} </label> <br> <label>Matricula
									: ${arpenp.matricula} </label> <br> <label>Data da Entrada
									: ${arpenp.dtEntrada} </label> <br> <label>Data do
									Registro : ${arpenp.dtRegistro} </label> <br> <label>Acervo
									: ${arpenp.acervo} </label> <br> <label>Numero do Livro :
									${arpenp.numeroLivro} </label> <br> <label>Numero da Folha
									: ${arpenp.numeroFolha} </label> <br> <label>Numero do
									Registro : ${arpenp.numeroRegistro} </label> <br> <label>Tipo
									da Folha : ${arpenp.tipoLivro} </label> <br>
								<!-- END ARPENP  -->
							</div>
						</c:if>
						<c:if test="${not empty arpenpList }">
							<h2>Arpenp</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${arpenpList}" var="arpenp">
									<!-- ARPENP  -->
									<label>Cartorio : ${arpenp.cartorio} </label>
									<br>
									<label>CNS : ${arpenp.cns} </label>
									<br>
									<label>UF : ${arpenp.uf} </label>
									<br>
									<label>Nome Conjuge : ${arpenp.conjuge} </label>
									<br>
									<label>Novo nome Conjuge : ${arpenp.conjugeNovoNome} </label>
									<br>
									<label>Nome Conjuge 2 : ${arpenp.conjuge2} </label>
									<br>
									<label>Novo nome Conjuge 2 : ${arpenp.conjuge2NovoNome}
									</label>
									<br>
									<label>Data Casamento : ${arpenp.dtCasamento} </label>
									<br>
									<label>Matricula : ${arpenp.matricula} </label>
									<br>
									<label>Data da Entrada : ${arpenp.dtEntrada} </label>
									<br>
									<label>Data do Registro : ${arpenp.dtRegistro} </label>
									<br>
									<label>Acervo : ${arpenp.acervo} </label>
									<br>
									<label>Numero do Livro : ${arpenp.numeroLivro} </label>
									<br>
									<label>Numero da Folha : ${arpenp.numeroFolha} </label>
									<br>
									<label>Numero do Registro : ${arpenp.numeroRegistro} </label>
									<br>
									<label>Tipo da Folha : ${arpenp.tipoLivro} </label>
									<br>
									<!-- END ARPENP  -->
								</c:forEach>
							</div>
						</c:if>

						<c:if test="${not empty jucespPDF}">
							<h2>Jucesp :</h2>
							<hr>
							<object width="700" height="500" data="${jucespPDF}" width="400"
								height="300"></object>
							<br>
						</c:if>

						<c:if test="${not empty cagedPDF}">
							<h2>Caged Trabalhador :</h2>
							<hr>
							<object width="700" height="500" data="${cagedPDF}" width="400"
								height="300"></object>
							<br>
						</c:if>

						<!-- PDF's -->
						<c:if test="${not empty arisp}">
							<h2>Arisp :</h2>
							<hr>
							<object width="700" height="500" data="${arisp}" width="400"
								height="300"></object>
							<br>
						</c:if>
						<c:if test="${not empty detran}">
							<h2>Detran :</h2>
							<hr>
							<object width="700" height="500" data="${detran}" width="400"
								height="300"></object>
							<br>
						</c:if>
						<c:if test="${not empty infocrim}">
							<h2>Infocrim :</h2>
							<hr>
							<object width="700" height="500" data="${infocrim}" width="400"
								height="300"></object>
							<br>
						</c:if>
						<!-- END PDF's -->

						<c:if test="${not empty cadesp}">
							<h2>Cadesp :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<!-- CADESP  -->
								<label>IE : ${cadesp.ie} </label> <br> <label>CNPJ
									: ${cadesp.cnpj} </label> <br> <label>Situacao :
									${cadesp.situacao} </label> <br> <label>Data Inscricao
									Estado : ${cadesp.dtInscricaoEstado} </label> <br> <label>Nome
									Empresarial : ${cadesp.nomeEmpresarial} </label> <br> <label>Regime
									Estadual: ${cadesp.regimeEstadual} </label> <br> <label>DRT
									: ${cadesp.drt} </label> <br> <label>Posto Fiscal :
									${cadesp.postoFiscal} </label> <br> <label>Data Inicio IE
									: ${cadesp.dtInicioIE} </label> <br> <label>NIRE :
									${cadesp.nire} </label> <br> <label>Ocorrencia Fiscal :
									${cadesp.ocorrenciaFiscal} </label> <br> <label>Tipo de
									Unidade : ${cadesp.tipoUnidade} </label> <br> <label>Forma
									de Atuacao : ${cadesp.formaAtuacao} </label> <br>
								<!-- END CADESP  -->
							</div>
						</c:if>
						<c:if test="${not empty cadespList}">
							<h2>Cadesp :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${cadespList}" var="cadesp">
									<!-- CADESP  -->
									<label>IE : ${cadesp.ie} </label>
									<br>
									<label>CNPJ : ${cadesp.cnpj} </label>
									<br>
									<label>Situacao : ${cadesp.situacao} </label>
									<br>
									<label>Data Inscricao Estado :
										${cadesp.dtInscricaoEstado} </label>
									<br>
									<label>Nome Empresarial : ${cadesp.nomeEmpresarial} </label>
									<br>
									<label>Regime Estadual: ${cadesp.regimeEstadual} </label>
									<br>
									<label>DRT : ${cadesp.drt} </label>
									<br>
									<label>Posto Fiscal : ${cadesp.postoFiscal} </label>
									<br>
									<label>Data Inicio IE : ${cadesp.dtInicioIE} </label>
									<br>
									<label>NIRE : ${cadesp.nire} </label>
									<br>
									<label>Ocorrencia Fiscal : ${cadesp.ocorrenciaFiscal} </label>
									<br>
									<label>Tipo de Unidade : ${cadesp.tipoUnidade} </label>
									<br>
									<label>Forma de Atuacao : ${cadesp.formaAtuacao} </label>
									<br>
									<!-- END CADESP  -->
								</c:forEach>
							</div>
						</c:if>

						<c:if test="${not empty caged}">
							<h2>Caged :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<!-- CAGED  -->
								<c:if test="${not empty caged.caged}">
									<h4>Caged</h4>
									<label>CPF / CNPJ : ${caged.caged.cnpjCeiCpf} </label>
									<br>
									<label>Razao Social : ${caged.caged.razaoSocial} </label>
									<br>
									<label>Logradouro : ${caged.caged.logradouro} </label>
									<br>
									<label>Bairro : ${caged.caged.bairoo} </label>
									<br>
									<label>Municipi : ${caged.caged.municipio} </label>
									<br>
									<label>UF : ${caged.caged.municipio} </label>
									<br>
									<label>CEP : ${caged.caged.cep} </label>
									<br>
									<label>Nome do Contato : ${caged.caged.nome} </label>
									<br>
									<label>CPF do Contato : ${caged.caged.cpf} </label>
									<br>
									<label>Telefone do Contato : ${caged.caged.telefone} </label>
									<br>
									<label>Ramal do Contato: ${caged.caged.ramal} </label>
									<br>
									<label>E-mail : ${caged.caged.email} </label>
									<br>
								</c:if>
								<!--END CAGED  -->
								<!-- CAGED TRABALHADO -->
								<c:if test="${not empty caged.cagedTrabalhador}">
									<h4>Caged Trabalhador</h4>
									<label>Nome : ${caged.cagedTrabalhador.nome} </label>
									<br>
									<label>CPF : ${caged.cagedTrabalhador.cpf} </label>
									<br>
									<label>PIS : ${caged.cagedTrabalhador.pis} </label>
									<br>
									<label>PIS Convertido :
										${caged.cagedTrabalhador.pisConvertido} </label>
									<br>
									<label>Nascimento :
										${caged.cagedTrabalhador.dtNascimento} </label>
									<br>
									<label>CTPS : ${caged.cagedTrabalhador.ctps} </label>
									<br>
									<label>UF : ${caged.cagedTrabalhador.uf} </label>
									<br>
									<label>CEP : ${caged.cagedTrabalhador.cep} </label>
									<br>
									<label>Situacao PIS :
										${caged.cagedTrabalhador.situacaoPis} </label>
									<br>
									<label>Sexo : ${caged.cagedTrabalhador.sexo} </label>
									<br>
									<label>Nacionalidade :
										${caged.cagedTrabalhador.nacionalidade} </label>
									<br>
									<label>Raca / Cor : ${caged.cagedTrabalhador.racaCor} </label>
									<br>
									<label>Grau Instituicao :
										${caged.cagedTrabalhador.grauInstituicao} </label>
									<br>
									<label>PDC :
										${caged.cagedTrabalhador.possuiDeficiencia} </label>
									<br>
									<label>Caged : ${caged.cagedTrabalhador.caged} </label>
									<br>
									<label>Rais : ${caged.cagedTrabalhador.rais} </label>
									<br>
								</c:if>
								<!--END CAGED TRABALHADO -->
								<!-- CAGED EMPRESA -->
								<c:if test="${not empty caged.cagedEmpresa}">
									<h4>Caged Empresa</h4>
									<label>CNPJ : ${caged.cagedEmpresa.cnpj} </label>
									<br>
									<label>Razao Social : ${caged.cagedEmpresa.razaoSocial}
									</label>
									<br>
									<label>Atividade Economica :
										${caged.cagedEmpresa.atividadeEconomica} </label>
									<br>
									<label>Filiais : ${caged.cagedEmpresa.numeroFiliais} </label>
									<br>
									<label>Vinculos : ${caged.cagedEmpresa.totalVinculos} </label>
									<br>
									<label>Primeiro Dia : ${caged.cagedEmpresa.primeiroDia}
									</label>
									<br>
									<label>Admissoes : ${caged.cagedEmpresa.admissoes} </label>
									<br>
									<label>Desligamentos :
										${caged.cagedEmpresa.desligamentos} </label>
									<br>
									<label>Ultimo Dia : ${caged.cagedEmpresa.ultimoDia} </label>
									<br>
									<label>Variacao Absoluta :
										${caged.cagedEmpresa.variacaoAbsoluta} </label>
									<br>
								</c:if>
							</div>
						</c:if>
						<c:if test="${not empty cagedList}">
							<h2>Caged :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${cagedList}" var="caged">
									<!-- CAGED  -->
									<c:if test="${not empty caged.caged}">
										<h4>Caged</h4>
										<label>CPF / CNPJ : ${caged.caged.cnpjCeiCpf} </label>
										<br>
										<label>Razao Social : ${caged.caged.razaoSocial} </label>
										<br>
										<label>Logradouro : ${caged.caged.logradouro} </label>
										<br>
										<label>Bairro : ${caged.caged.bairoo} </label>
										<br>
										<label>Municipi : ${caged.caged.municipio} </label>
										<br>
										<label>UF : ${caged.caged.municipio} </label>
										<br>
										<label>CEP : ${caged.caged.cep} </label>
										<br>
										<label>Nome do Contato : ${caged.caged.nome} </label>
										<br>
										<label>CPF do Contato : ${caged.caged.cpf} </label>
										<br>
										<label>Telefone do Contato : ${caged.caged.telefone} </label>
										<br>
										<label>Ramal do Contato: ${caged.caged.ramal} </label>
										<br>
										<label>E-mail : ${caged.caged.email} </label>
										<br>
									</c:if>
									<!--END CAGED  -->
									<!-- CAGED TRABALHADO -->
									<c:if test="${not empty caged.cagedTrabalhador}">
										<h4>Caged Trabalhador</h4>
										<label>Nome : ${caged.cagedTrabalhador.nome} </label>
										<br>
										<label>CPF : ${caged.cagedTrabalhador.cpf} </label>
										<br>
										<label>PIS : ${caged.cagedTrabalhador.pis} </label>
										<br>
										<label>PIS Convertido :
											${caged.cagedTrabalhador.pisConvertido} </label>
										<br>
										<label>Nascimento :
											${caged.cagedTrabalhador.dtNascimento} </label>
										<br>
										<label>CTPS : ${caged.cagedTrabalhador.ctps} </label>
										<br>
										<label>UF : ${caged.cagedTrabalhador.uf} </label>
										<br>
										<label>CEP : ${caged.cagedTrabalhador.cep} </label>
										<br>
										<label>Situacao PIS :
											${caged.cagedTrabalhador.situacaoPis} </label>
										<br>
										<label>Sexo : ${caged.cagedTrabalhador.sexo} </label>
										<br>
										<label>Nacionalidade :
											${caged.cagedTrabalhador.nacionalidade} </label>
										<br>
										<label>Raca / Cor : ${caged.cagedTrabalhador.racaCor}
										</label>
										<br>
										<label>Grau Instituicao :
											${caged.cagedTrabalhador.grauInstituicao} </label>
										<br>
										<label>PDC :
											${caged.cagedTrabalhador.possuiDeficiencia} </label>
										<br>
										<label>Caged : ${caged.cagedTrabalhador.caged} </label>
										<br>
										<label>Rais : ${caged.cagedTrabalhador.rais} </label>
										<br>
									</c:if>
									<!--END CAGED TRABALHADO -->
									<!-- CAGED EMPRESA -->
									<c:if test="${not empty caged.cagedEmpresa}">
										<h4>Caged Empresa</h4>
										<label>CNPJ : ${caged.cagedEmpresa.cnpj} </label>
										<br>
										<label>Razao Social :
											${caged.cagedEmpresa.razaoSocial} </label>
										<br>
										<label>Atividade Economica :
											${caged.cagedEmpresa.atividadeEconomica} </label>
										<br>
										<label>Filiais : ${caged.cagedEmpresa.numeroFiliais} </label>
										<br>
										<label>Vinculos : ${caged.cagedEmpresa.totalVinculos}
										</label>
										<br>
										<label>Primeiro Dia :
											${caged.cagedEmpresa.primeiroDia} </label>
										<br>
										<label>Admissoes : ${caged.cagedEmpresa.admissoes} </label>
										<br>
										<label>Desligamentos :
											${caged.cagedEmpresa.desligamentos} </label>
										<br>
										<label>Ultimo Dia : ${caged.cagedEmpresa.ultimoDia} </label>
										<br>
										<label>Variacao Absoluta :
											${caged.cagedEmpresa.variacaoAbsoluta} </label>
										<br>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
						
						<c:if test="${not empty censec}">
							<h2>Censec :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<label>Carga : ${censec.carga} </label> <br> <label>Data
									: ${censec.dtMesAno} </label> <br> <label>Ato :
									${censec.ato} </label> <br> <label>Data do Ato :
									${censec.dtAto} </label> <br> <label>Livro :
									${censec.livro} </label> <br> <label>Complemento :
									${censec.complemento} </label> <br> <label>Folha :
									${censec.folha} </label> <br> <label>Nome : ${censec.nome}
								</label> <br> <label>CNPJ : ${censec.cpfCnpj} </label> <br> <label>Qualidade
									: ${censec.qualidade} </label> <br> <label>Telefone :
									${censec.telefone} </label> <br> <label>Tipo :
									${censec.tipo} </label> <br> <label>Ramal :
									${censec.ramal} </label> <br> <label>Contato :
									${censec.contato} </label> <br> <label>Status :
									${censec.status} </label> <br> <label>UF : ${censec.uf} </label> <br>
								<label>Municipio : ${censec.municipio} </label> <br> <label>Cartorio
									: ${censec.cartorio} </label><br>
							</div>
						</c:if>

						<c:if test="${not empty censecList}">
							<h2>Censec :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${censecList}" var="censec">
									<label>Carga : ${censec.carga} </label>
									<br>
									<label>Data : ${censec.dtMesAno} </label>
									<br>
									<label>Ato : ${censec.ato} </label>
									<br>
									<label>Data do Ato : ${censec.dtAto} </label>
									<br>
									<label>Livro : ${censec.livro} </label>
									<br>
									<label>Complemento : ${censec.complemento} </label>
									<br>
									<label>Folha : ${censec.folha} </label>
									<br>
									<label>Nome : ${censec.nome} </label>
									<br>
									<label>CNPJ : ${censec.cpfCnpj} </label>
									<br>
									<label>Qualidade : ${censec.qualidade} </label>
									<br>
									<label>Telefone : ${censec.telefone} </label>
									<br>
									<label>Tipo : ${censec.tipo} </label>
									<br>
									<label>Ramal : ${censec.ramal} </label>
									<br>
									<label>Contato : ${censec.contato} </label>
									<br>
									<label>Status : ${censec.status} </label>
									<br>
									<label>UF : ${censec.uf} </label>
									<br>
									<label>Municipio : ${censec.municipio} </label>
									<br>
									<label>Cartorio : ${censec.cartorio} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>

						
						<c:if test="${not empty jucesp}">
							<h2>Jucesp :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<label>Nire Matriz : ${jucesp.nire} </label> <br> <label>Tipo
									de Empresa : ${jucesp.tipoEmpresa} </label> <br> <label>Data
									da constituição : ${jucesp.dtConst} </label> <br> <label>Inicio
									da Atividade : ${jucesp.inicioAtividade} </label> <br> <label>CNPJ
									: ${jucesp.cnpj} </label> <br> <label>Inscricao Estadual :
									${jucesp.incricaoEstadual} </label> <br> <label>Objeto
									Descricao : ${jucesp.objetoDescricao} </label> <br> <label>Capital
									: ${jucesp.capital} </label> <br> <label>Logradouro :
									${jucesp.logradouro} </label> <br> <label>Numero :
									${jucesp.numero} </label> <br> <label>Bairro :
									${jucesp.bairro} </label> <br> <label>Complemento :
									${jucesp.complemento} </label> <br> <label>Municipio :
									${jucesp.municipio} </label> <br> <label>CEP :
									${jucesp.cep} </label> <br> <label>UF : ${jucesp.uf} </label><br>
							</div>
						</c:if>

						<c:if test="${not empty jucespList}">
							<h2>Jucesp :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${jucespList}" var="jucesp">
									<label>Nire Matriz : ${jucesp.nire} </label>
									<br>
									<label>Tipo de Empresa : ${jucesp.tipoEmpresa} </label>
									<br>
									<label>Data da constituição : ${jucesp.dtConst} </label>
									<br>
									<label>Inicio da Atividade : ${jucesp.inicioAtividade}
									</label>
									<br>
									<label>CNPJ : ${jucesp.cnpj} </label>
									<br>
									<label>Inscricao Estadual : ${jucesp.incricaoEstadual}
									</label>
									<br>
									<label>Objeto Descricao : ${jucesp.objetoDescricao} </label>
									<br>
									<label>Capital : ${jucesp.capital} </label>
									<br>
									<label>Logradouro : ${jucesp.logradouro} </label>
									<br>
									<label>Numero : ${jucesp.numero} </label>
									<br>
									<label>Bairro : ${jucesp.bairro} </label>
									<br>
									<label>Complemento : ${jucesp.complemento} </label>
									<br>
									<label>Municipio : ${jucesp.municipio} </label>
									<br>
									<label>CEP : ${jucesp.cep} </label>
									<br>
									<label>UF : ${jucesp.uf} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>

						<c:if test="${not empty siel}">
							<h2>Siel :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<label>Nome : ${siel.nome} </label> <br> <label>Titulo
									de Eleitor : ${siel.titulo} </label> <br> <label>Data de
									Nascimento : ${siel.dtNascimento} </label> <br> <label>Zona
									: ${siel.zone} </label> <br> <label>Endereco :
									${siel.endereco} </label> <br> <label>Municipio :
									${siel.municipio} </label> <br> <label>UF : ${siel.uf} </label> <br>
								<label>Data Domicilio : ${siel.dtDomicilio} </label> <br> <label>Nome
									do Pai : ${siel.nomePai} </label> <br> <label>Nome da Mae
									: ${siel.nomeMae} </label> <br> <label>Naturalidade :
									${siel.naturalidade} </label> <br> <label>Codigo Validacao
									: ${siel.cdValidacao} </label><br>
							</div>
						</c:if>

						<c:if test="${not empty sielList}">
							<h2>Siel :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${sielList}" var="siel">
									<label>Nome : ${siel.nome} </label>
									<br>
									<label>Titulo de Eleitor : ${siel.titulo} </label>
									<br>
									<label>Data de Nascimento : ${siel.dtNascimento} </label>
									<br>
									<label>Zona : ${siel.zone} </label>
									<br>
									<label>Endereco : ${siel.endereco} </label>
									<br>
									<label>Municipio : ${siel.municipio} </label>
									<br>
									<label>UF : ${siel.uf} </label>
									<br>
									<label>Data Domicilio : ${siel.dtDomicilio} </label>
									<br>
									<label>Nome do Pai : ${siel.nomePai} </label>
									<br>
									<label>Nome da Mae : ${siel.nomeMae} </label>
									<br>
									<label>Naturalidade : ${siel.naturalidade} </label>
									<br>
									<label>Codigo Validacao : ${siel.cdValidacao} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>

						<c:if test="${not empty sivec}">
							<h2>Sivec :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<label>Nome : ${sivec.nome} </label> <br> <label>Sexo
									: ${sivec.sexo} </label> <br> <label>RG : ${sivec.rg} </label> <br>
								<label>Tipo de RG : ${sivec.tipoRg} </label> <br> <label>Data
									de Nascimento : ${sivec.dtNascimento} </label> <br> <label>Controle
									: ${sivec.controleVec} </label> <br> <label>Emissao do RG
									: ${sivec.emissaoRg} </label> <br> <label>Estado Civil :
									${sivec.estadoCivil} </label> <br> <label>Naturalizado :
									${sivec.naturalizado} </label> <br> <label>Naturalidade :
									${sivec.naturalidade} </label> <br> <label>Grau de
									Instituicao : ${sivec.grauInstituicao} </label> <br> <label>Nome
									do Pai : ${sivec.nomePai} </label> <br> <label>Nome da Mae
									: ${sivec.nomeMae} </label> <br> <label>Cor da Pele :
									${sivec.corPele} </label> <br> <label>Profissao :
									${sivec.profissao} </label> <br> <label>Cabelo :
									${sivec.cabelo} </label> <br> <label>Cor dos Olhos :
									${sivec.corOlhos} </label> <br> <label>Formula Fundamental
									: ${sivec.formulaFundamental} </label> <br> <label>Posto
									de Identificacao : ${sivec.postoIdentificacao} </label> <br> <label>Alcunha
									: ${sivec.alcunha} </label> <br> <label>Endereco
									Residencial : ${sivec.residencial} </label> <br> <label>Endereco
									Trabalho : ${sivec.trabalho} </label> <br> <label>Nome
									Outros : ${sivec.nomeOutros} </label> <br> <label>RG
									Outros : ${sivec.rgOutros} </label> <br> <label>Data de
									Nacimento Outros : ${sivec.dtNascimentoOutros} </label> <br> <label>Nacionalidade
									Outros : ${sivec.nacionalidadeOutros} </label> <br> <label>Nome
									do Pai Outros : ${sivec.nomePaiOutros} </label> <br> <label>Nome
									do Mae Outros : ${sivec.nomeMaeOutros} </label><br>
							</div>
						</c:if>

						<c:if test="${not empty sivecList}">
							<h2>Sivec :</h2>
							<hr>
							<div align="left" style="width: 100%; height: 100%">
								<c:forEach items="${sivecList}" var="sivec">
									<label>Nome : ${sivec.nome} </label>
									<br>
									<label>Sexo : ${sivec.sexo} </label>
									<br>
									<label>RG : ${sivec.rg} </label>
									<br>
									<label>Tipo de RG : ${sivec.tipoRg} </label>
									<br>
									<label>Data de Nascimento : ${sivec.dtNascimento} </label>
									<br>
									<label>Controle : ${sivec.controleVec} </label>
									<br>
									<label>Emissao do RG : ${sivec.emissaoRg} </label>
									<br>
									<label>Estado Civil : ${sivec.estadoCivil} </label>
									<br>
									<label>Naturalizado : ${sivec.naturalizado} </label>
									<br>
									<label>Naturalidade : ${sivec.naturalidade} </label>
									<br>
									<label>Grau de Instituicao : ${sivec.grauInstituicao} </label>
									<br>
									<label>Nome do Pai : ${sivec.nomePai} </label>
									<br>
									<label>Nome da Mae : ${sivec.nomeMae} </label>
									<br>
									<label>Cor da Pele : ${sivec.corPele} </label>
									<br>
									<label>Profissao : ${sivec.profissao} </label>
									<br>
									<label>Cabelo : ${sivec.cabelo} </label>
									<br>
									<label>Cor dos Olhos : ${sivec.corOlhos} </label>
									<br>
									<label>Formula Fundamental :
										${sivec.formulaFundamental} </label>
									<br>
									<label>Posto de Identificacao :
										${sivec.postoIdentificacao} </label>
									<br>
									<label>Alcunha : ${sivec.alcunha} </label>
									<br>
									<label>Endereco Residencial : ${sivec.residencial} </label>
									<br>
									<label>Endereco Trabalho : ${sivec.trabalho} </label>
									<br>
									<label>Nome Outros : ${sivec.nomeOutros} </label>
									<br>
									<label>RG Outros : ${sivec.rgOutros} </label>
									<br>
									<label>Data de Nacimento Outros :
										${sivec.dtNascimentoOutros} </label>
									<br>
									<label>Nacionalidade Outros :
										${sivec.nacionalidadeOutros} </label>
									<br>
									<label>Nome do Pai Outros : ${sivec.nomePaiOutros} </label>
									<br>
									<label>Nome do Mae Outros : ${sivec.nomeMaeOutros} </label>
									<br>
								</c:forEach>
							</div>
						</c:if>

					</div>
					<!-- /.col-md-4 -->
				</div>
				<!-- /.row -->
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
