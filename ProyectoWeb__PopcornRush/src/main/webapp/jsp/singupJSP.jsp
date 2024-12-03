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
    
    <%@ include file="../header/header.jsp" %>

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
                        <input type="text" id="state" name="state" placeholder="Ingresa tu estado" required>
                    </div>
                  
                    <div class="form-group">
                        <label for="city">Estado:</label>
                        <input type="text" id="city" name="city" placeholder="Ingresa tu ciudad" required>
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