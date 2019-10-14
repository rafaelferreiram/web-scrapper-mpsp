<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
				<h1>Resultado</h1>
				<br> <br>
				<hr></hr>
				<br> <br>
				<c:forEach items="${arpenp}" var="arpenp">
					<h2>${arpenp}</h2>
				</c:forEach>
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
				<c:if test="${not empty cadesp}">
					<h2>Cadesp :</h2>
				</c:if>
				<c:forEach items="${cadesp}" var="cadesp">
					<h2>${cadesp}</h2>
				</c:forEach>

				<c:if test="${not empty caged}">
					<h2>Caged :</h2>
				</c:if>
				<c:forEach items="${caged}" var="caged">
					<h2>${caged}</h2>
				</c:forEach>
				<c:if test="${not empty censec}">
					<h2>Censec :</h2>
				</c:if>
				<c:forEach items="${censec}" var="censec">
					<h2>${censec}</h2>
				</c:forEach>
				<c:if test="${not empty jucesp}">
					<h2>Jucesp :</h2>
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
			<hr></hr>
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

		<hr>

	</div>

	<!-- jQuery -->
	<script src="/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/js/bootstrap.min.js"></script>

</body>

</html>
