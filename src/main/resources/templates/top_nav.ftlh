<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/styleHome.css">
    <meta charset="UTF-8">
</head>
<body>
<nav>
    <a href="/home"><img src="images/Astologo_PNG_white.png"></a>
    <div class="nav-links">
        <ul>
            <li><a href="/home">HOME</a></li>
            <li><a href="/allPosts">POSTS</a></li>
        </ul>
            <#if account?has_content>
            <div class="nav-links">
                <ul>
                    <li><a href="/profile">PROFILE</a></li>
                </ul>
            </div>
            <#else>
    <div class="nav-links">
        <ul>
            <li><a href="/signIn">LOGIN</a></li>
            <li><a href="/signUp">SIGN UP</a></li>
        </ul>
    </div>
            </#if>
    </div>
</nav>

</body>
</html>