<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2024/9/15
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
    <style>
        table{
            border-collapse: collapse;
            font-size: 26px;
            width: 450px;
            height: 250px;
            text-align: center;
        }
        table,table tr td{
            border: 1px solid #ccc;
        }
        table tr td{
            padding: 5px 10px;
        }
        .container{
            margin-top: 150px;
        }
        input{
            width: 248px;
            height: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="/user" method="post">
            <table align="center">
                <tr align="center">
                    <td colspan="2">欢迎登录</td>
                </tr>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="name" ></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="text" name="pwd"></td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="insert.jsp">注册新用户</a>
                        <input type="hidden" value="login" name="hidden">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
