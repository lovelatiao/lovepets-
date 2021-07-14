<%@ page import="com.bing.pojo.Pets" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bing.pojo.Visits" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/18
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>病历历史</title>
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
<div>
    <table border="0" class="input2">
        <tr>
            <td>宠物名称</td>
            <td><input type="text" name="" value="<%=pets.getName()%>"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="" value="<%=pets.getType_name()%>"></td>
        </tr>
        <tr>
            <td>所有人名称</td>
            <td><input type="text" name="" value="<%=pets.getOwner_name()%>"></td>
        </tr>
    </table>

    <table border="1" class="query">
        <tr>
            <th valign="top">诊断时间</th>
            <th valign="top">备注</th>
        </tr>
        <%
            ArrayList arrayList = (ArrayList) session.getAttribute("medical");
            Visits visits = null;
            for (int i = 0; i < arrayList.size(); i++) {
            visits = (Visits) arrayList.get(i);

        %>
        <tr>
            <td>
                <%=visits.getVisitDate()%>
            </td>
            <td>
                <%=visits.getDescription()%>
            </td>
        </tr>
        <%}%>
    </table>
    <table border="0" style="margin: auto">
        <tr>
            <td><a href="medicalMainForward">返回</a></td>
        </tr>
    </table>
</div>
</body>
</html>
