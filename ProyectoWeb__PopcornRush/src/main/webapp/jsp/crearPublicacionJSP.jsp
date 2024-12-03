<%-- 
    Document   : crearPublicacionJSP
    Created on : 29 nov. 2024, 19:01:24
    Author     : galan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Publicación</title>
    <link rel="stylesheet" href="../styles/crearPublicacion.css">
    <link rel="stylesheet" href="../styles/header.css">
</head>

<body>
    <%@ include file="../header/header.jsp" %>

    <div class="container">
        <main>
            <!-- Formulario que envía los datos al servlet -->
            <form action="${pageContext.request.contextPath}/SvCrearPublicaciones" method="POST" enctype="multipart/form-data">
                <div class="form">
                    <!-- Campo de título -->
                    <label class="label" for="titulo">Título del Post:</label>
                    <input type="text" id="titulo" name="titulo" placeholder="Título del Post" required>

                    <!-- Campo de nombre de película -->
                    <label class="label" for="nombre">Nombre de la Película:</label>
                    <input type="text" id="nombre" name="nombrePelicula" placeholder="Nombre de la Película" required>

                    <!-- Campo de género -->
                    <label class="label" for="genero">Género de la Película:</label>
                    <select id="genero" name="genero" required>
                        <option value="">Seleccione...</option>
                        <option value="Acción">Acción</option>
                        <option value="Comedia">Comedia</option>
                        <option value="Drama">Drama</option>
                        <option value="Terror">Terror</option>
                        <option value="Documental">Documental</option>
                    </select>

                    <!-- Campo para subir imagen -->
                    <label class="label">Imágenes del Post:</label>
                    <div class="imgs-post">
                        <label for="imgPortada">Portada:</label>
                        <input type="file" id="imgPortada" name="imgPortada" accept="image/*" required>
                    </div>

                    <!-- Campo de calificación -->
                    <label class="label">Calificación:</label>
                    <div class="calificacion">
                        <input id="radio1" type="radio" name="calificacion" value="5" required>
                        <label for="radio1">★</label>
                        <input id="radio2" type="radio" name="calificacion" value="4">
                        <label for="radio2">★</label>
                        <input id="radio3" type="radio" name="calificacion" value="3">
                        <label for="radio3">★</label>
                        <input id="radio4" type="radio" name="calificacion" value="2">
                        <label for="radio4">★</label>
                        <input id="radio5" type="radio" name="calificacion" value="1">
                        <label for="radio5">★</label>
                    </div>
                </div>

                <!-- Campo del contenido del post -->
                <div class="editor">
                    <textarea name="contenido" placeholder="Escribe tu post aquí..." required></textarea>
                </div>

                <!-- Botón de envío -->
                <button type="submit" class="submit-button">Publicar</button>
            </form>
        </main>
    </div>
</body>

</html>
