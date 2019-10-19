package com.eye.op.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.eye.op.common.bean.UserPrivilege;

@Repository
public class UserPrivilegeDao extends GenerateDao{
	public void save(UserPrivilege userPrivilege) throws Exception{
		getCurrentSession().save(userPrivilege);
	}
	
	@SuppressWarnings("unchecked")
	public List<UserPrivilege> getByUserId(Integer uid){
		String hql = "from UserPrivilege up where up.user.id = " + uid;
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}
}
