package org.library.servlet;

import org.library.dao.ReadersDao;
import org.library.entity.Readers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by admin on 2016/12/27.
 * 添加读者
 */
public class AddReadersServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求中的数据，并封装成为一个类型对象
        Readers readers = new Readers();
        readers.setName(request.getParameter("name"));
        readers.setSex(request.getParameter("sex"));
        readers.setAge(Integer.parseInt(request.getParameter("age")));
        //readers.setIdentityCard(request.getParameter("identityCard"));
        //readers.setDate(Date.valueOf(request.getParameter("date")));
        //readers.setMaxNum(Integer.parseInt(request.getParameter("maxNum")));
        readers.setTel(request.getParameter("tel"));
        //readers.setKeepMoney(Double.parseDouble(request.getParameter("keepMoney")));
        //readers.setZj(Integer.parseInt(request.getParameter("zj")));
        readers.setZy(request.getParameter("zy"));
        //readers.setISBN(request.getParameter("ISBN"));
        //readers.setBztime(Date.valueOf(request.getParameter("bztime")));
        //readers.setVer(Integer.parseInt(request.getParameter("ver")));

        //实例化一个dao对象，并调用添加类型的方法,返回添加信息
        ReadersDao dao = new ReadersDao();
        String msg = dao.save(readers)?"添加成功":"添加失败";
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(msg);
    }
}
