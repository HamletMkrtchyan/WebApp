<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Produkty - Nasz Sklep Mięsny</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="site-body">
<header class="site-header">
    <h1 class="header-title">Produkty</h1>
    <nav class="header-nav">
        <ul class="nav-list">
            <li class="nav-item"><a href="/">Strona Główna</a></li>
            <li class="nav-item"><a href="/products">Produkty</a></li>
            <li class="nav-item"><a href="/about">O Nas</a></li>
            <li class="nav-item"><a href="/contact">Kontakt</a></li>
            <li class="nav-item"><a href="/makeOrder">Złóż zamówienia</a></li>
            <li class="nav-item"><a href="/opinions">Napisz opinie</a></li>
            <li class="nav-item"><a href="/admin">Admin</a></li>
        </ul>

    </nav>
</header>
<form action="/productSearch" method="get" class="search-form">
    <input type="text" name="search" placeholder="Szukaj produktu" class="search-input">
    <button type="submit" class="search-button" formaction="/productSearch">Szukaj</button>
    <button type="submit" class="search-button" formaction="/goBackAllProductPage">Wróć</button>
</form>

<main class="site-main">
    <h2 class="main-title">Nasze Produkty</h2>

    <c:forEach var="product" items="${products}">
        <div class="product-card">
            <h3 class="product-title">${product.name}</h3>
            <p class="product-desc">Opis: ${product.description}</p>
            <p class="product-price">Cena: <span>${product.price} zł/kg</span></p>
        </div>
    </c:forEach>

    <c:if test="${not empty errorMessage}">
        <p class="error">${errorMessage}</p>
    </c:if>

</main>

<footer class="site-footer">
    <p class="footer-text">&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
