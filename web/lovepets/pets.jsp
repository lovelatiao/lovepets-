<%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/17
  Time: 15:58
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
            <form action="petsQueryServlet" method="get">
                <tr>
                    <td>
                        宠物名称：
                    </td>
                    <td>
                        <input type="text" name="pet_name"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        主人名称：
                    </td>
                    <td>
                        <input type="text" name="owner_name"><br>
                    </td>
                </tr>
                <tr>
                    <td>

                    </td>
                    <td>
                        <input type="submit" value="查询" align="center" class="button">
                    </td>
                </tr>
            </form>
            <tr>
                <td>
                    <form action="petsAddForward">
                        <input type="submit" value="增加新宠物" align="center" class="button">
                    </form>
                </td>
                <td>
                    <form action="petsOwnerAddForward">
                        <input type="submit" value="增加新所有人" align="center" class="button">
                    </form>
                </td>

            </tr>
        </table>
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
