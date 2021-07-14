<%@ page import="com.bing.pojo.Pets" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/17
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>病历</title>
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
    Pets pets = (Pets) session.getAttribute("pets_pets");
%>
<div class="back">
    <div class="center-record">
        <table border="0" align="center" class="input">
            <form action="medicalAddServlet">
                <tr>
                    <td>
                        宠物名称：
                    </td>
                    <td>
                        <input type="text" name="username" value="<%=pets.getName()%>"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        所有人名称：
                    </td>
                    <td>
                        <input type="text" name="password" value="<%=pets.getOwner_name()%>"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        类型：
                    </td>
                    <td>
                        <input type="text" name="password" value="<%=pets.getType_name()%>"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        出生日期：
                    </td>
                    <td>
                        <input type="date" name="username" value="<%=pets.getBirthDate()%>"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        描述：
                    </td>
                    <td>
                        <textarea rows="10" cols="20" name="description" >
                        </textarea>
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
