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
    <title>Crear Publicacion</title>
    <link rel="stylesheet" href="../styles/crearPublicacion.css">
    <link rel="stylesheet" href="../styles/header.css">
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

    <div class="container">
        <main>
            <button class="submit-button ">Publicar</button>
            <div class="editor">
                <textarea placeholder="Escribe tu post aquí..."></textarea>
            </div>
            <div class="form">
                <label class= "label" for="titulo">Título del Post:</label>
                <input type="text" id="titulo" placeholder="Título del Post">

                <label class= "label" for="nombre">Nombre de la Película:</label>
                <input type="text" id="nombre" placeholder="Nombre de la Película">

                <label class= "label" for="genero">Género de la Película:</label>
                <select id="genero">
                    <option>Seleccione...</option>
                    <option>Acción</option>
                    <option>Comedia</option>
                    <option>Drama</option>
                    <option>Terror</option>
                    <option>Documental</option>
                </select>

                <label class="label">Imágenes del Post:</label>
                <div class="imgs-post">
                    <label for="imgPortada">Portada:</label>
                    <input type="file" id="imgPortada" name="imgPortada" accept="image/*" required>
                </div>

                <label class="label">Calificación:</label>
                <div class="calificacion">
                    <input id="radio1" type="radio" name="estrellas" value="5">
                    <label for="radio1">★</label>
                    <input id="radio2" type="radio" name="estrellas" value="4">
                    <label for="radio2">★</label>
                    <input id="radio3" type="radio" name="estrellas" value="3">
                    <label for="radio3">★</label>
                    <input id="radio4" type="radio" name="estrellas" value="2">
                    <label for="radio4">★</label>
                    <input id="radio5" type="radio" name="estrellas" value="1">
                    <label for="radio5">★</label>
                </div>
            </div>
        </main>
    </div>
</body>

</html>