<!doctype html>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Личная страница</title>
    <style>
        .avatar {
            vertical-align: middle;
            width: 100px;
            height: 100px;
            border-radius: 50%;
        }
    </style>
    <#include "top_nav.ftlh"/>
</head>
<body>
<br>
<td><p class="lead">Добро пожаловать, ${account.firstName} ${account.lastName}!</p></td>



<h2><a href="/logout">Выход</a></h2>
</body>
</html>