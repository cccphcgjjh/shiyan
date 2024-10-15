<%@ page import="java.util.List" %>
<%@ page import="com.szy.pojo.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息管理后台</title>
    <style>
        table {
            border-collapse: collapse;
            font-size: 20px;
            text-align: center;
        }
        table, table tr td {
            border: 1px solid #ccc;
        }
        table tr td {
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<div style="margin-top: 50px">
    <form action="/user?hidden=findByUser" method="post">
        <table align="center">
            <tr>
                <td>
                    姓名：<input type="text" name="name1">&nbsp;&nbsp;
                    性别：<input type="text" name="sex1">&nbsp;&nbsp;
                    年龄：<input type="text" name="age1">&nbsp;&nbsp;
                    电话：<input type="text" name="phone1">&nbsp;&nbsp;
                    <input type="submit" value="查询">
                </td>
            </tr>
        </table>
    </form>
</div>
<div>
    <table align="center" width="1000">
        <tr>
            <td>序号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>性别</td>
            <td>年龄</td>
            <td>电话</td>
            <td>修改</td>
            <td>删除</td>
        </tr>
        <%
            List<User> ul = (List<User>) request.getAttribute("userList");
            if (ul != null && !ul.isEmpty()) {
                for (int i = 0; i < ul.size(); i++) {
                    User u = ul.get(i);
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getName() %></td>
            <td><%= u.getPwd() %></td>
            <td><%= u.getSex() %></td>
            <td><%= u.getAge() %></td>
            <td><%= u.getPhone() %></td>
            <td><a href="/user?hidden=findById&id=<%= u.getId() %>">修改</a></td>
            <td><a href="/user?hidden=delete&id=<%= u.getId() %>" onclick="return confirm('确定要删除吗？')">删除</a></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="8">暂无用户信息</td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="8">
                <a href="login.jsp">返回登录界面</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
