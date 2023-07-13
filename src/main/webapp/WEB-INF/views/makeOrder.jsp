
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Złóż Zamówienie - Nasz Sklep Mięsny</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<header>
  <h1>Złóż Zamówienie</h1>
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
  <h2>Złóż Zamówienie</h2>
  <form action="/make-order-form" method="post">
    <label for="name">Imię:</label><br>
    <input type="text" id="name" name="firstName"><br>

    <label for="surname">Nazwisko:</label><br>
    <input type="text" id="surname" name="lastName"><br>

    <label for="address">Adres:</label><br>
    <input type="text" id="address" name="address"><br>

    <label for="phone">Telefon:</label><br>
    <input type="text" id="phone" name="phone"><br>

    <label for="email">E-mail:</label><br>
    <input type="text" id="email" name="email"><br>

    <label for="product">Produkt:</label><br>
    <select id="product" name="productId">
      <c:forEach var="product" items="${products}">
        <option value="${product.id}">${product.name} - ${product.price}</option>
      </c:forEach>
    </select><br>


    <label for="quantity">Waga: kg</label><br>
    <input type="text" id="quantity" name="quantity" placeholder="kg"><br><br>

    <input type="submit"class="button" value="Złóż Zamówienie">
  </form>
</main>

<footer>
  <p>&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
