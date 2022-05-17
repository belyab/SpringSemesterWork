<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<meta charset="UTF-8">
<head>
    <title>Личная страница</title>
    <link rel="stylesheet" href="style/styleProfile.css">
    <link href="style/styleLog.css" rel="stylesheet" type="text/css"/>
    <#include "top_nav.ftlh"/>
</head>
<body>

<section class="container-fluid" id="main-body">
    <div class="center">
            <div class="profile-body">
                <div class="profile-body-header">
                    <h3><i class="fa fa-user" aria-hidden="true"></i> About</h3>
                </div>
                <div class="profile-body-content">
                            <div class="overview-form">
                                <form action="profile" method="post">
                                    <label>First Name:</label>
                                    <input required type="text" name="first_name"
                                           value="${account.firstName}"/>

                                    <label>Last Name:</label>
                                    <input required type="text" name="last_name"
                                           value="${account.lastName}"/>

                                    <label>Email:</label>
                                    <input required type="text" name="email"
                                           value="${account.email}"/>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div class="form_wrap"
    <div class="input_wrap">
        <a href="/logout" class="submit_btn">Выход </a>
        <br>
        <br>
        <br>

        <a href="/createPost" class="submit_btn">Добавить пост </a>
        <br>
        <br>
        <br>


        <#if account.role == 'ADMIN'>
        <a href="/orders" class="submit_btn">Добавить заказ </a>
        </#if>
    </div>
    </div>
</section>

</body>
</html>
