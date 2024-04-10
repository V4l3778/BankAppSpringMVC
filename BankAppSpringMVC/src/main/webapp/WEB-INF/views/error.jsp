<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<%@ include file="/CDN.html"%>
<link href="<c:url value="resources/style.css"/>" rel="stylesheet">
</head>
<body>
	<%@ include file="/nav.html"%>
	<div class="container">
			
		<div style="margin-top:50px;"></div>

		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
			 	<li class="breadcrumb-item">
			 	<a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page"> Pagina di errore</li>
			</ol>
		</nav>
		<div class="pb-2 mt-4 mb-2">
			<h3>Compilazione non riuscita</h3>
		</div>
		<div class="card">
			<div class="card-header text-white bg-danger mb-3">
				<h3>Errore nella compilazione della pagina</h3>	
			</div>
			<div class="card-body">
				<h5 class="card-title">
					Gestore interno eccezioni di Spring
				</h5>
				<p class="card-text">
					Exception: ${exception.message}
				</p>	
				
				<c:forEach var="stack" items="${exception.stackTrace}">
					${stack}
				</c:forEach>
			<p style="margin-top: 20px;">
				<input type="button" class="btn btn-primary" value="indietro"
				onclick="window.history.back()">
			</p>
			</div>
		</div>
	</div>
<footer class="footer"><%@ include file="/footer.html"%></footer>
</body>
</html>