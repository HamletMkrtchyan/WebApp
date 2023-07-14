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
<div class="form-container update-product-form-container">
    <h2 class="update-product-heading">Zaaktualizuj produkt</h2>

    <form action="/updateProduct" method="post" class="update-product-form">
        <input type="hidden" name="id" value="${product.id}" />

        <label for="name" class="update-product-label">Nazwa:</label><br>
        <input type="text" id="name" name="name" value="${product.name}" class="update-product-input"/><br>

        <label for="description" class="update-product-label">Opis:</label><br>
        <textarea id="description" name="description" class="update-product-textarea">${product.description}</textarea><br>

        <label for="price" class="update-product-label">Cena:</label><br>
        <input type="text" id="price" name="price" value="${product.price}" class="update-product-input"/><br>

        <input type="submit" value="Zaaktualizuj" class="update-product-submit"/><br><br>
        <a href="/addProduct" class="update-product-back-link"><input type="submit" value="Powrót"></a>

    </form>
</div>
</body>
</html>
