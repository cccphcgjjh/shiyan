package com.szy.controller;

import com.szy.pojo.User;
import com.szy.service.UserService;
import com.szy.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");

        String hidden = request.getParameter("hidden");

        if ("insert".equals(hidden)) {
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String phone = request.getParameter("phone");

            if (name.isEmpty() || pwd.isEmpty() || sex.isEmpty() || age.isEmpty() || phone.isEmpty()) {
                out.print("<script>alert('请输入完整信息:');location='insert.jsp'</script>");
                return;
            }

            User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            user.setSex(sex);
            user.setAge(age);
            user.setPhone(phone);

            if (userService.isInsert(name)) {
                if (userService.insert(user) > 0) {
                    out.print("<script>alert('注册成功');location='login.jsp'</script>");
                } else {
                    out.print("<script>alert('注册失败');location='insert.jsp'</script>");
                }
            } else {
                out.print("<script>alert('用户名已存在,请重新注册');location='insert.jsp'</script>");
            }
        } else if ("login".equals(hidden)) {
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");

            User user = new User();
            user.setName(name);
            user.setPwd(pwd);

            if (userService.login(user)) {
                request.getSession().setAttribute("userSession", user);
                out.print("<script>alert('登录成功');location='user?hidden=findAll'</script>");
            } else {
                out.print("<script>alert('登录失败');location='login.jsp'</script>");
            }
        } else if ("findAll".equals(hidden)) {
            List<User> list = userService.findAll();
            if (!list.isEmpty()) {
                request.setAttribute("userlist", list);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } else {
                out.print("<script>alert('暂无用户信息');location='user?hidden=insert'</script>");
            }
        } else if ("delete".equals(hidden)) {
            String id = request.getParameter("id");
            if (userService.delete(Integer.parseInt(id)) > 0) {
                out.print("<script>alert('删除成功');location='user?hidden=findAll'</script>");
            } else {
                out.print("<script>alert('删除失败');location='user?hidden=findAll'</script>");
            }
        } else if ("findById".equals(hidden)) {
            String id = request.getParameter("id");
            User user = userService.findById(Integer.parseInt(id));
            if (user != null) {
                request.setAttribute("user1", user);
                request.getRequestDispatcher("update.jsp").forward(request, response);
            } else {
                out.print("暂无此用户信息");
            }
        } else if ("update".equals(hidden)) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            String sex = request.getParameter("sex");
            String age = request.getParameter("age");
            String phone = request.getParameter("phone");

            if (name.isEmpty() || pwd.isEmpty() || sex.isEmpty() || age.isEmpty() || phone.isEmpty()) {
                out.print("<script>alert('请输入完整信息:');location='user?hidden=findAll'</script>");
                return;
            }

            User user = new User();
            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setPwd(pwd);
            user.setSex(sex);
            user.setAge(age);
            user.setPhone(phone);

            if (userService.update(user) > 0) {
                out.print("<script>alert('修改成功');location='user?hidden=findAll'</script>");
            } else {
                out.print("<script>alert('修改失败');location='user?hidden=findAll'</script>");
            }
        } else if ("findByUser".equals(hidden)) {
            String name1 = request.getParameter("name1");
            String sex1 = request.getParameter("sex1");
            String age1 = request.getParameter("age1");
            String phone1 = request.getParameter("phone1");

            User user1 = new User();
            user1.setName(name1);
            user1.setSex(sex1);
            user1.setAge(age1);
            user1.setPhone(phone1);

            List<User> list = userService.findByUser(user1);
            if (!list.isEmpty()) {
                request.setAttribute("userlist", list);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } else {
                out.print("<script>alert('暂无此用户信息');location='user?hidden=findAll'</script>");
            }
        }
    }
}
