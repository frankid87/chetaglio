package com.chetaglio.model.dao.utility;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public abstract class BaseDAO<T> extends HibernateDaoSupport {
	
	public void create(T entity) {
		getHibernateTemplate().save(entity);		
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);		
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);		
	}
	
	public T findById(Long id) {
		T entity = getHibernateTemplate().get(getTargetClass(), id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		List<T> list = (List<T>) getHibernateTemplate().find("from " + getTargetClass().getName());
		return list;
	}
	
	public abstract Class<T> getTargetClass();

}