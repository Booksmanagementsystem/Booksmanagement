package org.library.service;

import org.library.dao.ReadersDao;
import org.library.entity.Readers;
import org.library.util.HibernateUtil;

import javax.persistence.EntityManager;

/**
 * Created by admin on 2016/12/27.
 */
public class ReadersService {
    //更新数据
    public String updateReaders(Readers readers){
        ReadersDao dao = new ReadersDao();
        //1、判断该用户信息中途是否被修改
        //如果没有被修改，则调用修改I数据的方法
        //否则返回“用户信息已被修改，刷新页面重新操作！”
        if(dao.findReadersByNameAndVer(readers) != null){
            dao.update(readers);
            return "修改成功！";
        }
        return "用户信息已被修改，刷新页面重新操作！";
    }
    //删除读者
    public String deleteReaders(String name){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        ReadersDao dao = new ReadersDao();
        String message = null;
        try{
            dao.deleteReaders(em,name);
            em.getTransaction().commit();
            message = "删除成功！";
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            message = "删除失败！";
        }finally{
            em.close();
        }
        return message;
    }
}
