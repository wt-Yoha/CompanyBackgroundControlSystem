<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wtyoha
  Date: 2019/11/14
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>功能调试页面</title>
</head>
<body>
<h3>控制器跳转成功，处理返回结果:</h3><br/>
<c:forEach items="${requestScope.resultList}" var="i">
    <span>${i.productName}</span><br/>
</c:forEach>

</body>
</html>
