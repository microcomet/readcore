var bk_article = null;
var article = {};
article.content = [];
chrome.tabs.onUpdated.addListener(function (tabId, changeInfo, tab) {
    if (tab.url.indexOf("http://www.biquge.la/") != -1) {
        console.log(tabId);
        chrome.pageAction.show(tabId);
    } else {
        chrome.pageAction.hide(tabId);
    }
});

chrome.runtime.onMessage.addListener(function (message, sender, response) {
    //if ("novel" == message.type) {
    //    bk_article = message.data;
    //}
    //article.articleName = bk_article.articleName;
    //response({status: "ok"});
    //var i = 0;
    //for (; i < bk_article.length; i++) {
    //    loadHtml(bk_article.chapters[i]);
    //}
    //if("article" == message.type) {
    //    $.ajax({
    //        type: "post",
    //        data: JSON.stringify(message.data),
    //        dataType:"JSON",
    //        contentType:"application/json",
    //        url: "http://localhost:8080/readcore/pages/novel/saveOneArticle.req",
    //        success: function (ret_data) {
    //            console.log(ret_data);
    //        },
    //        error: function (error) {
    //            console.log(error);
    //        }
    //    });
    //}
});

//var t = null;
//
//function periodDefect() {
//    if (bk_article != null && (article.content.length == bk_artile.length)) {
//        if (t != null) clearTimeout(t);
//        $.ajax({
//            type: "post",
//            data: article,
//            url: "http://localhost:8080/readcore/pages/novel/saveOneArticle.req",
//            success: function (ret_data) {
//                console.log(ret_data);
//            },
//            error: function (error) {
//                console.log(error);
//            }
//        });
//    }
//    t = setTimeout("periodDefect", 15000);
//}