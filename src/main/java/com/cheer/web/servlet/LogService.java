package com.cheer.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogService", urlPatterns = "/servlet/LogService")
public class LogService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求编码格式:
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");
        //获取请求信息
        String uname=req.getParameter("uname");
        //uname=new String(uname.getBytes("iso8859-1"),"utf-8");//使用String进行数据重新编码
        String pwd=req.getParameter("pwd");
        System.out.println(uname+":"+pwd);
        //响应处理结果
        if("zhangsan".equals(uname)&"123".equals(pwd)){
            resp.getWriter().write("登录成功");
            resp.sendRedirect("../jquery-02.html");
        }else{
            resp.getWriter().write("登录失败");
        }

    }
}
