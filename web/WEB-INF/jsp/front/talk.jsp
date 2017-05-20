<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2017/5/2
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>微信公众号</title>
    <link rel="stylesheet" type="text/css" href="<%= basePath %>resources/css/jscrollpane1.css"/>
    <script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js" type="text/javascript"></script>
    <!-- the mousewheel plugin -->
    <script type="text/javascript" src="<%= basePath %>resources/js/common/jquery.mousewheel.js"></script>
    <!-- the jScrollPane script -->
    <script type="text/javascript" src="<%= basePath %>resources/js/common/jquery.jscrollpane.min.js"></script>
    <script type="text/javascript" src="<%= basePath %>resources/js/common/scroll-startstop.events.jquery.js"></script>
    <!--讨论区滚动条end-->
    <script type="text/javascript" src="<%= basePath %>resources/js/front/talk.js"></script>

</head>
<body>
<input type="hidden" value="<%= basePath %>" id="basePath"/>
<br/>
<div class="talk">
    <div class="talk_title"><span>正在与公众号聊天</span></div>
    <div class="talk_record">
        <div id="jp-container" class="jp-container">

        </div>
    </div>

    <div class="talk_word">
        &nbsp;
        <input class="add_face" id="facial" type="button" title="添加表情" value=""/>
        <input id="content" class="messages emotion"/>
        <input class="talk_send" onclick="send();" type="button" title="发送" value="发送"/>
    </div>
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';"></div>
</body>
</html>
