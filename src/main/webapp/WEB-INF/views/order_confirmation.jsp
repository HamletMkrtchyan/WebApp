<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Potwierdzenie Zamówienia</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="confirmation-body">
<h2 class="confirmation-heading">Dziękujemy za złożenie zamówienia!</h2>

<p class="confirmation-paragraph">Podsumowanie zamówienia:</p>
<table class="confirmation-table">
    <tr>
        <td class="table-label">Imię:</td>
        <td class="table-value">${firstName}</td>
    </tr>
    <tr>
        <td class="table-label">Nazwisko:</td>
        <td class="table-value">${lastName}</td>
    </tr>
    <tr>
        <td class="table-label">Email:</td>
        <td class="table-value">${email}</td>
    </tr>
    <tr>
        <td class="table-label">Adres:</td>
        <td class="table-value">${address}</td>
    </tr>
    <tr>
        <td class="table-label">Telefon:</td>
        <td class="table-value">${phone}</td>
    </tr>
    <tr>
        <td class="table-label">Ilość:</td>
        <td class="table-value">${quantity} kg</td>
    </tr>
    <tr>
        <td class="table-label">Produkt:</td>
        <td class="table-value">${product.name} - ${product.price}</td>
    </tr>
    <tr>
        <td class="table-label">Do zapłaty:</td>
        <td class="table-label"><fmt:formatNumber value="${quantity * product.price}" type="currency"
                                                  currencySymbol="zł"/></td>

    </tr>
</table>

<p class="confirmation-paragraph">Prosimy o sprawdzenie powyższych danych. Jeżeli coś jest nie tak, prosimy o
    kontakt.</p>

<button onclick="window.location.href='/makeOrder'" class="confirmation-button">Powrót</button>

</body>
</html>
