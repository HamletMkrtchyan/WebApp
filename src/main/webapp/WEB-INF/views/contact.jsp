<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kontakt - Nasz Sklep Mięsny</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="site-body">
<header class="site-header">
    <h1 class="header-title">Kontakt</h1>
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
        <h2 class="section-title">Skontaktuj się z nami</h2>
        <p class="section-content">Adres: ul. Kraina 24/b, 51-109</p>
        <p class="section-content">Email: kraina@vp.pl</p>
        <p class="section-content">Telefon: 784 - 111 - 910</p><br><br>
        <p class="section-content">Wyślij do nas wiadomość używając poniższego formularza:</p>
    </section>
</main>


<form action="/sendEmail" method="post" class="meat-shop-contact-form">
    <label for="firstName" class="meat-shop-contact-label meat-shop-contact-label-name" >Twoje imię:</label><br>
    <input type="text" id="firstName" name="firstName" class="meat-shop-contact-input meat-shop-contact-input-name" required oninvalid="this.setCustomValidity('Proszę podać imię')" oninput="this.setCustomValidity('')"><br>
    <label for="email" class="meat-shop-contact-label meat-shop-contact-label-email">Twój email:</label><br>
    <input type="email" id="email" name="email" class="meat-shop-contact-input meat-shop-contact-input-email" required oninvalid="this.setCustomValidity('Proszę wprowadzić mail do kontaku')" oninput="this.setCustomValidity('')"><br>
    <label for="topic" class="meat-shop-contact-label meat-shop-contact-label-subject">Temat:</label><br>
    <input type="text" id="topic" name="topic" class="meat-shop-contact-input meat-shop-contact-input-subject" required oninvalid="this.setCustomValidity('Proszę wprowadzić temat wiadomości')" oninput="this.setCustomValidity('')"><br>
    <label for="emailMessage" class="meat-shop-contact-label meat-shop-contact-label-message">Wiadomość:</label><br>
    <textarea id="emailMessage" name="emailMessage" rows="4" cols="50" class="meat-shop-contact-textarea meat-shop-contact-textarea-message" required oninvalid="this.setCustomValidity('Proszę wypełnić treśc wiadomości')" oninput="this.setCustomValidity('')"></textarea><br>
    <input type="submit" value="Wyślij do nas wiadomość" class="meat-shop-contact-submit">
</form>




<footer class="site-footer">
    <p class="footer-text">&copy; 2023 Nasz Sklep Mięsny. Wszystkie prawa zastrzeżone.</p>
</footer>
</body>
</html>
