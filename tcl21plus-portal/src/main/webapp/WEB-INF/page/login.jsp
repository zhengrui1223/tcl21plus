<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/12/21
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" name="loginForm" action="/doLogin">
        <div style="text-align: center">
            <label>用户名:</label>
            <input type="text" name="name" value="<%= request.getAttribute("name")==null?"":request.getAttribute("name") %>">
        </div>

        <div style="text-align: center">
            <label>密码:</label>
            <input type="password" name="password" value="<%= request.getAttribute("password")==null?"":request.getAttribute("password")%>">
        </div>

        <div style="text-align: center">
            <label>密码1:</label>
            <input type="text" name="password1" value="<%= request.getAttribute("password")==null?"":request.getAttribute("password")%>">
        </div>

        <div style="text-align: center">
            <input type="submit" name="submit" value="提交">
        </div>
    </form>
</body>
</html>
