<!DOCTYPE html>
<#include 'top_nav.ftlh'>
<link rel="stylesheet" href="css/stylePost.css">
<#macro title>
    <title>Ваши статьи</title>
    <link rel="shortcut icon" href="" >

    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function showResult() {

            let html = ""
            const xmlhttp = new XMLHttpRequest();

            xmlhttp.onreadystatechange=function() {
                if (this.readyState===4 && this.status===200) {
                    let response = JSON.parse(this.response)

                    if (response.length !== 0) {
                        for (let i = 0; i < response.length; i++) {
                            html += "<a href='/detailPost/" + response[i]['id'] + "/1" + "'/>"
                            html += "<div class='alert alert-dark' role='alert'>"
                            html += "<h2>" + response[i]['title'] +"</h2>"
                            html += "<div>" + response[i]['text'] +"</div>"
                            html += "<br>"
                            html += "<img src=\"" + response[i]['photo'] + "\" width='665' height='350'>"
                            html += "<br><br>"
                            html += "<div><small class='text-muted'>" + response[i]['userNickname'] + " " +
                                response[i]['data'] + "</small></div>"
                            html += "<div><small class='text-muted'>Статья " + response[i]['id'] + "</small></div>"
                            html += "<br><div><small class='text-muted' style='font-size:20px'><a href='/deletePost/" + response[i]['id'] + "'>Удалить</a></small></div>"
                            html += "</div>" + "</a>"
                        }
                    } else {
                        html = "<p class='lead'>Нет статей!</p>"
                    }

                    document.getElementById("result").innerHTML = html;
                }
            }

            xmlhttp.open("GET","/allMyFindPosts?title=" + document.getElementById('title').value, true);
            xmlhttp.send();
        }
    </script>
</#macro>

<#macro content>
    <br>
    <h1>Ваши статьи</h1>
    <br>

    <form>
        <p class="lead" id="1" style="float: left; margin-right: 50px;">
            Поиск по названию:<br>
            <input id="title" name="title" type="text" onkeyup="showResult()"><br>
        </p>
    </form>

    <br>
    <br>
    <br>
    <br>

    <div id="result">
        <#if myPosts?has_content>
            <#list myPosts as post>
                <a href="/detailPost/${post.id}/1">
                    <div class="alert alert-dark" role="alert">
                        <h2>
                            ${post.title}
                        </h2>
                        <div>
                            ${post.text}
                        </div>
                        <br>
                        <img src="${post.photo}" width="665" height="350">
                        <br>
                        <br>
                        <div>
                            <small class="text-muted">
                                ${post.userEmail} ${post.data}
                            </small>
                        </div>
                        <div>
                            <small class="text-muted">
                                Статья ${post.id}
                            </small>
                        </div>
                        <br>
                        <div>
                            <small class="text-muted" style="font-size:20px">
                                <a href="/deletePost/${post.id}">Удалить</a>
                            </small>
                        </div>
                    </div>
                </a>
            </#list>
        <#else>
            <p class="lead">Нет статей!</p>
        </#if>
    </div>
</#macro>
