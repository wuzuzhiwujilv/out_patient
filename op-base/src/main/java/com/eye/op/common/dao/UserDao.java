package com.eye.op.common.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eye.op.common.bean.User;
import com.eye.op.common.utils.Constant;



@Repository
public class UserDao extends GenerateDao{
	public User getUserByAccount(String vcAccount){
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("vcAccount", vcAccount));
		criteria.add(Restrictions.eq("deleted", Constant.DELETE_NO));
		return (User) criteria.uniqueResult();
	}
}
