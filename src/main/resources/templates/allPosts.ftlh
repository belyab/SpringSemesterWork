<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/stylePosts.css">
</head>

<#include 'top_nav.ftlh'>

<body>

<title>Все статьи</title>
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
                        html += "<a href='/detailPost/" + response[i]['id'] + "/0" + "'/>"
                        html += "<div class='alert alert-dark' role='alert'>"
                        html += "<h2>" + response[i]['title'] +"</h2>"
                        html += "<div>" + response[i]['text'] +"</div>"
                        html += "<br><br>"
                        html += "<div><small class='text-muted'>" + response[i]['userEmail'] + " " +
                            response[i]['data'] + "</small></div>"
                        html += "<div><small class='text-muted'>Статья " + response[i]['id'] + "</small></div>"
                        html += "</div>" + "</a>"
                    }
                } else {
                    html = "<p class='lead'>Нет статей!</p>"
                }

                document.getElementById("result").innerHTML = html;
            }
        }

        xmlhttp.open("GET","/allFindPosts?title=" + document.getElementById('title').value, true);
        xmlhttp.send();
    }
</script>

<br>
<h1>Все статьи</h1>
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
    <#if allPosts?has_content>
    <#list allPosts as post>
    <a href="/detailPost/${post.id}/0">
        <div class="alert alert-dark" role="alert">
            <h2>
                ${post.title}
            </h2>
            <div>
                ${post.text}
            </div>
            <br>
            <div>
                <small class="text-muted">
                    ${post.accountEmail} ${post.data}
                </small>
            </div>
            <div>
                <small class="text-muted">
                    Статья ${post.id}
                </small>
            </div>
        </div>
    </a>
</#list>
<#else>
<p class="lead">Нет статей!</p>
</#if>
</div>
</body>
</html>
