package org.library.servlet;

import org.library.dao.BaseDao;
import org.library.entity.Operator;
import org.library.service.OperatorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by admin on 2016/12/27.
 * 更新控制员
 */
public class UpdateOperatorServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求中的数据并封装成为一个operator对象
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

        //将operator传递给服务层，进行业务处理，并返回处理信息
        OperatorService service = new OperatorService();
        String message = service.updateOperator(operator);

        //将处理处理信息写入输出流中
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(message);
    }
}
