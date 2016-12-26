<%--
  Created by IntelliJ IDEA.
  User: xlch
  Date: 2016/12/18
  Time: 7:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
  <div>
    <form action="/upload" method="post" enctype="multipart/form-data">
      <input type="file" name="file" value="选择文件">
      <button type="submit">提交</button>
    </form>
  </div>
  </body>
</html>
