<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/styleDetailPost.css">
    <link rel="stylesheet" href="style/styleHome.css">
</head>
<#include 'top_nav.ftlh'>

<body>

<title>Статья</title>

<div class="row">
    <div class="left-column">
        <div class="card">
            <h2>${detailPost.title}</h2>
            <h5>${detailPost.accountEmail}</h5>
            <h5>${detailPost.data}</h5>
            <p>${detailPost.text}</p>
        </div>
    </div>
</div>


</body>
</html>