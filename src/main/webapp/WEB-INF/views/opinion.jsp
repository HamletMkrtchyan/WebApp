<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Napisz Opinię - Nasz Sklep Mięsny</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="site-body">
<header class="site-header">
    <h1 class="header-title">Napisz Opinię</h1>
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

<main class="site-main">
    <div class="content-container">
        <section class="section-block">
            <div class="form-wrapper">
            <h2 class="section-title">Napisz Opinię</h2>
            <form class="form-block" action="/opinionForm" method="post"><br>
                <label for="name">Imię:</label>
                <input type="text" id="name" name="name" class="form-input">

                <label for="substance">Opinia:</label>
                <textarea id="substance" name="substance" maxlength="100" class="form-input"></textarea>

                <label for="rating">Ocena (1-5):</label>
                <input type="number" id="rating" name="rating" min="1" max="5" class="form-input">

                <input type="submit" value="Wyślij Opinię" class="form-submit button" onclick="return confirm('Czy na pewno chcesz wysłać opinie?');">
            </form>
            </div>
        </section>

        <section class="section-block">
            <h2 class="section-title">Opinie Użytkowników: </h2>
            <c:forEach var="opinion" items="${opinions}">
                <div class="opinion-block">
                    <p class="opinion-header"><strong>${opinion.name}</strong> (${opinion.rating}/5)</p>
                    <p class="opinion-text">${opinion.substance}</p>
                </div>
            </c:forEach>
        </section>
    </div>
</main>

<footer class="site-footer">
    <p class="footer-text">&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
