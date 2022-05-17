<!DOCTYPE html>
<html lang="en">
<head>
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="style/styleOrders.css">
</head>
<body>
<#include 'top_nav.ftlh'>
<div class="container">
    <h1 class="mb-3">Orders</h1>
    <div class="row mb-3">
        <div class="col-auto">
            <input id="client_email" type="text" class="form-control" placeholder="Почта">
            <input id="client_phone_number" type="text" class="form-control" placeholder="Номер телефона">
            <input id="client_zodiac_sign" type="text" class="form-control" placeholder="Знак зодиака">
        </div>
        <div class="col-auto">
            <button id="addOrder" class="btn btn-primary">Добавить</button>
        </div>
    </div>
    <div id="orders"></div>
</div>
<script src="js/orders.js"></script>
</body>
</html>