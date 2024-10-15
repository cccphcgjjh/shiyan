<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/9/15
  Time: 0:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
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
    <div style-top="margin: 20px:">
        <form action="/user" method="post">
            <table align="cebter" style="width:400px;height: 250px">
                <tr>
                    <td colspan="2">登录界面</td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="name" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="text" name="name" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="name" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td><input type="text" name="name" style="width: 248px;height:30px;"></td>
                </tr>
                <input type="hidden" value="insert" name="hidden">
                <tr>
                    <td colspan="2">
                        <a href="insert.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="login.jsp">登录</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
