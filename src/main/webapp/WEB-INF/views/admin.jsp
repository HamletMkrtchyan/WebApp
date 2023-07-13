<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nasz Sklep Mięsny : Mięsna Kraina</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<header>
    <h1>Nasz Sklep Mięsny Kraina</h1>
    <nav>
        <ul>
            <li><a href="/">Strona Główna</a></li>
            <li><a href="/products">Produkty</a></li>
            <li><a href="/about">O Nas</a></li>
            <li><a href="/contact">Kontakt</a></li>
            <li><a href="/admin">Admin</a></li>
        </ul>
    </nav>
</header>
<main>
    <form action="/admin" method="post">
        Admin Code: <input type="password" name="password" id="password">
        <input type="submit" value="Go">
    </form>
</main>


<footer>
    <p>&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
