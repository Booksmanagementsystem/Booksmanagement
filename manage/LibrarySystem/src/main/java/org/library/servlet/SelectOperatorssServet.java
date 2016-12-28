package org.library.servlet;

import com.google.gson.Gson;
import org.library.dao.OperatorDao;
import org.library.entity.Operator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2016/12/28.
 * 查询所有控制员信息
 */
public class SelectOperatorssServet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OperatorDao dao = new OperatorDao();
        List<Operator> list2 = dao.findAll(Operator.class);
        String json = new Gson().toJson(list2);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
    }
}
