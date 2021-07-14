<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/17
  Time: 16:18
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

<div class="topnav">
    <a href="vetForward">兽医</a>
    <a href="petsForward">宠物</a>
    <a href="outServlet">退出</a>
</div>

<div class="back">
    <div class="center">
        <table border="0" align="center" class="input">
            <form action="petsOwnerAddServlet" method="get">
                <tr>
                    <td>
                        所有人名称：
                    </td>
                    <td>
                        <input type="text" name="name"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        地址：
                    </td>
                    <td>
                        <input type="text" name="address"><br>
                    </td>
                </tr><tr>
                <td>
                    城市：
                </td>
                <td>
                    <input type="text" name="city"><br>
                </td>
            </tr>
                <tr>
                    <td>
                        电话号码：
                    </td>
                    <td>
                        <input type="text" name="telephone"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="增加" align="center" class="button">
                    </td>
                    <td>
                        <input type="reset" value="重置" align="center" class="button">
                    </td>
                </tr>
            </form>

        </table>

    </div>
</div>
</body>
</html>
