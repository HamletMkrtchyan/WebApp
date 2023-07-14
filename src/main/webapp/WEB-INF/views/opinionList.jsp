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
<div class="opinions-admin-container">
  <h2 class="opinions-admin-heading">Lista opinii</h2>
  <table class="opinions-admin-table">
    <tr>
      <th>Użytkownik</th>
      <th>Treść opinii</th>
      <th>Ocena</th>
    </tr>
    <c:forEach items="${opinions}" var="opinion">
      <tr>
        <td>${opinion.name}</td>
        <td>${opinion.substance}</td>
        <td>${opinion.rating}</td>
      </tr>
    </c:forEach>
    <br>
  </table>
</div>
<form action="/goBackAdminPage" method="post" class="form-admin-container">
  <input type="submit" value="Powrót do Admin" class="form-admin-submit">
</form>
</body>
</html>
