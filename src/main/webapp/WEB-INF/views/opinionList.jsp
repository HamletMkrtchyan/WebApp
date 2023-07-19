<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista opinii</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="admin-page-body">
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
<div class="opinions-admin-container">
  <h2 class="opinions-admin-heading">Lista opinii</h2>
  <table class="opinions-admin-table">
    <tr>
      <th>Użytkownik</th>
      <th>Treść opinii</th>
      <th>Ocena</th>
      <th>Odpowiedź Admina</th>
      <th>Akcje</th>
    </tr>
    <c:forEach items="${opinions}" var="opinion">
      <tr>
        <td>${opinion.name}</td>
        <td>${opinion.substance}</td>
        <td>${opinion.rating}</td>
        <td>${opinion.adminReply}</td>
        <td>
          <form class="reply-form" action="/adminReply" method="post">
            <input type="hidden" name="opinionId" value="${opinion.id}" />
            <input type="text" name="adminReply" placeholder="Odpowiedz na tę opinię..." />
            <input type="submit" value="Odpowiedz" />
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
<form action="/goBackAdminPage" method="post" class="form-admin-container">
  <input type="submit" value="Powrót do Admin" class="form-admin-submit">
</form>
</body>
</html>
