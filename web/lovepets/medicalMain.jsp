<%@ page import="com.bing.pojo.Pets" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/18
  Time: 16:28
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
    Pets pets = (Pets) session.getAttribute("pets_pets");
%>
<div class="back">
    <div class="center-record">
        <table border="0" align="center" class="input">
                <tr>
                    <td>
                        宠物名称：
                    </td>
                    <td>
                        <input type="text" name="def" value=<%=pets.getName()%>><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        类型：
                    </td>
                    <td>
                        <input type="text" name="def" value=<%=pets.getType_name()%>><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        出生日期：
                    </td>
                    <td>
                        <input type="date" name="def" value=<%=pets.getBirthDate()%>><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        所有人名称：
                    </td>
                    <td>
                        <input type="text" name="def" value=<%=pets.getOwner_name()%>>
                    </td>
                </tr>
            <tr>
                <form action="medicalHistoryServlet" method="get">
                    <td>
                        <input type="hidden" name="pet_id" value=<%=pets.getId()%>>
                        <input type="submit" value="阅览病历" align="center" class="button">
                    </td>
                </form>
                <form action="medicalAddForward" method="get">
                    <td>
                        <input type="hidden" name="pet_id" value="<%=pets.getId()%>">
                        <input type="submit" value="增加新病历" align="center" class="button">
                    </td>
                </form>
            </tr>
            <tr>
                <td>
                    <form action="petsModifyForward" method="get">
                        <input type="submit" value="修改信息" class="button">
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
