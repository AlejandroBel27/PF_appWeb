<%-- 
    Document   : singupJSP
    Created on : 29 nov. 2024, 18:37:01
    Author     : galan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles/register.css">
    <link rel="stylesheet" href="../styles/header.css">
    <title>Registro</title>
</head>
<body>
    
    <header class="header">
        <h1 class="logo">
            <span class="colorNaranja">PopCorn</span><span class="colorAzul">Rush</span>
        </h1>
        <nav>
            <ul class="nav-links">
                <li> <a href="home.html"> Home</a></li>
                <li> <a href="noticias.html"> Noticias</a></li>
                <li> <a href="generos.html"> Generos</a></li>
                <li> <a href="actores.html"> Actores</a></li>
                <li> <a href="trailers.html"> Trailers</a></li>
            </ul>
        </nav>
        <a href="login.html" class="button"> Iniciar Sesion</a>
    </header>

    <main>
        <div class="container">
            <div class="register-box">
                <h2>INGRESA TUS DATOS</h2>
                <form action="${pageContext.request.contextPath}/RegistroUsuarioNormal" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Nombre Completo:</label>
                        <input type="text" id="name" name="name" placeholder="Tu nombre completo" required>
                    </div>
                
                    <div class="form-group">
                        <label for="email">Correo:</label>
                        <input type="email" id="email" name="email" placeholder="ejemplo@correo.com" required>
                    </div>
                
                    <div class="form-group">
                        <label for="password">Contraseña:</label>
                        <input type="password" id="password" name="password" placeholder="Ingresa tu contraseña" required>
                    </div>
                
                    <div class="form-group">
                        <label for="phone">Teléfono:</label>
                        <input type="tel" id="phone" name="phone" placeholder="Número de teléfono" pattern="[0-9]{10}" required>
                    </div>
                
                    <div class="form-group">
                        <label for="birthdate">Fecha de Nacimiento:</label>
                        <input type="date" id="birthdate" name="birthdate" required>
                    </div>
                
                    <div class="form-group">
                        <label for="gender">Género:</label>
                        <select id="gender" name="gender" required>
                            <option value="">Selecciona tu género</option>
                            <option value="masculino">Masculino</option>
                            <option value="femenino">Femenino</option>
                            <option value="otro">Otro</option>
                        </select>
                    </div>
                
                    <div class="form-group">
                        <label for="state">Estado:</label>
                        <select id="state" name="state" required>
                            <option value="">Selecciona tu estado</option>
                            <option value="estado1">Estado 1</option>
                            <option value="estado2">Estado 2</option>
                            <option value="estado3">Estado 3</option>
                        </select>
                    </div>
                
                    <div class="form-group">
                        <label for="city">Municipio:</label>
                        <select id="city" name="city" required>
                            <option value="">Selecciona tu municipio</option>
                            <option value="municipio1">Municipio 1</option>
                            <option value="municipio2">Municipio 2</option>
                            <option value="municipio3">Municipio 3</option>
                        </select>
                    </div>
                
                    <div class="form-group">
                        <label for="avatar">Subir Avatar:</label>
                        <input type="file" id="avatar" name="avatar" accept="image/*">
                    </div>
                
                    <div class="form-group full-width">
                        <button type="submit">Registrar</button>
                    </div>
                </form>      
            </div>
        </div>
    </main>

    <footer></footer>
</body>
</html>