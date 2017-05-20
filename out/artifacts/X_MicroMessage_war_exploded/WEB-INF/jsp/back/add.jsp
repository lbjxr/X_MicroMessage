<%--
  Created by IntelliJ IDEA.
  User: x
  Date: 2017/5/3
  Time: 下午9:09
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>内容修改页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link href="<%=basePath%>resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <script src="<%=basePath%>resources/js/common/jquery.jscrollpane.min.js"></script>


</head>
<body>
<div class="container">
    <form class="form-horizontal" action="<%=basePath%>Add.action">
        <fieldset>
            <div id="legend" class="">
                <legend class="">内容修改</legend>
            </div>
            <div class="control-group">

                <!-- Text input-->

                <div class="controls">
                    <label class="control-label">指令:</label>
                    <input type="text" class="input-xlarge" name="command" value="${command}">
                </div>
            </div>

            <div class="control-group">

                <!-- Text input-->

                <div class="controls">
                    <label class="control-label">描述:</label>
                    <input type="text" class="input-xlarge" name="description" value="${description}">
                </div>
            </div>

            <div class="control-group">
                <!-- Textarea -->
                <br/>
                <div class="controls">
                    <div class="textarea">
                        <label class="control-label">内容:</label>
                        <textarea type="" class="" name="content"> </textarea>
                    </div>
                </div>
                <input type="submit" name="submit" value="添加">
            </div>

        </fieldset>
    </form>
</div>
</body>
</html>