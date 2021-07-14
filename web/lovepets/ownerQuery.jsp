<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 25/05/2021
  Time: 08:38
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
        <form action="ownerQueryServlet" method="get">
            <table border="0" align="center" class="input">
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
                        <input type="submit" value="查询" align="center" class="button">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<p class="message">
    <%
        if(session.getAttribute("message") == null){
            return;
        }else{
            out.print(session.getAttribute("message"));
            session.setAttribute("message",null);
        }
    %>
</p>
</body>
</html>
