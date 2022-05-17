<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styleAllPosts.css">
</head>


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
                        html += "<div class='box-cards-blog'>"
                        html += "<div class='card'>"
                        html += "<div class='card-meta'>"
                        html += " <div class='card-body'>"
                        html += "<h2 class='card-title'>"+"<a href='/detailPost/" + response[i]['id'] + "/0" + "'/>"+ response[i]['title']+"</a>"
                        html += "</h2>"
                        html += "</div>"
                        html += "<div class='card-bottom'>"
                        html += "<div class='user'>"
                        html += "<span class='username'>" + response[i]['accountEmail']+"</span>"
                        html += "</div>" + "</div>"+ "</div>"+ "</div>"+ "</div>"

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

<section class="header_posts">
    <#include 'top_nav.ftlh'>
    <div class="text-box">
        <h1>ALL POSTS</h1>
    </div>

</section>

<div class="search_form">
<form>
    <div class="title">
        Поиск по названию:
    </div>
    <div class="input_wrap">
        <input id="title" name="title" type="text" onkeyup="showResult()">
    </div>

</form>
</div>

<br>
<br>
<br>
<br>

<div id="result" >
    <#if allPosts?has_content>
    <#list allPosts as post>
            <div class="box-cards-blog">
                <div class="card">
                    <div class="card-meta">
                        <div class="card-body">
                            <h2 class="card-title"><a href="/detailPost/${post.id}/0"> ${post.title}</a>
                            </h2>

                        </div>
                        <div class="card-bottom">
                            <div class="user">
                                <span class="username">${post.accountEmail}</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</#list>
<#else>
<p class="lead">Нет статей!</p>
</#if>
</div>
</body>
</html>
