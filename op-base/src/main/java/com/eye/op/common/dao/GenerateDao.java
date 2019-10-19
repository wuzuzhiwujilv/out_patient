package com.eye.op.common.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.eye.op.common.bean.GenerateBean;
import com.eye.op.common.utils.Constant;
import com.eye.op.common.utils.DateUtil;




@Repository
public class GenerateDao{
	Logger logger = LoggerFactory.getLogger(GenerateDao.class);
	@Resource
	private SessionFactory sessionFactory;
	
	protected Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("rawtypes")
	public List executeHql(String hql){
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}
	@SuppressWarnings("rawtypes")
	public List executeHql(String hql,Map<String,Object> conditionMap){
		Query query = getCurrentSession().createQuery(hql);
		query.setProperties(conditionMap);
		return query.list();
	}
	public Object executeHqlUnique(String sql){
		return getCurrentSession().createQuery(sql).uniqueResult();
	}
	
	public int getCount(StringBuffer hql,Map<String,Object> conditionMap){
		hql.insert(0, "select count(1) ");
		Query query = getCurrentSession().createQuery(hql.toString());
		query.setProperties(conditionMap);
		return  ((Long) query.uniqueResult()).intValue();
	}
	
	@SuppressWarnings("rawtypes")
	public List getByPage(StringBuffer hql,int page,int size,Map<String,Object> conditionMap){
		Query query = getCurrentSession().createQuery(hql.toString());
		query.setProperties(conditionMap);
		query.setFirstResult((page-1)*size);
		query.setMaxResults(size);
		return query.list();
	}
	
	public <T extends GenerateBean> T save(T object){
		object.setDeleted(Constant.DELETE_NO);
		object.setCreatedDate(DateUtil.getCurrentDate());
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(false);
		object.setCreatedUser(session.getAttribute(Constant.SESSION_ACCOUNT).toString());
		getCurrentSession().save(object);
		return object;
	}
	
	public Object saveRS(Object object){
		getCurrentSession().save(object);
		return object;
	}
	
	public <T extends GenerateBean> T update(T object){
		object.setModifiedDate(DateUtil.getCurrentDate());
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(false);
		object.setModifiedUser(session.getAttribute(Constant.SESSION_ACCOUNT).toString());
		getCurrentSession().update(object);
		return object;
	}
	
	public Object updateRS(Object object){
		getCurrentSession().update(object);
		return object;
	}
	
	public Object saveOrUpdate(Object object){
		getCurrentSession().saveOrUpdate(object);
		return object;
	}
	
	public <T extends GenerateBean> T deleteForLogic(T object){
		object.setDeleted(Constant.DELETE_YES);
		object.setModifiedDate(DateUtil.getCurrentDate());
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(false);
		object.setModifiedUser(session.getAttribute(Constant.SESSION_ACCOUNT).toString());
		getCurrentSession().update(object);
		return object;
	}
	
	public  void delete(Object object){
		getCurrentSession().delete(object);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends GenerateBean> List<T> get(T object){
		object.setDeleted(Constant.DELETE_NO);
		Example example = Example.create(object);
		Criteria criteria =getCurrentSession().createCriteria(object.getClass());
		criteria.add(example);
		return criteria.list();
	}
	@SuppressWarnings("unchecked")
	public <T> T getById(Class<T> clazz,int id){
		return (T) getCurrentSession().get(clazz, id);
	}
	
	public <T extends GenerateBean> List<T> deleteForCollection(List<T> list){
		for(T object:list){
			deleteForLogic(object);
		}
		return list;
	}
	
	public <T extends GenerateBean> List<T> saveForCollection(List<T> list){
		for(T object:list){
			save(object);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends GenerateBean> List<T> getByExample(T example){
		Criteria criteria = getCurrentSession().createCriteria(example.getClass());
		criteria.add(Example.create(example));
		criteria.add(Restrictions.eq("deleted", Constant.DELETE_NO));
		return criteria.list();
	}
	
	public <T extends GenerateBean> void saveBatch(List<T> list){
		Session session = getCurrentSession();
		HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(false);
		String user = httpSession.getAttribute(Constant.SESSION_ACCOUNT).toString();
		for (int i = 0; i < list.size(); i++) {
			T object = list.get(i);
			object.setDeleted(Constant.DELETE_NO);
			object.setCreatedDate(DateUtil.getCurrentDate());
			object.setCreatedUser(user);
			session.save(object);
			if (i % 100 == 0) {
				session.flush();
				session.clear();
			}
		}
	}
}
