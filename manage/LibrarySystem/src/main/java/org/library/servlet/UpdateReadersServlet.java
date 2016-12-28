package org.library.servlet;

import org.library.dao.BaseDao;
import org.library.entity.Readers;
import org.library.service.ReadersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by admin on 2016/12/27.
 * 更新读者
 */
public class UpdateReadersServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求中的数据并封装成为一个readers对象
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
        readers.setISBN(request.getParameter("ISBN"));
        readers.setBztime(Date.valueOf(request.getParameter("bztime")));
        //readers.setVer(Integer.parseInt(request.getParameter("ver")));
        //readers.setPassword(request.getParameter("password"));

        //将readers传递给服务层，进行业务处理，并返回处理信息
        ReadersService service = new ReadersService();
        String message = service.updateReaders(readers);
        //将处理处理信息写入输出流中
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(message);
    }
}
