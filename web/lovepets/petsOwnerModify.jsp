<%@ page import="com.bing.pojo.Owners" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/19
  Time: 8:06
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
<%
    Owners owners = (Owners)session.getAttribute("owners");
    System.out.println(owners.getName());
%>
<div class="back">
    <div class="center">
        <table border="0" align="center" class="input">
            <form action="petsOwnerModifyServlet" method="get">
                <tr>
                    <td>
                        <input type="hidden" name="id" value=<%=owners.getId()%>>
                        所有人名称：
                    </td>
                    <td>
                        <input type="text" name="name" value=<%=owners.getName()%>><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        地址：
                    </td>
                    <td>
                        <input type="text" name="address" value=<%=owners.getAddress()%>><br>
                    </td>
                </tr><tr>
                <td>
                    城市：
                </td>
                <td>
                    <input type="text" name="city" value=<%=owners.getCity()%>><br>
                </td>
            </tr>
                <tr>
                    <td>
                        电话号码：
                    </td>
                    <td>
                        <input type="text" name="telephone" value=<%=owners.getTelephone()%>><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="修改" align="center" class="button">
                    </td>
            </form>
            <form action="petsQueryForward" method="get">
                    <td>
                            <input type="submit" value="放弃" align="center" class="button">
                    </td>
            </form>
                </tr>

        </table>

    </div>
</div>
</body>
</html>
