package com.ynwi.ssh.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;

import com.ynwi.ssh.beans.Risk;
import com.ynwi.ssh.dao.RiskDao;
import com.ynwi.ssh.forms.RiskForm;
import com.ynwi.ssh.service.RiskManager;

public class RiskManagerImpl implements RiskManager{
	
	private RiskDao dao;
	
	public RiskDao getDao() {
		return dao;
	}

	public void setDao(RiskDao dao) {
		this.dao = dao;
	}

	
	@Override
	public void create(RiskForm form) throws HibernateException {
		Risk risk = new Risk();
		BeanUtils.copyProperties(form, risk);
		risk.setIsissue("0");
		risk.setIsidentify("0");
		risk.setCreatetime(new Date());
		dao.saveObject(risk);
	}

	@Override
	public void update(Risk risk) throws HibernateException {
		dao.updateObject(risk);
	}

	@Override
	public ArrayList<Risk> getrisklist() throws HibernateException {
		
		return dao.getrisklist();
	}

	@Override
	public Risk getrisk(int id) throws HibernateException {
		return dao.getrisk(id);
	}

}
