<%--
  Created by IntelliJ IDEA.
  User: xlch
  Date: 2017/7/30
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <style type="text/css">

        #login-page{
            padding: 120px 0;
        }
        #login-page form,  form {
            width: 280px;
        }
        #login-page form h3 {
            font-size: 25px;
            font-weight: 300;
            color: #666;
        }
        #login-page form input[type=text], #login-page form input[type=password],  form input[type=password] {
            padding: 10px 10px!important;
            height: auto!important;
            font-size: 16px;
        }
        #login-page .login-icon,  .login-icon {
            text-align: center;
            margin-bottom: 28px;
        }
        #login-page .controls,  .controls {
            margin-top: 10px;
        }
        .input-block-level {
            -moz-box-sizing: border-box;
            display: block;
            min-height: 30px;
            width: 100%;
        }
        .centered-form {
            margin: 0 auto;
        }

        #download {
            margin: 5px 0;
            padding: 15px 0;
            font-size: 95%;
            text-align: center;
        }
        body {
            background:url('${ctx}/static/images/bg.jpg') fixed no-repeat;
            background-size: cover;
        }


        #login-page form h3 {
            font-size: 28px;
            color: #070b1f;
            font-weight: bold;
        }

        #login-page {
            display: table;
            position: absolute;
            width: 100%;
            height: 100%;
        }

        #login-form {
            display: inline-block;
            background: rgba(223,223,223,.7);
            width: 100%;
        }

        #login-page .login-bar {
            vertical-align: middle;
            opacity: 0.9;
            display: table-cell;
        }

    </style>
</head>
<body>
<div id="login-page">
    <div class="login-bar">
        <div id="login-form">
            <form class="centered-form">
                <div class="login-icon">
                    <h3>潍坊市公安局<br>预测警务系统(PPS)</h3>
                </div>
                <div id="message" class="alert alert-danger hide"></div>
                <div class="control-group">
                    <div class="controls">
                        <input type="text" id="username" class="input-block-level" placeholder="用户名" />
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="password" id="password" class="input-block-level" placeholder="密码" />
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="button" id="loginbtn" name="save" value="登录" class="btn btn-primary btn-lg btn-block" />
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
