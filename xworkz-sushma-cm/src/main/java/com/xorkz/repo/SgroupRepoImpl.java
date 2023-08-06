package com.xorkz.repo;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xorkz.entity.AddTechnologyEntity;
import com.xorkz.entity.SgroupEntity;


@Repository
public class SgroupRepoImpl implements SgroupRepo {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean save(SgroupEntity entity) {
		System.out.println("running save method" +entity);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		transaction.commit();
		return true;
		} finally {
			manager.close();
		}
		
	}
	@Override
	public List<SgroupEntity> findAll() {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("find");
			List<SgroupEntity> list = query.getResultList();
			System.out.println("total list size in repo " +list.size());
			return list;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public Long findByEmail(String email) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("emailId");
			query.setParameter("emailBy", email);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public Long findByUser(String user) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("userId");
			query.setParameter("userBy", user);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public Long findByMobile(Long mobile) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("mobileId");
			query.setParameter("mobileBy", mobile);
			Object object = query.getSingleResult();
			Long value = (Long) object;
			System.out.println(value);
			return value;
			} finally {
			manager.close();
		}
	}
	
	@Override
	public SgroupEntity userSignIn(String userId) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("userANDpassword");
			query.setParameter("ui", userId);
			//query.setParameter("pwd", password);
			Object object = query.getSingleResult();
			SgroupEntity entity=(SgroupEntity) object;
			System.out.println(""+entity);
			return entity;
			} finally {
			manager.close();
		}
	}
	
	@Override
	public boolean logincount(String userId, int count) {
		System.out.println("count:" +count);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updateLoginCount");
			query.setParameter("ui", userId);
			query.setParameter("count", count);
			query.executeUpdate();
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public boolean update(SgroupEntity entity) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(entity);
			transaction.commit();
			return true;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public SgroupEntity reSetPassword(String email) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			
			Query query = manager.createNamedQuery("emailid");
			query.setParameter("ei", email);
			Object object = query.getSingleResult();
			SgroupEntity entity=(SgroupEntity) object;
			System.out.println("" +entity);
			return entity;
		} finally {
			manager.close();
		}
	}
	@Override
	public boolean updatePassword(String userId, String password, Boolean resetPassword, LocalTime passwordChangedTime) {
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updatePassword");
			query.setParameter("uu", userId);
			query.setParameter("up", password);
			query.setParameter("urp", resetPassword);
			query.setParameter("pct", passwordChangedTime);
			query.executeUpdate();
			return true;
		} finally {
			manager.close();
		}	}
	@Override
	public boolean add(AddTechnologyEntity entity) {
		System.out.println("add in repo implimentation");
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(entity);
			transaction.commit();
			return true;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return false;
	}
	
	@Override
	public SgroupEntity findById(Integer Id) {
		System.out.println("findById"+Id);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("findById");
			query.setParameter("id", Id);
			SgroupEntity result = (SgroupEntity) query.getSingleResult();
			return result;
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return SgroupRepo.super.findById(Id);
	}
	
	@Override
	public List<AddTechnologyEntity> listBysignupId(Integer signupId) {
		System.out.println("listBysignupId + " +signupId);
		EntityManager manager = this.entityManagerFactory.createEntityManager();
		try {
			Query query = manager.createNamedQuery("list");
			System.out.println("query: "+ query);
			Query setParameter= query.setParameter("bysignupId", signupId);
			System.out.println("setParameter :" +setParameter);
			List<AddTechnologyEntity>resultList = query.getResultList();
			resultList.forEach(l->System.out.println("" +l));
			return resultList;
		}catch (NoResultException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return SgroupRepo.super.listBysignupId(signupId);
	}
	
}