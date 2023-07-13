<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Napisz Opinię - Nasz Sklep Mięsny</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<header>
    <h1>Napisz Opinię</h1>
    <nav>
        <ul>
            <li><a href="/">Strona Główna</a></li>
            <li><a href="/products">Produkty</a></li>
            <li><a href="/about">O Nas</a></li>
            <li><a href="/contact">Kontakt</a></li>
            <li><a href="/makeOrder">Złóż zamówienie</a></li>
            <li><a href="/opinions">Napisz opinie</a></li>
            <li><a href="/admin">Admin</a></li>
        </ul>
    </nav>
</header>

<main>
    <div class="container">
        <div class="form-container">
            <h2>Napisz Opinię</h2>
            <form action="/opinionForm" method="post">
                <label for="name">Imię:</label><br>
                <input type="text" id="name" name="name"><br>

                <label for="substance">Opinia:</label><br>
                <textarea id="substance" name="substance" maxlength="100"></textarea><br>

                <label for="rating">Ocena (1-5):</label><br>
                <input type="number" id="rating" name="rating" min="1" max="5"><br><br>

                <input type="submit" value="Wyślij Opinię" onclick="return confirm('Czy na pewno chcesz wysłać opinie?');">
            </form>
        </div>

        <div class="opinions-container">
            <h2>Opinie Użytkowników: </h2>
            <c:forEach var="opinion" items="${opinions}">
                <div class="opinion">
                    <p><strong>${opinion.name}</strong> (${opinion.rating}/5)</p>
                    <p>${opinion.substance}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<footer>
    <p>&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
