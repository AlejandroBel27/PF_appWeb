<%-- 
    Document   : trailers
    Created on : 3 dic. 2024, 13:47:17
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
    <title>Trailers</title>
    <link rel="stylesheet" href="../styles/trailers.css">
</head>
<body>
    <%@ include file="../header/header.jsp" %>
    <main>
        <section class="recientes">
            <h2>
                Mas Recientes 
            </h2>
            <div class="trailers">
                <a href="https://youtu.be/xiC2iXTXHxw?si=Skx7bbnJGr-MGd0O"target="_blank"><img src="../img/intensamente2.jfif" alt="Intensamente"></a>
                <a href="https://youtu.be/jKkdYXdn8kc?si=M3HIpcGbVLfpcrAC"target="_blank"><img src="../img/NFS.webp" alt="need for speed the movie"></a>
                <a href="https://youtu.be/BTEPMz-xNgw?si=oPB7IYvuhHJrZ2s8" target="_blank"><img src="../img/elementos.jfif" alt="elementos"></a>
                <a href="https://youtu.be/LYS2O1nl9iM?si=A_EwBbcJT8N3IGnQ"target="_blank"><img src="../img/interestelar.jpg" alt="interestelar"></a>
                <a href="https://youtu.be/SsEojV8hZ9I?si=kl1qZNckW8E3mEbx"target="_blank"><img src="../img/poorthings.jpg" alt=""></a>
                <a href="https://youtu.be/31HT_BwlIfw?si=Ca-qQpVIlQnaXEf1"target="_blank"><img src="../img/redRooms.jfif" alt=""></a>
            </div>
            
        </section>

        <section class="taquilla">
            <h2>
                Trailers de peliculas en taquilla
            </h2>
            <div class="trailers">
                <a href="https://youtu.be/BTEPMz-xNgw?si=oPB7IYvuhHJrZ2s8" target="_blank"><img src="../img/elementos.jfif" alt="elementos"></a>
                <a href="https://youtu.be/sEfOVZDvHPU?si=1fwot8Gjeevic1tB"target="_blank"><img src="../img/La_infiltrada-483866467-large.jpg" alt="La infiltrada"></a>
                <a href="https://youtu.be/jKkdYXdn8kc?si=M3HIpcGbVLfpcrAC"target="_blank"><img src="../img/NFS.webp" alt="need for speed the movie"></a>
                <a href="https://youtu.be/LYS2O1nl9iM?si=A_EwBbcJT8N3IGnQ"target="_blank"><img src="../img/interestelar.jpg" alt="interestelar"></a>
                <a href="https://youtu.be/j8bDBCxrgBQ?si=0oLxa16YQhYuOtfX"target="_blank"><img src="../img/losInmortales.jpg" alt="Los inmortales"></a>
                <a href="https://youtu.be/xiC2iXTXHxw?si=Skx7bbnJGr-MGd0O"target="_blank"><img src="../img/intensamente2.jfif" alt="Intensamente"></a>
            </div>
        </section>
    </main>
</body>
</html>
