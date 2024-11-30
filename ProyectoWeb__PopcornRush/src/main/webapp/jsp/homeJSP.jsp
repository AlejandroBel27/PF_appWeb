<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  <!-- Importación de JSTL -->

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="../styles/header.css">
    <link rel="stylesheet" href="../styles/home.css">
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

        <!-- Condicional JSTL para verificar si el usuario está logueado -->
        <c:choose>
            <c:when test="${not empty sessionScope.usuario}">
                <a href="logout.jsp" class="button">Hola! ${sessionScope.usuario.nombreCompleto}</a>
            </c:when>
            <c:otherwise>
                <a href="loginJSP.jsp" class="button">Iniciar Sesión</a>
            </c:otherwise>
        </c:choose>
    </header>

    <main>
        <section class="titleMain">
            <h1>
                <span class="colorAzul">Las mejores</span><span class="colorNaranja">publicaciones!</span>
            </h1>
        </section>

        <section class="container">
            <a href=""> 
                <img src="../img/redRooms.jfif" alt="redRooms">
            </a>
            <a href="">
                <img src="../img/poorthings.jpg" alt="redRooms">
            </a>
            <a href="">
                <img src="../img/poorthings.jpg" alt="poorthings">
            </a>
            <a href="">
                <img src="../img/redRooms.jfif" alt="poorthings">
            </a>
        </section>

        <section class="lines">
            <p>----------------------------------</p>
        </section>

        <div class="movie-info">
            <img src="../img/poorthings.jpg" alt="poorthings Imagen">
            <h2>Poor things, la pelicula mas rara...</h2>
            <h3>Fecha 10 de Enero del 2024</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. A eius quas, necessitatibus harum aliquid
                iure quibusdam, fugiat inventore tenetur nostrum earum facere veniam velit quo sint, rerum provident
                cumque deserunt. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Autem esse cum dolorum
                facilis quisquam similique qui. Dolore enim officia delectus facilis expedita earum inventore
                eveniet, quos deserunt laboriosam rem doloremque! Lorem ipsum dolor sit amet consectetur,
                adipisicing elit. Fugit ex cumque tempore recusandae adipisci sequi cum ipsa id facere at sapiente,
                quisquam iure earum repellendus accusamus dignissimos accusantium, qui distinctio!</p>
        
                <img src="../img/redRooms.jfif" alt="redRooms">
            <h2>redRooms, la pelicula mas roja...</h2>
            <h3>Fecha 90 de Enero del 2024</h3>
            <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. A eius quas, necessitatibus harum aliquid
                iure quibusdam, fugiat inventore tenetur nostrum earum facere veniam velit quo sint, rerum provident
                cumque deserunt. Lorem ipsum dolor, sit amet consectetur adipisicing elit. Autem esse cum dolorum
                facilis quisquam similique qui. Dolore enim officia delectus facilis expedita earum inventore
                eveniet, quos deserunt laboriosam rem doloremque! Lorem ipsum dolor sit amet consectetur,
                adipisicing elit. Fugit ex cumque tempore recusandae adipisci sequi cum ipsa id facere at sapiente,
                quisquam iure earum repellendus accusamus dignissimos accusantium, qui distinctio!</p>
        </div>
    </main>
</body>

</html>
