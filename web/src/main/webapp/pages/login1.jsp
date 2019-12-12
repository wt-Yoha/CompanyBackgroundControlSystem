<%--
  Created by IntelliJ IDEA.
  User: wtyoha
  Date: 2019/12/10
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <table style="border: 0">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
                <td><a href="${pageContext.request.contextPath}/logout">注销</a></td>
            </tr>
        </table>
    </form>
</body>
</html>
