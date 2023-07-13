<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Lista Zamówień</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h2>Lista Zamówień</h2>

<table>
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
      <td><fmt:formatNumber value="${quantity * product.price}" type="currency" currencySymbol="zł" /></td>
      <td>${order.orderTime}</td>
      <td>
        <form action="/mark-as-done" method="post">
          <input type="hidden" name="id" value="${order.id}"/>
          <input type="submit" value="Zrobione" onclick="return confirm('Czy na pewno chcesz zaznaczyc to zamówienie jako zrobione i usuwac z listy?');"/>
        </form>
    </tr>
  </c:forEach>

  <form action="/goBackAdminPage" method="post">
    <input type="submit" value="Powrót do Admin" class="form-submit">
  </form>

</table>
</body>
</html>
