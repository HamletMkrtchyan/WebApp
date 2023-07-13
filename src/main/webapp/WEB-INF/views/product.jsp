<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Produkty - Nasz Sklep Mięsny</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<header>
  <h1>Produkty</h1>
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
  <h2>Nasze Produkty</h2>

  <c:forEach var="product" items="${products}">
    <div style="border:1px solid #000; padding:15px; margin-bottom:20px;">
      <h3 style="color: #46494c;">${product.name}</h3>
      Opis: <p>${product.description}</p>
      <p>Cena: <span style="font-weight: bold;">${product.price} zł/kg</span></p>
    </div>
  </c:forEach>
</main>


<footer class="footer-class">
  <p>&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>

</body>
</html>
