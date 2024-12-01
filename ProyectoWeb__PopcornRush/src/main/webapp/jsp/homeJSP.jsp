<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- Importación de JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/header.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/home.css">
    </head>

    <body>

        <%@ include file="../header/header.jsp" %>

        <main class="main-container">
            <!-- Contenido principal -->
            <div class="content">
                <!-- Título principal -->
                <section class="titleMain">
                    <h1>
                        <span class="colorAzul">Las mejores</span><span class="colorNaranja"> publicaciones!</span>
                    </h1>
                </section>

                <!-- Publicaciones ancladas -->
                <section class="pinned-posts-container">
                    <c:choose>
                        <c:when test="${not empty postsAnclados}">
                            <c:forEach var="post" items="${postsAnclados}">
                                <a href="detallePost?id=${post.id}">
                                    <img src="${post.imagen}" alt="${post.titulo}" />
                                </a>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>No hay publicaciones ancladas en este momento.</p>
                        </c:otherwise>
                    </c:choose>
                </section>

                <!-- Separador -->
                <section class="lines">
                    <p>----------------------------------</p>
                </section>

                <!-- Todas las publicaciones -->
                <div class="all-posts-container">
                    <c:choose>
                        <c:when test="${not empty postsComunes}">
                            <c:forEach var="post" items="${postsComunes}">
                                <div class="post">
                                    <img src="${post.imagen}" alt="${post.titulo}" />
                                    <div>
                                        <h2>${post.titulo}</h2>
                                        <h3>Fecha: <fmt:formatDate value="${post.fechaHoraCreacion.time}" pattern="dd/MM/yyyy" /></h3>
                                        <p>${post.contenido}</p>
                                        <a href="${pageContext.request.contextPath}/DetallesPost?id=${post.id}">Leer más...</a>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>No hay publicaciones disponibles en este momento.</p>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

            <!-- Aside (lado derecho) -->
            <aside>
                <c:choose>
                    <c:when test="${not empty sessionScope.usuario}">
                        <a class="crearPost" href="${pageContext.request.contextPath}/jsp/crearPublicacionJSP.jsp">Crear publicación</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/jsp/loginJSP.jsp" class="button">Iniciar Sesión</a>
                    </c:otherwise>
                </c:choose>
            </aside>
        </main>
    </body>

</html>
