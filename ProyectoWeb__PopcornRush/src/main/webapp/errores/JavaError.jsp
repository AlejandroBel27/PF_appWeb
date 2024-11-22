<%-- 
    Document   : JavaError
    Created on : 21 nov 2024, 22:52:14
    Author     : PERSONAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../styles/errors.css" />
        <title>Java Error</title>
    </head>
    <body>
        <h1>Java Error</h1>
        <p>Disculpa, Java ha lanzado una excepción</p>
        <p>Para continuar, regresa a la página anterior.</p>
        
        <h2>Detalles</h2>
        <p>Type: {pageContext.exception["class"]}</p>
        <p>Message: {pageContext.exception.message}</p>
    </body>
</html>
