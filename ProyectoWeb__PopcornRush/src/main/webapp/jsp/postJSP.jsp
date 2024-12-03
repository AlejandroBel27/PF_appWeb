<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${post.titulo}</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/publicaciones.css">
        <script src="${pageContext.request.contextPath}/jss/postJSS.js"></script>
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

            <!-- Sección de comentarios -->
            <section class="comments-area">
                <c:choose>
                    <c:when test="${not empty sessionScope.usuario}">
                        <!-- Caja para dejar un comentario -->
                        <div class="comment-box">
                            <h2>¡Deja tu comentario!</h2>
                            <form id="commentForm">
                                <textarea id="contenido" placeholder="Escribe tu comentario aquí..." rows="5" required></textarea>
                                <input type="hidden" id="postId" value="${post.id}">
                                <button type="button" id="submitComment">Comentar</button>
                            </form>
                        </div>
                        <!-- Sección para mostrar los comentarios -->
                        <div class="comments-section">
                            <h3>Comentarios</h3>
                            <div id="comentarios-container">
                                <!-- Aquí se cargarán los comentarios dinámicamente con JS -->
                                <p>Cargando comentarios...</p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p class="login-prompt">
                            Debes <a href="${pageContext.request.contextPath}/jsp/loginJSP.jsp">Iniciar sesión</a> para dejar un comentario.
                        </p>
                    </c:otherwise>
                </c:choose>
            </section>

        </main>
    </body>
</html>
