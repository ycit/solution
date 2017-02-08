<%--
  Created by IntelliJ IDEA.
  User: xlch
  Date: 2016/12/4
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="${ctx}/js/lib/bootstrap-3.3.0/bootstrap.css" rel="stylesheet" type="text/css">
    <%--<script type="text/javascript" src="${ctx}/js/lib/jquery/jquery-3.1.1.min.js"></script>--%>
    <%--<script type="text/javascript" src="${ctx}/js/lib/bootstrap-3.3.0/bootstrap.min.js"></script>--%>
    <title>home</title>
</head>
<body>

      <h2 id="h2">welcome to home page</h2>
      <img src="${ctx}/static/images/lock.png"/>
      <div></div>
      <table class="table">
          <thead>
          <tr>
              <td>姓名</td>
              <td>邮箱</td>
              <td>日期</td>
              <td>操作</td>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="user" items="${users}">
              <tr>
                  <td>${user.name}</td>
                  <td>${user.email}</td>
                  <td>${user.createTime}</td>
                  <td><button class="btn" data-click="delete">删除</button></td>
              </tr>
          </c:forEach>
          </tbody>
      </table>
</body>
<script src="${ctx}/js/require.js" data-main="${ctx}/js/app/home.js"></script>
</html>
