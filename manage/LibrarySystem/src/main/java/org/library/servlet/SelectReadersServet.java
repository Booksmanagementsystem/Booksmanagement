package org.library.servlet;

import com.google.gson.Gson;
import org.library.dao.ReadersDao;
import org.library.entity.Readers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2016/12/27.
 * 根据读者姓名查询读者信息
 */
public class SelectReadersServet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用名
        String name = (String) request.getSession().getAttribute("name");
        Readers readers = new Readers();
        readers.setName(name);

        //实例化一个dao对象，并调用根据用户名查询用户信息的方法
        ReadersDao dao = new ReadersDao();
        Readers readers1= dao.findReadersByReaderName(readers);

        //将users对象转换成json字符串，并将json字符串放入输出流中
        String json = new Gson().toJson(readers);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
    }
}
