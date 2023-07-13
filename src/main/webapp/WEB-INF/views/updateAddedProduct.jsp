
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Zaaktualizuj Produkt</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<div class="form-container">
    <h2>Zaaktualizuj produkt</h2>

    <form action="/updateProduct" method="post">
        <input type="hidden" name="id" value="${product.id}" />

        <label for="name">Nazwa:</label><br>
        <input type="text" id="name" name="name" value="${product.name}" /><br>

        <label for="description">Opis:</label><br>
        <textarea id="description" name="description">${product.description}</textarea><br>

        <label for="price">Cena:</label><br>
        <input type="text" id="price" name="price" value="${product.price}" /><br>

        <input type="submit" value="Zaaktualizuj" /><br><br>
        <a href="/addProduct"><input type="submit" value="Powrót"></a>

    </form>
</div>
</body>
</html>
