package org.library.dao;

import org.library.entity.Readers;
import org.library.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by admin on 2016/12/26.
 */
public class ReadersDao extends BaseDao{
    //根据读者的姓名和乐观锁版本号查询读者信息
    public Readers findReadersByNameAndVer(Readers readers){
        String jpql = "from tb_readers r where r.name = ?1 and r.ver = ?2";
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Readers readers1 = null;
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1,readers.getName());
            query.setParameter(2,readers.getVer());
            readers1 = (Readers) query.getSingleResult();
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return readers1;
    }

    //根据读者姓名查询读者信息
    public Readers findReadersByReaderName(Readers readers){
        String jpql = "from tb_readers r where r.name = ?1";
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Readers readers1 = null;
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1,readers.getName());
            readers1 = (Readers) query.getSingleResult();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return readers1;
    }
    //删除读者
    public void deleteReaders(EntityManager em,String name){
        String sql = "delete from tb_readers r where r.name = ?1";
        Query query = em.createNativeQuery(sql);
        query.setParameter(1,name);
        query.executeUpdate();
    }
}
