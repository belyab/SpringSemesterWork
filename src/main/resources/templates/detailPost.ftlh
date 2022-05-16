<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/stylePosts.css">
</head>

<#include 'top_nav.ftlh'>

<body>

<title>Статья</title>

    <br>
    <#if isMyPost??>
        <p class="lead"><a href="/myPosts">Назад</a></p>
    <#else>
        <p class="lead"><a href="/allPosts">Назад</a></p>
    </#if>
    <br>

    <#if detailPost?has_content>
        <h1>${detailPost.title}</h1>
        <br>
        <div>${detailPost.text}</div>
        <br>
        <div>
            <table>
                <tr>
                    <td><img alt="user_img" src="${author.avatar}" width="50" height="50" class="rounded-circle"></td>

                    <td><strong style="font-size:20px"><a href="/detailUser/${author.id}">${detailPost.accountEmail}</a></strong></td>
                    <td><small class="text-muted" style="font-size:17px"><em>${detailPost.data}</em></small></td>
                    <td><small class="text-muted" style="font-size:17px">Статья ${detailPost.id}</small></td>
                </tr>
            </table>
        </div>

        <br>

        <#if postComments?has_content>
            <p class="lead"><strong>Комментарии:</strong></p>

            <#list postComments as comment>
                <table>
                    <tr>
                        <td><img alt="user_img" src="${comment.account.avatar}" width="50" height="50" class="rounded-circle"></td>
                        <td><strong style="font-size:20px"><a href="/detailUser/${comment.account.id}">${comment.account.email}</a></strong></td>
                    </tr>
                </table>
                <div class="alert alert-dark" role="alert">
                    <div>${comment.text}</div>
                </div>
            </#list>
        <#else>
            <p class="lead">Нет комментариев!</p>
        </#if>

        <#if account?has_content>
            <form action="/createPostComment/${detailPost.id}/0" method="post" novalidate>
                <p class="lead">Введите комментарий:</p>
                <p class="lead">
                    <label>
                        <textarea name="comment" placeholder="Комментарий..." class="comment"></textarea>
                    </label><br>
                </p>
                <p class="lead"><input type="submit" value="Сохранить"></p>
                <br>
            </form>
        <#else>
            <p class="lead">Ввойдите в аккаунт, чтобы оставлять комментарии!</p>
        </#if>

    <#else>
        <p class="lead">Что-то пошло не так...</p>
    </#if>

</body>
</html>
