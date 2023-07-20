<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nasz Sklep Mięsny : Waga Mięsa</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="site-body">
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

<main class="admin-site-main">
    <section class="admin-section-block">
        <h2 class="admin-section-title">Wiadomości od użytkowników</h2>
        <div class="admin-section-content">
            <c:if test="${empty contactMails}">
                <p class="admin-empty-message">Brak wiadomości.</p>
            </c:if>
            <c:forEach var="contactMail" items="${contactMails}">
                <div class="admin-message-item">
                    <h3 class="admin-message-subject">${contactMail.topic}</h3>
                    <p class="admin-message-info">Od: ${contactMail.user.firstName}
                        (<a class="admin-message-email-link" href="mailto:${contactMail.user.email}">
                                ${contactMail.user.email}</a>)</p>
                    <p class="admin-message-content">${contactMail.emailMessage}</p>
                </div>
            </c:forEach>
        </div>
    </section>
</main>


<footer class="site-footer">
    <p class="footer-text">&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
