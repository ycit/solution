<%--
  Created by IntelliJ IDEA.
  User: xlch
  Date: 2016/12/27
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>文件上传</title>
    <link href="${ctx}/plugins/bootstrap-3.3.0/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${ctx}/jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/bootstrap-3.3.0/bootstrap.min.js"></script>
</head>
<body>
     <h2>htmlparser 解析 html</h2>
     <div>
         <form class="form-inline" role="form" action="${ctx}/api/file/upload/htmlparser" enctype="multipart/form-data" method="post">
             <div class="form-group">
                 <input type="file" name="file">
             </div>
             <div class="form-group">
                 <button class="btn btn-primary" type="submit">提交</button>
             </div>
         </form>
     </div>

     <h2>jsoup 解析 html</h2>
     <div>
         <form class="form-inline" role="form" action="${ctx}/api/file/upload/jsoup" enctype="multipart/form-data" method="post">
             <div class="form-group">
                 <input type="file" name="file">
             </div>
             <div class="form-group">
                 <button class="btn btn-primary" type="submit">提交</button>
             </div>
         </form>
     </div>

</body>
</html>
