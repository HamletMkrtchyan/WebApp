<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodanie Produktu</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="product-add-body">
<header class="site-header">
    <h1 class="header-title">Nasz Sklep Waga Mięsa - Strona Admin</h1>
    <nav class="header-nav">
        <ul class="nav-list">
            <li class="nav-item"><a href="/">Strona Główna</a></li>
            <li class="nav-item"><a href="/addProduct">Dodaj product</a></li>
            <li class="nav-item"><a href="/orderList">Lista zamówień</a></li>
            <li class="nav-item"><a href="/opinionList">Lista opinii</a></li>
            <li class="nav-item"><a href="/admin">Admin</a></li>
        </ul>
    </nav>
</header>
<div class="product-add-content">
    <div class="product-add-form-container">
        <form action="/productAdd" method="post" class="product-add-form">
            <h2 class="product-add-heading">Dodaj produkt</h2>
            <label for="name">Nazwa:</label>
            <input type="text" id="name" name="name" placeholder="Nazwa" required oninvalid="this.setCustomValidity('Proszę wprowadzić nazwę produktu')" oninput="this.setCustomValidity('')"><br><br>
            <label for="description">Opis:</label>
            <input type="text" id="description" name="description" placeholder="Opis"><br><br>
            <label for="price">Cena:</label>
            <input type="text" id="price" name="price" placeholder="Cena" required oninvalid="this.setCustomValidity('Proszę podać cenę')" oninput="this.setCustomValidity('')"><br><br>
            <input type="submit" value="Dodaj produkt do listy">
        </form>
        <form action="/goBackAdminPage" method="post" class="admin-back-form">
            <input type="submit" value="Powrót do Admin" class="admin-back-btn">
        </form>
    </div>
    <div class="product-list-table-container">
        <h2 class="product-list-heading">Lista produktów</h2>
        <table class="product-list-table">
            <tr>
                <th>Nazwa</th>
                <th>Opis</th>
                <th>Cena</th>
                <th>Akcje</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td><fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2" maxFractionDigits="2" /> zł/kg</td>
                    <td>
                        <a href="/updateAddedProduct?id=${product.id}"
                           onclick="return confirm('Czy na pewno chcesz edytować ten produkt?');">Edytuj</a>
                        <a href="/deleteAddedProduct?id=${product.id}"
                           onclick="return confirm('Czy na pewno chcesz usunąć ten produkt?');">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
