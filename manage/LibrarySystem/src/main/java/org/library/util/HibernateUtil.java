package org.library.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class HibernateUtil {
	//定义一个entityManagerFactory，用于创建entityManager对象
	//它用于取代hibernate的sessionfactory；
	private static EntityManagerFactory  emFactory;
	//初始化实体管理工厂；e
	static{
		//通过Persistence类的静态方法创建一个EntityManagerFactory;
		//createEntityMaenagerFactory("")指定持久化单元的名称;
		emFactory=Persistence.createEntityManagerFactory("Oracle");
	}
	//提供一个方法用于获取entitymanager对象
	//entitymanager对象取代hibernate的session;
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}
	public static void main(String[] args) {
		System.out.println(getEntityManager());
	}
}
