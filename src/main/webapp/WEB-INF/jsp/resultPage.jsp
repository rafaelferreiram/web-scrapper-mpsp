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
<link href="/css/small-business.css" rel="stylesheet">
</head>

<body>

	<!-- Page Content -->
	<div class="container">
		<div>
			<form class="input-field fifth-wrap inner-form"
				action="${contextPath}/logout">
				<input
					style="position: absolute; right: 0; margin: 3%; top: 0; border-radius: 20px; cursor: pointer;"
					type="submit" value="Logout" />
			</form>
		</div>
		<!-- Heading Row -->
		<div class="row">

			<div class="col-md-12">
				<h1>Resultado da Pesquisa</h1>
				<br> <br>
				<c:if test="${not empty msg}">
					<div class="alert alert-warning" role="alert">
						<h4>${msg}</h4>
					</div>
				</c:if>
				<c:if test="${not empty arpenp }">
					<h2>Arpenp</h2>
					<hr>
					<div align="left" style="width: 100%; height: 100%">
						<c:forEach items="${arpenp}" var="arpenp">
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
							<label>Novo nome Conjuge 2 : ${arpenp.conjuge2NovoNome} </label>
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
						</c:forEach>
					</div>
				</c:if>

				<!-- PDF's -->
				<c:if test="${not empty arisp}">
					<h2>Arisp :</h2>
					<object width="700" height="500" data="${arisp}" width="400"
						height="300"></object>
				</c:if>
				<c:if test="${not empty detran}">
					<h2>Detran :</h2>
					<object width="700" height="500" data="${detran}" width="400"
						height="300"></object>
				</c:if>
				<c:if test="${not empty infocrim}">
					<h2>Infocrim :</h2>
					<object width="700" height="500" data="${infocrim}" width="400"
						height="300"></object>
				</c:if>
				<!-- END PDF's -->
				
				<c:if test="${not empty cadesp}">
					<h2>Cadesp :</h2>
					<c:forEach items="${cadesp}" var="cadesp">
						<div align="left" style="width: 100%; height: 100%">
							<c:forEach items="${cadesp}" var="cadesp">
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
							</c:forEach>
						</div>
					</c:forEach>
				</c:if>

				<c:if test="${not empty caged}">
					<h2>Caged :</h2>
					<div align="left" style="width: 100%; height: 100%">
						<!-- CAGED  -->
						<c:forEach items="${caged}" var="caged">
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
								<label>PDC : ${caged.cagedTrabalhador.possuiDeficiencia}
								</label>
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
						</c:forEach>
					</div>
				</c:if>

				<c:if test="${not empty censecList}">
					<h2>Censec :</h2>
					<div align="center" style="width: 100%; height: 100%">
						<div align="left" style="width: 40%; height: 10%">
							<h2>${censecList}</h2>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty censec}">
					<h2>Censec :</h2>
					<div align="center" style="width: 100%; height: 100%">
						<div align="left" style="width: 40%; height: 10%">
							<h2>${censec.carga}</h2>
						</div>
					</div>
				</c:if>


				<c:if test="${not empty jucesp}">
					<h2>Jucesp :</h2>
				</c:if>
				<c:forEach items="${jucesp}" var="jucesp">
					<h4>${jucesp}</h4>
				</c:forEach>

				<c:if test="${not empty siel}">
					<h2>Siel :</h2>
				</c:if>
				<c:forEach items="${siel}" var="siel">
					<h2>${siel}</h2>
				</c:forEach>
				<c:if test="${not empty sivec}">
					<h2>Sivec :</h2>
				</c:if>
				<c:forEach items="${sivec}" var="sivec">
					<h2>${sivec}</h2>
				</c:forEach>
			</div>
			<div>
				<form class="input-field fifth-wrap inner-form"
					action="${contextPath}/research">
					<input
						style="position: absolute; right: 0; margin: 3%; top: 50; border-radius: 20px; cursor: pointer; color: white; background-color: blue"
						type="submit" value="Nova Pesquisa" />
				</form>
			</div>
			<!-- /.col-md-4 -->
		</div>
		<!-- /.row -->

	</div>

	<!-- jQuery -->
	<script src="/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/js/bootstrap.min.js"></script>

</body>

</html>
