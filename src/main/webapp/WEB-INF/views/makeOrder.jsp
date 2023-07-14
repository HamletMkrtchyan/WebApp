<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Złóż Zamówienie - Nasz Sklep Mięsny</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="site-body">
<header class="site-header">
  <h1 class="header-title">Złóż Zamówienie</h1>
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
  <section class="section-block">
    <h2 class="section-title">Złóż Zamówienie</h2>
    <form class="form-block" action="/make-order-form" method="post">
      <label for="name">Imię:</label>
      <input type="text" id="name" name="firstName" class="form-input">

      <label for="surname">Nazwisko:</label>
      <input type="text" id="surname" name="lastName" class="form-input">

      <label for="address">Adres:</label>
      <input type="text" id="address" name="address" class="form-input">

      <label for="phone">Telefon:</label>
      <input type="text" id="phone" name="phone" class="form-input">

      <label for="email">E-mail:</label>
      <input type="text" id="email" name="email" class="form-input">

      <label for="product">Produkt:</label>
      <select id="product" name="productId"  class="form-input">
        <c:forEach var="product" items="${products}">
          <option value="${product.id}">${product.name} - ${product.price}</option>
        </c:forEach>
      </select>


      <label for="quantity">Waga: kg</label>
      <input type="text" id="quantity" name="quantity" placeholder="kg" class="form-input"><br>
      <input type="submit" class="form-submit button" value="Złóż Zamówienie">
    </form>
  </section>
</main>

<footer class="site-footer">
  <p class="footer-text">&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
