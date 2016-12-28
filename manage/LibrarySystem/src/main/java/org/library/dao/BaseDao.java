package org.library.dao;

import org.library.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by admin on 2016/12/27.
 */
public class BaseDao<T> {
    //添加
    public boolean save(T t){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        boolean b = false;
        try{
            em.persist(t);
            em.getTransaction().commit();
            b = true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return b;
    }

    //删除
    public void delete(T t){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try{
            em.remove(em.merge(t));;
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }

    //修改
    public void update(T t){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        try{
            em.merge(t);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }

    //依据id查询
    public T findById(Class<T> entityClass,Object id){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        T entity = null;
        try{
            entity = em.find(entityClass, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return entity;
    }

    //查询列表
    public List<T> findAll(Class<T> entityClass){
        String jpql = "from "+entityClass.getName();
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        List<T> list = null;
        try{
            list = em.createQuery(jpql).getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return list;
    }
}
