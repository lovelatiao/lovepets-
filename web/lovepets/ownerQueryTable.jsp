<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bing.table.PetsTable" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 25/05/2021
  Time: 08:49
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
            <th valign="top">所属人</th>
            <th valign="top">所属人唯一id</th>
        </tr>
        <%
            ArrayList arrayList = (ArrayList) session.getAttribute("owners");
            for (int i = 0; i < arrayList.size(); i++){
                PetsTable petsTable = (PetsTable) arrayList.get(i);
        %>
        <tr>
            <form action="petsQueryOwnerServlet" method="get" id="owners_<%=petsTable.getOwner_id()%>">
                <input type="hidden" name="owner_id" value="<%=petsTable.getOwner_id()%>">
            </form>
            <td>
                <a href="javascript:void(0);" onclick="form('owners_<%=petsTable.getOwner_id()%>')"><%=petsTable.getOwner_name()%></a>
            </td>
            <td>
                <%=petsTable.getOwner_id()%>
            </td>
        </tr>
        <%}%>
    </table>
    <table border="0" style="margin: auto">
        <tr>
            <td>
                <form action="ownerQueryForward" method="get">
                    <input class="button" type="submit" value="重新查询">
                </form>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    function form(id) {
        document.getElementById(id).submit();
    }
</script>
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
