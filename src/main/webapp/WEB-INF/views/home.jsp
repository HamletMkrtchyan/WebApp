<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nasz Sklep Mięsny : Waga Mięsa</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<header>

    <h1>Waga Mięsa</h1>
    <nav>
        <ul>
            <li><a href="/">Strona Główna</a></li>
            <li><a href="/products">Produkty</a></li>
            <li><a href="/about">O Nas</a></li>
            <li><a href="/contact">Kontakt</a></li>
            <li><a href="/makeOrder">Złóż zamówienia</a></li>
            <li><a href="/opinions">Napisz opinie</a></li>
            <li><a href="/admin">Admin</a></li>
        </ul>
    </nav>
</header>

<main>
    <h2>Witaj w naszym sklepie!</h2>
    <p>Tutaj znajdziesz najwyższej jakości mięso, bezpośrednio od lokalnych rolników.</p>

    <section>
        <h3>Nasze Specjały</h3>
        <table border="1" cellspacing="0" cellpadding="5">
            <thead>
            <tr>
                <th>Nazwa produktu</th>
                <th>Cena</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.price} zł/kg</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

</main>

<footer>
    <p>&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
