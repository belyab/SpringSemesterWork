<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/stylePosts.css">
</head>
<#include 'top_nav.ftlh'>
<body>
<title>Добавление статьи</title>


    <br>
    <h1>Статья</h1>
    <br>
    <form action="/createPost" method="post" novalidate enctype="multipart/form-data">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <p class="lead">
            Введите название:<br>
            <input name="title" type="text" ><br>
        </p>


        <p class="lead">
            Введите статью:<br>
            <label>
                <textarea name="content" placeholder="Статья..." ></textarea>
            </label><br>
        </p>

        <p class="lead"><input type="submit" value="Сохранить"></p>
        <br>
    </form>
</body>
</html>
