package org.library.servlet;

import org.library.dao.OperatorDao;
import org.library.entity.Operator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by admin on 2016/12/27.
 * 添加控制员
 */
public class AddOperatorServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求中的数据，并封装成为一个类型对象
        Operator operator = new Operator();
        operator.setId(Integer.parseInt(request.getParameter("id")));
        operator.setName(request.getParameter("name"));
        operator.setSex(request.getParameter("sex"));
        operator.setAge(Integer.parseInt(request.getParameter("age")));
        //operator.setIdentityCard(request.getParameter("identityCard"));
        //operator.setWorddate(Date.valueOf(request.getParameter("worddate")));
        operator.setTel(request.getParameter("tel"));
        operator.setAdmin(Integer.parseInt(request.getParameter("admin")));
        //operator.setPassword(request.getParameter("password"));
        //operator.setVer(Integer.parseInt(request.getParameter("ver")));

        //实例化一个dao对象，并调用添加类型的方法,返回添加信息
        OperatorDao dao = new OperatorDao();
        String msg = dao.save(operator)?"添加成功":"添加失败";
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(msg);
    }
}
