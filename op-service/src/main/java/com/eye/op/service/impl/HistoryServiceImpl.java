package com.eye.op.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eye.op.bean.History;
import com.eye.op.common.dao.GenerateDao;
import com.eye.op.common.service.impl.ServiceImpl;
import com.eye.op.common.utils.Constant;
import com.eye.op.common.utils.DateUtil;
import com.eye.op.service.IHistoryService;

@Service
public class HistoryServiceImpl extends ServiceImpl implements IHistoryService{
	
	@Value("${last_days_hist}")
	private int lastDaysHist;
	
	@Resource
	private GenerateDao generateDao;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<History> getHist(String idCard) {
		Date current = new Date();
		Date last_day = null;
		try {
			last_day = DateUtil.minDays(current, lastDaysHist);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String hql = "from History h where h.idCard =:idCard and h.lastTime>=:lastTime and h.deleted=:deleted order by h.lastTime desc";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idCard", idCard);
		map.put("lastTime", last_day);
		map.put("deleted", Constant.DELETE_NO);
		List<History> list = generateDao.executeHql(hql, map);
		return list;
		
	}

}
