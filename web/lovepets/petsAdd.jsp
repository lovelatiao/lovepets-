<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/17
  Time: 16:24
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
            <form action="petsAddServlet" method="get">
                <tr>
                    <td>
                        宠物名称：
                    </td>
                    <td>
                        <input type="text" name="name"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        类型：
                    </td>
                    <td>
                        <select name="type" >
                            <%
                                ArrayList arrayList = (ArrayList) session.getAttribute("type");
                                for (int i = 0; i < arrayList.size(); i++) {
                            %>
                            <option value="<%=arrayList.get(i)%>"><%=arrayList.get(i)%></option>
                            <%}%>
                        </select>
                    </td>
                </tr><tr>
                <td>
                    出生日期：
                </td>
                <td>
                    <input type="date" name="birthday"><br>
                </td>
            </tr>
                <tr>
                    <td>
                        所有人名称：
                    </td>
                    <td>
                        <input type="text" name="owner_name"><br>
                    </td>
                </tr>
                <tr>
                    <td>
                        所有人唯一id：
                    </td>
                    <td>
                        <input type="text" name="owner_id"><br>
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
<p class="message">
    <a href="ownerQueryForward" target="_blank">查询所有人id</a>
</p>
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
