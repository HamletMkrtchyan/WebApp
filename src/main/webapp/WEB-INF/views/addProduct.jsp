<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hamlet
  Date: 12/07/2023
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodanie Produktu</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
<form action="productAdd" method="post" class="form">
    <h2 class="form-heading">Dodaj produkt</h2>
    <label for="name">Nazwa:</label>
    <input type="text" id="name" name="name" placeholder="Nazwa" class="form-input"><br><br>
    <label for="description">Opis:</label>
    <input type="text" id="description" name="description" placeholder="Opis" class="form-input"><br><br>
    <label for="price">Cena:</label>
    <input type="text" id="price" name="price" placeholder="Cena" class="form-input"><br><br>
    <input type="submit" value="Dodaj" class="form-submit">
</form>
<form action="goBackAdminPage" method="post">
    <input type="submit" value="Powrót do Admin" class="form-submit">
</form>

<h2>Lista produktów</h2>
<table>
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
            <td>${product.price}</td>
            <td>
                <a href="/updateAddedProduct?id=${product.id}" class="edit-link"
                   onclick="return confirm('Czy na pewno chcesz edytować ten produkt?');">Edytuj</a>
                <a href="/deleteAddedProduct?id=${product.id}" class="delete-link"
                   onclick="return confirm('Czy na pewno chcesz usunąć ten produkt?');">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
