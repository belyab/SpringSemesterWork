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
            <#if account?has_content>
            <li><a href="/profile">PROFILE</a></li>
            <#else>
            <li><a href="/signIn">LOGIN</a></li>
            </#if>
        </ul>
    </div>
</nav>

</body>
</html>