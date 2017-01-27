<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/12/23
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.movit.study.model.User" %>
<html>
<head>
    <title>Title</title>
    <%
        User u = new User();
        u.setId(1);
        u.setName("zhengrui");
        u.setPassWord("123456");
    %>
    <jsp:useBean id="user" class="com.movit.study.model.User" scope="page"/>
    <jsp:setProperty name="user" property="name" value="zhengrui"/>
</head>
<body>
    <form>
        <div style="text-align: center">

            <table border="1px" align="center">
                <tr>
                    <th>访问方式</th>
                    <th width="80px">所得的值</th>
                </tr>
                <tr>
                    <td>\${nameRequest}</td>
                    <td width="80px">${nameRequest}</td>
                </tr>
                <tr>
                    <td>\${pageContext.request.getAttribute("nameRequest")}</td>
                    <td>${pageContext.request.getAttribute("nameRequest")}</td>
                </tr>
                <tr>
                    <td>\${requestScope.nameRequest}</td>
                    <td>${requestScope.nameRequest}</td>
                </tr>
                <tr>
                    <td>\${header["Content-Type"]}</td>
                    <td>${header["Content-Type"]}</td>
                </tr>
                <tr>
                    <td>\${header.host}</td>
                    <td>${header.host}</td>
                </tr>
                <tr>
                    <td>\${header['Accept-Language']}</td>
                    <td>${header['Accept-Language']}</td>
                </tr>
                <tr>
                    <td>\${initParam.contextConfigLocation}</td>
                    <td>${initParam.contextConfigLocation}</td>
                </tr>
                <tr>
                    <td>\${cookie.name}</td>
                    <td>${cookie.name.value}</td>
                </tr>
                <tr>
                    <td>\${sessionScope.nameSession}</td>
                    <td>${sessionScope.nameSession}</td>
                </tr>
                <tr>
                    <td>\${pageContext.session.getAttribute("nameSession")}</td>
                    <td>${pageContext.session.getAttribute("nameSession")}</td>
                </tr>
                <tr>
                    <td>\${pageContext.servletContext.getAttribute("nameServletContext")}</td>
                    <td>${pageContext.servletContext.getAttribute("nameServletContext")}</td>
                </tr>
                <tr>
                    <td>\${pageScope.user.name}</td>
                    <td>${pageScope.user.name}</td>
                </tr>
                <tr>
                    <td>\${pageScope.u.name}</td>
                    <td>${pageScope.u.name}</td>
                </tr>

            </table>
        </div>
    </form>
</body>
</html>
