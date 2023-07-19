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
                <input type="text" id="name" name="name" class="form-input" required oninvalid="this.setCustomValidity('Proszę wprowadzić imię')" oninput="this.setCustomValidity('')">

                <label for="substance">Opinia:</label>
                <textarea id="substance" name="substance" maxlength="100" class="form-input"></textarea>

                <label>Ocena:</label>
                <div>
                    <input type="radio" id="rating1" name="rating" value="1">
                    <label for="rating1">1</label>
                    <input type="radio" id="rating2" name="rating" value="2">
                    <label for="rating2">2</label>
                    <input type="radio" id="rating3" name="rating" value="3">
                    <label for="rating3">3</label>
                    <input type="radio" id="rating4" name="rating" value="4">
                    <label for="rating4">4</label>
                    <input type="radio" id="rating5" name="rating" value="5">
                    <label for="rating5">5</label>
                </div>

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
