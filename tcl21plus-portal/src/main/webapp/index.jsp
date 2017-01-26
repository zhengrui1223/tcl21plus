<%@ taglib prefix="cc" uri="http://www.hello.tag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <cc:hello key="zhengrui"></cc:hello>
    </div>
    <div style="text-align: center">
        <table border="1px" align="center">
            <c:forEach items="1,2" var="var">
                <tr>
                    <td>hel</td>
                    <c:forEach items="1,2,3,4" var="var">
                        <td>${var}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
