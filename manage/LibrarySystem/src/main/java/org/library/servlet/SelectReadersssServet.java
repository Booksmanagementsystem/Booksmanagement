package org.library.servlet;

import com.google.gson.Gson;
import org.library.dao.ReadersDao;
import org.library.entity.Readers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 * 查询所有读者信息
 */
public class SelectReadersssServet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReadersDao dao = new ReadersDao();
        List<Readers> list2 = dao.findAll(Readers.class);
        String json = new Gson().toJson(list2);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
    }
}
