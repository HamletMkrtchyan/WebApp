<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lista Zamówień</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="order-admin-page-body">
<h2 class="order-admin-heading">Lista Zamówień</h2>

<table class="order-admin-table">

  <tr>
    <th>Id</th>
    <th>Imię użytkownika</th>
    <th>Nazwisko użytkownika</th>
    <th>Adres</th>
    <th>Produkt</th>
    <th>Waga</th>
    <th>Do zapłaty</th>
    <th>Czas</th>
    <th>Akcja</th>
  </tr>

  <c:forEach var="order" items="${orders}">
    <tr>
      <td>${order.id}</td>
      <td>${order.user.firstName}</td>
      <td>${order.user.lastName}</td>
      <td>${order.user.address}</td>
      <td>${order.product.name}</td>
      <td>${order.quantity} kg</td>
      <td><fmt:formatNumber value="${order.quantity * order.product.price}" type="currency" currencySymbol="zł" /></td>
      <td>${order.orderTime}</td>
      <td>
        <form action="/mark-as-done" method="post">
          <input type="hidden" name="id" value="${order.id}"/>
          <input type="submit" value="Zrobione" onclick="return confirm('Czy na pewno chcesz zaznaczyc to zamówienie jako zrobione i usuwac z listy?');"/>
        </form>
    </tr>
  </c:forEach>
</table>

<form action="/goBackAdminPage" method="post" class="form-admin-back">
  <input type="submit" value="Powrót do Admin" class="form-admin-back-submit">
</form>

</body>
</html>
