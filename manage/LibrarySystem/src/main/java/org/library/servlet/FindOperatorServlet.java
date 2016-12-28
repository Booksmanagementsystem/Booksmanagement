package org.library.servlet;

import com.google.gson.Gson;
import org.library.dao.OperatorDao;
import org.library.entity.Operator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2016/12/28.
 * 根据控制员的Id和乐观锁版本号查询控制员信息
 */
public class FindOperatorServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要改变的状态
        int id = Integer.parseInt(request.getParameter("id"));
        int ver = Integer.parseInt(request.getParameter("ver"));
        Operator operator = new Operator();
        operator.setId(id);
        operator.setVer(ver);
        System.out.println(ver);
        OperatorDao dao = new OperatorDao();
        Operator operator1 = dao.findOperatorByIdAndVer(operator);

        //将newType对象转化成json字符串，并写入输出流中
        String json = new Gson().toJson(operator1);

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);

    }
}
