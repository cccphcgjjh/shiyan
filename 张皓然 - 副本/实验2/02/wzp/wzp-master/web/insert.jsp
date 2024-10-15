<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/9/15
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户信息</title>
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
    <div>
        <form action="/user" method="post">
            <table align="center" style="width: 400px;height: 250px">
                <tr>
                    <td colspan="2">添加用户信息</td>
                    <input type="hidden" value="insert" name="hidden">
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="pwd" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td><input type="text" name="sex" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" name="age" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td><input type="text" name="phone" style="width: 248px;height:30px;"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="添加" style="width: 100px;font-size: 18px">&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="login.jsp">返回登录界面</a></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
