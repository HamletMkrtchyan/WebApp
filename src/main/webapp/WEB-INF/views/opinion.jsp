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
                    <div class="rating">
                        <input type="radio" id="rating5" name="rating" value="5">
                        <label for="rating5">☆</label>
                        <input type="radio" id="rating4" name="rating" value="4">
                        <label for="rating4">☆</label>
                        <input type="radio" id="rating3" name="rating" value="3">
                        <label for="rating3">☆</label>
                        <input type="radio" id="rating2" name="rating" value="2">
                        <label for="rating2">☆</label>
                        <input type="radio" id="rating1" name="rating" value="1">
                        <label for="rating1">☆</label>
                    </div>

                    <input type="submit" value="Wyślij Opinię" class="form-submit button" onclick="return confirm('Czy na pewno chcesz wysłać opinie?');">
                </form>
            </div>
        </section>

        <section class="section-block">
            <h2 class="section-title">Opinie Użytkowników: </h2>
            <c:forEach var="opinion" items="${opinions}">
                <div class="opinion-block">
                    <p class="opinion-header"><strong>${opinion.name}</strong></p>
                    <div class="stars">
                        <c:choose>
                            <c:when test="${opinion.rating == 1}">★☆☆☆☆</c:when>
                            <c:when test="${opinion.rating == 2}">★★☆☆☆</c:when>
                            <c:when test="${opinion.rating == 3}">★★★☆☆</c:when>
                            <c:when test="${opinion.rating == 4}">★★★★☆</c:when>
                            <c:when test="${opinion.rating == 5}">★★★★★</c:when>
                        </c:choose>
                    </div>
                    <p class="opinion-text">${opinion.substance}</p>
                    <c:if test="${opinion.adminReply != null}">
                        <p class="admin-reply-header"><strong>Odpowiedź Admina:</strong></p>
                        <p class="admin-reply-text">${opinion.adminReply}</p>
                    </c:if>
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
