<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Mis Publicaciones</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/dashboard.css">
</head>
<body>
    <%@ include file="../header/header.jsp" %>
    <main>
        <h1>Mis Publicaciones</h1>
        <table>
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Fecha</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Mostrar las publicaciones del usuario -->
                <c:forEach var="post" items="${posts}">
                    <tr>
                        <td>${post.titulo}</td>
                        <td><fmt:formatDate value="${post.fechaHoraCreacion.time}" pattern="dd/MM/yyyy" /></td>
                        <td>
                            <!-- Botón para editar -->
                            <a href="${pageContext.request.contextPath}/editarPost?id=${post.id}">Editar</a> |
                            <!-- Botón para eliminar -->
                            <a href="${pageContext.request.contextPath}/eliminarPost?id=${post.id}" onclick="return confirm('¿Seguro que deseas eliminar este post?');">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>

