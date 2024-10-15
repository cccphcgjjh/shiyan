<%@ page import="com.szy.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/9/15
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <style>
        table{
            border-collapse: collapse;
            font-size: 26px;
            text-align: center;
        }
        table,table tr td{
            border: 1px solid #ccc;
        }
        table tr td{
            padding: 5px 10px;
        }
    </style>
</head>
<body>
    <%
        User user = (User) request.getAttribute("user");
    %>
    <div style="margin-top: 20px">
        <form action="/user" method="post">
            <table align="center" style="width: 400px;height: 250px">
                <tr>
                    <td colspan="2">修改用户信息</td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name" value="<%=user.getName()%>" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="pwd" value="<%=user.getPwd()%>" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="text" name="sex" value="<%=user.getSex()%>" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="age" value="<%=user.getAge()%>" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td><input type="text" name="phone" value="<%=user.getPhone()%>" style="width: 248px;height:30px;"></td>
                </tr>
                <input type="hidden" value="update" name="hidden">
                <input type="hidden" value="<%=user.getId()%>" name="id">
                <tr>
                    <td colspan="2">
                        <input type="submit" value="修改" style="width: 100px;font-size: 18px">&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/user?hidden=findAll">返回</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
