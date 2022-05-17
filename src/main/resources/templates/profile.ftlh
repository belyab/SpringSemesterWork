<!doctype html>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Личная страница</title>
    <link rel="stylesheet" href="css/styleProfile.css">
    <link href="css/styleLog.css" rel="stylesheet" type="text/css"/>
    <#include "top_nav.ftlh"/>
</head>
<body>

<section class="container-fluid" id="main-body">
    <div class="center">
    <div class="row no-pad">
        <div class="col-md-8 no-pad">
            <div class="profile-body">
                <div class="profile-body-header">
                    <h3><i class="fa fa-user" aria-hidden="true"></i> About</h3>
                </div>
                <div class="profile-body-content">
                    <div class="row no-pad">
                        <div class="col-md-8 profile-body-content-editing">
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
        <a href="/logout">Выход </a>
        <a href="/createPost">Добавить пост </a>
        <a href="/myPosts">Мои посты </a>
    </div>
</section>

</body>
</html>
