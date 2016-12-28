package org.library.dao;

import org.library.entity.Operator;
import org.library.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by admin on 2016/12/26.
 */
public class OperatorDao extends BaseDao{
    //根据控制员的Id和乐观锁版本号查询控制员信息
    public Operator findOperatorByIdAndVer(Operator operator){
        String jpql = "from tb_operator o where o.id = ?1 and o.ver = ?2";
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Operator operator1 = null;
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1,operator.getId());
            query.setParameter(2,operator.getVer());
            operator1 = (Operator) query.getSingleResult();
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return operator1;
    }
    //根据控制员名字查询控制员信息
    public Operator findOperatorByOperatorName(Operator operator){
        String jpql = "from tb_operator o where o.name = ?1";
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Operator operator1 = null;
        try{
            Query query = em.createQuery(jpql);
            query.setParameter(1,operator.getName());
            operator1 = (Operator) query.getSingleResult();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return operator1;
    }
}
