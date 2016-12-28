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
 *根据控制员名字查询控制员信息
 */
public class SelectOperatorServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用名
        String name = (String) request.getSession().getAttribute("name");
        Operator operator = new Operator();
        operator.setName(name);

        //实例化一个dao对象，并调用根据控制员名查询用户信息的方法
        OperatorDao dao = new OperatorDao();
        Operator operator1= dao.findOperatorByOperatorName(operator);

        //将users对象转换成json字符串，并将json字符串放入输出流中
        String json = new Gson().toJson(operator);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
    }
}
