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
    <title>Noticias</title>
    <link rel="stylesheet" href="../styles/noticias.css">
</head>

<body>
    <%@ include file="../header/header.jsp" %>
    <main>
        <section class="titleMain">
            <h1>
                Noticias
            </h1>
        </section>

        <section class="container">

            <div class="noticia">
                <img src="../img/poorthings.jpg" alt="poorthings">
                <div class="noticia-content">
                    <a href="">
                        <p> Noticias - rodajes</p>
                    </a>
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit porro, eos minima,
                        debitis expedita rerum modi pariatur illum corrupti ratione veniam nesciunt harum quibusdam vel
                        sit ducimus, reiciendis ipsa possimus. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                        Neque dolores excepturi tempora magnam sapiente omnis cupiditate, architecto, laborum eligendi
                        quae sunt. Cumque nulla totam placeat, optio ipsum eveniet obcaecati quibusdam!
                    </p>
                </div>
            </div>

            <div class="noticia">
                <img src="../img/redRooms.jfif" alt="redRooms">
                <div class="noticia-content">
                    <a href="">
                        <p> Noticias - gente</p>
                    </a>
                    <p>

                        Lorem ipsum dolor sit amet consectetur, adipisicing elit. Reprehenderit sit rerum soluta
                        explicabo id asperiores, beatae iusto, unde vel nisi possimus voluptatibus. Vero, fugit
                        accusamus suscipit omnis quaerat officiis doloribus!Lorem ipsum dolor sit, amet consectetur
                        adipisicing elit. Rem delectus voluptatibus,
                        impedit deleniti perspiciatis reiciendis hic fugit nulla libero. Aut autem minus excepturi sit
                        voluptatem labore voluptatibus iusto enim ea!
                    </p>
                </div>
            </div>

            <div class="noticia">
                <img src="../img/redRooms.jfif" alt="redRooms">
                <div class="noticia-content">
                    <a href="">
                        <p> Noticias - Entrevistas</p>
                    </a>
                    <p>

                        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Aliquam laborum natus similique nemo
                        enim esse quas. Aut nulla quo at recusandae dolorum necessitatibus sapiente fugit quas repellat
                        incidunt. Maxime, consequuntur.Lorem ipsum dolor sit, amet consectetur adipisicing elit. Rem
                        delectus voluptatibus,
                        impedit deleniti perspiciatis reiciendis hic fugit nulla libero. Aut autem minus excepturi sit
                        voluptatem labore voluptatibus iusto enim ea!
                    </p>
                </div>
            </div>

        </section>

    </main>
</body>

</html>