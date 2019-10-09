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

		<!-- Heading Row -->
		<div class="row">

			<div class="col-md-12">
				<h1>Resultado</h1>

				<br>
				<c:forEach items="${arpenp}" var="arpenp">
					<h2>${arpenp}</h2>
				</c:forEach>

				<c:forEach items="${cadesp}" var="cadesp">
					<h2>${cadesp}</h2>
				</c:forEach>

				<c:forEach items="${caged}" var="caged">
					<h2>${caged}</h2>
				</c:forEach>

				<c:forEach items="${censec}" var="censec">
					<h2>${censec}</h2>
				</c:forEach>

				<c:forEach items="${jucesp}" var="jucesp">
					<h2>${jucesp}</h2>
				</c:forEach>

				<c:forEach items="${siel}" var="siel">
					<h2>${siel}</h2>
				</c:forEach>

				<c:forEach items="${sivec}" var="sivec">
					<h2>${sivec}</h2>
				</c:forEach>
			</div>

			<!-- Embed PDF File -->
			<a href="${contextPath}/research">Voltar</a>
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
