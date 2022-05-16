<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Login</title>
    <link href="css/styleLog.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="css/styleHome.css">
</head>
<body>
<#include 'top_nav.ftlh'>
<div class="wrapper">

    <div class="login_form">
        <div class="title">
            Login
        </div>
        <form action="/signIn" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <div class="form_wrap">
                <div class="input_wrap">
                    <label>Email</label>
                    <input type="text" name="email" placeholder="Email">
                </div>
                <div class="input_wrap">
                    <label>Password</label>
                    <input type="password" name="password" placeholder="Password">
                </div>

                <div class="input_wrap">
                    <label>
                        <input type="checkbox" name="rememberMe">Запомнить меня
                    </label>
                </div>

                <div class="input_wrap">
                    <input type="submit" value="Sign In" class="submit_btn">
                </div>
                <a href="/signUp">Create New Account</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>

