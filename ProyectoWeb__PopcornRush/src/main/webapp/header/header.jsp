<%-- 
    Document   : header
    Created on : 30 nov 2024, 06:01:57
    Author     : PERSONAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>      
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
    </head>
    <body>
        <header class="header">
            <h1 class="logo">
                <span class="colorNaranja">PopCorn</span><span class="colorAzul">Rush</span>
            </h1>
            <nav>
                <ul class="nav-links">
                    <li><a href="${pageContext.request.contextPath}/Home">Home</a></li>
                    <li><a href="noticias.html">Noticias</a></li>
                    <li><a href="generos.html">Géneros</a></li>
                    <li><a href="actores.html">Actores</a></li>
                    <li><a href="trailers.html">Trailers</a></li>
                </ul>
            </nav>

            <!-- Condicional JSTL para verificar si el usuario está logueado -->
            <c:choose>
                <c:when test="${not empty sessionScope.usuario}">
                    <a href="logout.jsp" class="button">Hola, ${sessionScope.usuario.nombreCompleto}</a>
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/jsp/loginJSP.jsp" class="button">Iniciar Sesión</a>
                </c:otherwise>
            </c:choose>
        </header>
    </body>
</html>
