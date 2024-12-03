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
    <title>Actores</title>
    <link rel="stylesheet" href="../styles/actores.css">
</head>

<body>
    <%@ include file="../header/header.jsp" %>
    <main>
        <section class="titleMain">
            <h1>
                Top Actores del mes
            </h1>
        </section>

        <div class="actor">
            <img src="../img/cooper.jpg" alt="cooper Koch">
            <div class="actor-content">
                <h2> Cooper Koch</h2>
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit porro, eos minima,
                    debitis expedita rerum modi pariatur illum corrupti ratione veniam nesciunt harum quibusdam vel
                    sit ducimus, reiciendis ipsa possimus. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    Neque dolores excepturi tempora magnam sapiente omnis cupiditate, architecto, laborum eligendi
                    quae sunt. Cumque nulla totam placeat, optio ipsum eveniet obcaecati quibusdam!
                </p>
            </div>
        </div>

        <div class="actor">
            <img src="../img/nicolas.jpg" alt="Nicholas Alexander Chavez">
            <div class="actor-content">
                <h2> Nicholas Alexander Chavez</h2>
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit porro, eos minima,
                    debitis expedita rerum modi pariatur illum corrupti ratione veniam nesciunt harum quibusdam vel
                    sit ducimus, reiciendis ipsa possimus. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    Neque dolores excepturi tempora magnam sapiente omnis cupiditate, architecto, laborum eligendi
                    quae sunt. Cumque nulla totam placeat, optio ipsum eveniet obcaecati quibusdam!
                </p>
            </div>
        </div>

        <div class="actor">
            <img src="../img/lady-gaga.webp" alt="lady-gaga">
            <div class="actor-content">
                <h2> Lady Gaga </h2>
                <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Reprehenderit porro, eos minima,
                    debitis expedita rerum modi pariatur illum corrupti ratione veniam nesciunt harum quibusdam vel
                    sit ducimus, reiciendis ipsa possimus. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                    Neque dolores excepturi tempora magnam sapiente omnis cupiditate, architecto, laborum eligendi
                    quae sunt. Cumque nulla totam placeat, optio ipsum eveniet obcaecati quibusdam!
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Officiis ratione maxime quisquam sapiente
                    consequuntur, totam nisi rerum repudiandae quaerat accusantium perferendis laudantium harum dolor,
                    doloremque nesciunt nam dicta. Eligendi, modi.
                </p>
            </div>
        </div>
    </main>
</body>

</html>