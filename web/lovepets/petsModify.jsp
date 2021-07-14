<%@ page import="java.util.ArrayList" %>
<%@ page import="com.bing.pojo.Pets" %><%--
  Created by IntelliJ IDEA.
  User: lala
  Date: 2021/5/18
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物信息修改</title>
</head>
<link href="all.css" type="text/css" rel="stylesheet">
<body>
<div>
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

    <div class="center">
        <table>
            <form action="petsModifyServlet" method="get">
                <tr>
                    <td>
                        宠物名称：
                    </td>
                    <td>
                        <input type="hidden" name="pet_id" value="<%=pets.getId()%>">
                        <input type="text" name="name" value="<%=pets.getName()%>">
                    </td>
                <tr>
                    <td>
                        类型：
                    </td>
                    <td>
                        <select name="type" >
                            <%
                                ArrayList arrayList = (ArrayList) session.getAttribute("type");
                                for (int i = 0; i < arrayList.size(); i++) {
                                    if(arrayList.get(i).equals(pets.getType_name())){

                            %>
                            <option selected value="<%=arrayList.get(i)%>"><%=arrayList.get(i)%>
                            </option>
                            <%}else{%>
                            <option value="<%=arrayList.get(i)%>"><%=arrayList.get(i)%>
                            </option>
                            <%}}%>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td>
                        出生日期：
                    </td>
                    <td>
                        <input type="date" name="birth_date" value="<%=pets.getBirthDate()%>">

                    </td>
                </tr>
                <tr>
                    <td>
                        所有人名称：
                    </td>
                    <td>
                        <input type="text" name="owner_name" value="<%=pets.getOwner_name()%>">

                    </td>
                </tr>
                <tr>
                    <td>
                        所有人唯一id：
                    <td>
                        <input type="text" name="owner_id" value="<%=pets.getOwnerId()%>">

                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="修改" class=button">
                    </td>
            </form>
            <form action="medicalMainForward" method="get">
                <td>
                    <input type="submit" value="放弃" class="button">
                </td>
            </form>
            </tr>
        </table>
    </div>
</div>
<p class="message">
    <a href="ownerQueryForward" target="_blank">查询所有人id</a>
</p>
</body>
</html>
