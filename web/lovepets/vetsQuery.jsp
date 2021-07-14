<%@ page import="com.bing.pojo.Vets" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bing.table.VetsTable" %><%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2021/5/18
  Time: 11:05
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
    <table   border="1" class="query">
        <tr valign="top">
            <th valign="top">兽医名称</th>
            <th valign="top">专业</th>
        </tr>
        <%

            ArrayList arrayList = (ArrayList) session.getAttribute("vets");

            for (int i = 0; i < arrayList.size(); i++) {
                VetsTable vetsTable = (VetsTable) arrayList.get(i);
        %>
        <tr>
            <td>
                <%=vetsTable.getName()%>
            </td>
            <td>
                <%=vetsTable.getSpecialty()%>
            </td>
        </tr>
        <%}%>
    </table>
    <table border="0" style="margin: auto">
        <tr>
            <td>
                <form action="vetForward" method="get">
                    <input class="button" type="submit" value="重新查询">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
