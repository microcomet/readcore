$(document).ready(getNovel);
var article = {};
var count = 0;
function getNovel() {
    try{
    var i = 0;
    article.content = [];
    $("#list dd").has("a").each(function () {
        i++;
        var lin = $(this).find("a").get(0);
        var chapterUrl = lin.href;
        var chapterName = lin.innerText;
        article.content[i - 1] = {"id": i, "chapterUrl": chapterUrl, "chapterName": chapterName};
        loadHtml(article.content[i - 1]);
    });
    article.articleName = $("#info h1").text();
    console.log(article);
    } catch (error) {
        console.log("getNovel",error);
    }
}

var t = setInterval("periodDefect()", 15000);

var periodDefect = function() {
    try {
    console.log("record:  ",article.content.length, count);
    if (article.content.length == count) {
        console.log(article);
        if (t != null) clearInterval(t);
        $.ajax({
            type: "post",
            data: JSON.stringify(article),
            contentType:"application/json",
            dataType:"json",
            url: "http://localhost:8080/readcore/pages/novel/saveOneArticle.req",
            beforeSend:function(xhr){
                xhr.setRequestHeader("Origin","http://www.biquge.la");
            },
            success: function (ret_data) {
                console.log("SUCCESS");
            },
            error: function (error) {
                console.log("FAILED");
            }
        });
    }
    } catch (error) {
        console.log("periodDefect",error);
    }
}

function loadHtml(chapter) {
    try {
    $.ajax({
        type: "GET",
        dataType: "html",
        url: chapter.chapterUrl,
        success: function (ret_data) {
            var chapterHtml = $(ret_data);
            var chapterContent = chapterHtml.find("#content").get(0).innerText;
            article.content[chapter.id - 1].content = chapterContent;
            count++;
            //console.log(count);
        },
        error: function (xhr) {
            count++;
        }
    });
    } catch (error) {
        console.log("loadHtml",error);
    }
}