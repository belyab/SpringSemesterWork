<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style/styleLog.css">
</head>
<#include 'top_nav.ftlh'>
<body>

<div class="wrapper">

    <div class="login_form">
        <div class="title">
            Добавление статьи
        </div>
        <form action="/createPost" method="post" novalidate enctype="multipart/form-data">


            <div class="form_wrap">
                <div class="input_wrap">
                    <label>Введите название</label>
                    <input type="text" name="title" >
                </div>
                <div class="input_wrap">
                    <label>Введите статью</label>
                    <textarea style="width:350px; height:150px;" name="content" ></textarea>
                </div>

                <div class="input_wrap">
                    <input type="submit" value="Сохранить" class="submit_btn">
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
