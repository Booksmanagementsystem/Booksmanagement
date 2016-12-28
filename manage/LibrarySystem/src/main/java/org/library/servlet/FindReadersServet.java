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
 * 根据读者的姓名和乐观锁版本号查询读者信息
 */
public class FindReadersServet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要改变的状态
        String name = request.getParameter("name");
        int ver = Integer.parseInt(request.getParameter("ver"));
        Readers readers = new Readers();
        readers.setName(name);
        readers.setVer(ver);
        System.out.println(ver);
        ReadersDao dao = new ReadersDao();
        Readers readers1 = dao.findReadersByNameAndVer(readers);

        //将newType对象转化成json字符串，并写入输出流中
        String json = new Gson().toJson(readers1);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);

    }
}
