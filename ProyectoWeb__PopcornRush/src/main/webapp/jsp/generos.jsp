<%-- 
    Document   : generos
    Created on : 3 dic. 2024, 13:48:28
    Author     : galan
--%>

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
    <title>Generos</title>
    <link rel="stylesheet" href="../styles/header.css">
    <link rel="stylesheet" href="../styles/generos.css">
</head>
<body>
    <%@ include file="../header/header.jsp" %>
    <main>
        <section class="titleMain"> 
            <h1>
                <span class="colorAzul">Busca tus generos</span><span class="colorNaranja">Favoritos!</span>
            </h1>
        </section>

        <section class="banner">
            <img src="../img/banner.jpg" alt="banner">
        </section>

        <section class="populares">
            <h2>
                Más Populares
            </h2>
            <div class="imagenes">
                <a href="#action"><img src="../img/accion.png" alt="accion"></a>
                <a href="#aventura"><img src="../img/aventura.webp" alt="aventura"></a>
                <a href="#comedia"><img src="../img/comedy.jpg" alt="comedy"></a>
                <a href="#drama"><img src="../img/drama.jpg" alt="Drama"></a>
            </div>
        </section>

        <section class="populares">
            <h2 id="action">
                Acción
            </h2>
            <div class="imagenes">
                <a href=""><img src="../img/NFS.webp" alt="bridgerton"></a>
                <a href=""><img src="../img/redRooms.jfif" alt="bridgerton"></a>
                <a href=""><img src="../img/losInmortales.jpg" alt="bridgerton"></a>
                <a href=""><img src="../img/interestelar.jpg" alt="bridgerton"></a>
            </div>
        </section>

        <section class="populares">
            <h2 id="aventura">
                Aventura
            </h2>
            <div class="imagenes">
                <a href=""><img src="../img/NFS.webp" alt="bridgerton"></a>
                <a href=""><img src="../img/redRooms.jfif" alt="bridgerton"></a>
                <a href=""><img src="../img/losInmortales.jpg" alt="bridgerton"></a>
                <a href=""><img src="../img/interestelar.jpg" alt="bridgerton"></a>
            </div>
        </section>

        <section class="populares">
            <h2 id="comedia">
                Comedia
            </h2>
            <div class="imagenes">
                <a href=""><img src="../img/NFS.webp" alt="bridgerton"></a>
                <a href=""><img src="../img/redRooms.jfif" alt="bridgerton"></a>
                <a href=""><img src="../img/losInmortales.jpg" alt="bridgerton"></a>
                <a href=""><img src="../img/interestelar.jpg" alt="bridgerton"></a>
            </div>
        </section>

        <section class="populares">
            <h2 id="drama">
                Drama
            </h2>
            <div class="imagenes">
                <a href=""><img src="../img/NFS.webp" alt="bridgerton"></a>
                <a href=""><img src="../img/redRooms.jfif" alt="bridgerton"></a>
                <a href=""><img src="../img/losInmortales.jpg" alt="bridgerton"></a>
                <a href=""><img src="../img/interestelar.jpg" alt="bridgerton"></a>
            </div>
        </section>
    </main>
</body>
</html>
