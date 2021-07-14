<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/17
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>爱心宠物医院</title>
</head>
<link href="all.css" type="text/css" rel="stylesheet">
<body>
<div class="header">
    <h1>爱心宠物诊所管理系统</h1>
</div>
<%--登录--%>
<div class="back">
    <div class="center">
        <form action="loginServlet" method="post">
            <table border="0" align="center" class="input">
                <tr>
                    <td>
                        用户名：
                    </td>
                    <td>
                        <input type="text" name="name"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        密码：
                    </td>
                    <td>
                        <input type="password" name="password"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="登录" class="button">
                    </td>
                    <td>
                        <input type="reset" value="重置" class="button">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
