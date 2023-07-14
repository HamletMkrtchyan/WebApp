<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nasz Sklep Mięsny : Waga Mięsa</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="site-body">
<header class="site-header">

    <h1 class="header-title">Waga Mięsa</h1>
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
    <h2 class="main-title">Witaj w naszym sklepie!</h2>
    <p class="main-desc">Tutaj znajdziesz najwyższej jakości mięso, bezpośrednio od lokalnych rolników.</p>

    <section class="main-section">
        <h3 class="section-title">Nasze Specjały</h3>
        <table class="section-table" border="1" cellspacing="0" cellpadding="5">
            <thead>
            <tr class="table-header">
                <th class="table-header-cell">Nazwa produktu</th>
                <th class="table-header-cell">Cena</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product">
                <tr class="table-row">
                    <td class="table-cell">${product.name}</td>
                    <td class="table-cell">${product.price} zł/kg</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

</main>

<footer class="site-footer">
    <p class="footer-text">&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
