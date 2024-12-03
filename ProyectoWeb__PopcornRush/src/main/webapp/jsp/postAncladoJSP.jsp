<%-- 
    Document   : postAncladoJSP.jsp
    Created on : 3 dic 2024, 15:46:10
    Author     : PERSONAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${post.titulo}</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/publicaciones.css">
    </head>
    <body>
        <%@ include file="../header/header.jsp" %>

        <main>
            <!-- Sección de detalles del post -->
            <section class="mov-details">
                <div class="mov-img">
                    <img src="${post.imagen}" alt="${post.titulo}">
                </div>
                <div class="mov-info">
                    <h1>${post.titulo}</h1>
                    <p>${post.contenido}</p>
                    <div class="additional-info">
                        <h3>Información adicional</h3>
                        <p><strong>Género:</strong> ${post.genero}</p>
                        <p><strong>Fecha de creación:</strong> 
                            <fmt:formatDate value="${post.fechaHoraCreacion.time}" pattern="dd/MM/yyyy" />
                        </p>
                        <p><strong>Calificación:</strong> 
                            <c:choose>
                                <c:when test="${post.calificacion != null}">${post.calificacion}</c:when>
                                <c:otherwise>No disponible</c:otherwise>
                            </c:choose>
                        </p>
                    </div>
                </div>
            </section>

            <!-- Sección de calificación -->
            <section class="rating">
                <h2>Calificación:</h2>
                <div class="stars">
                    <c:forEach var="i" begin="1" end="5">
                        <span class="${i <= post.calificacion ? 'filled' : 'empty'}">★</span>
                    </c:forEach>
                </div>
                <p>
                    <c:choose>
                        <c:when test="${post.calificacion >= 4}">¡Excelente!</c:when>
                        <c:when test="${post.calificacion == 3}">Bueno</c:when>
                        <c:otherwise>Podría mejorar</c:otherwise>
                    </c:choose>
                </p>
            </section>
            <p>Este post está anclado. Los comentarios están deshabilitados.</p>
        </main>
    </body>
</html>
