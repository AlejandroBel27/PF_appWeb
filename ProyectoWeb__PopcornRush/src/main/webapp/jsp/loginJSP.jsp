<%-- 
    Document   : loginJSP
    Created on : 29 nov. 2024, 18:36:20
    Author     : galan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/login.css">
    <link rel="stylesheet" href="../styles/header.css">
    <title>Inicia sesión</title>
</head>
<body>
     <%@ include file="../header/header.jsp" %>
    <main>
        <div class="container">
            <div class="login-box">
                <h2>INICIA SESIÓN</h2>
                <form action="${pageContext.request.contextPath}/IniciarSesion" method="POST">
                    <label for="email">Correo:</label>
                    <input type="email" id="email" name="email" required>
                    
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" required>
                    
                    <button type="submit">Inicia Sesión</button>
                </form>
                <p class="register-link">¿No tienes cuenta? <a href="singupJSP.jsp">Regístrate aquí</a></p>
            </div>
    
            <div class="benefits-box">
                <h2>BENEFICIOS DE TU CUENTA</h2>
                <ul>
                    <li>Completamente gratuito.</li>
                    <li>Acceso anticipado a noticias y estrenos.</li>
                    <li>Califica las películas que has visto.</li>
                    <li>Boletines exclusivos.</li>
                    <li>Calendario de estrenos.</li>
                </ul>
                <p>Y más...</p>
            </div>
        </div>
    </main>
    <footer>

    </footer>
</body>
</html>
