<!DOCTYPE html>
<html >
<head>
    <link rel="stylesheet" href="css/styleDetailPost.css">
</head>

<#include 'top_nav.ftlh'>

<body>
<#if detailPost?has_content>
<div class="row">
    <div class="left-column">
        <div class="card">
            <h2>${detailPost.title}</h2>
            <h2>${detailPost.accountEmail}</a></h2>
            <h5>${detailPost.data}</h5>
            <p>${detailPost.text}</p>
        </div>
    </div>

        <#if postComments?has_content>
            <p class="lead"><strong>Комментарии:</strong></p>

            <#list postComments as comment>
                <table>
                    <tr>
                        <td><strong style="font-size:20px">${comment.account.email}</a></strong></td>
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
            <form action="/createPostComment/${detailPost.id}" method="post" novalidate>
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

