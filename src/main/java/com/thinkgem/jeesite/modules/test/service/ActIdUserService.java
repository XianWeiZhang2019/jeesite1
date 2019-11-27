/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.test.dao.ActIdUserDao;
import com.thinkgem.jeesite.modules.test.entity.ActIdUser;

/**
 * 不知道Service
 * @author 测试者
 * @version 2018-12-25
 */
@Service
@Transactional(readOnly = true)
public class ActIdUserService extends CrudService<ActIdUserDao, ActIdUser> {
	
	public ActIdUser get(String id) {
		return super.get(id);
	}
	
	public List<ActIdUser> findList(ActIdUser actIdUser) {
		return super.findList(actIdUser);
	}
	
	public Page<ActIdUser> findPage(Page<ActIdUser> page, ActIdUser actIdUser) {
		return super.findPage(page, actIdUser);
	}
	
	@Transactional(readOnly = false)
	public void save(ActIdUser actIdUser) {
		super.save(actIdUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(ActIdUser actIdUser) {
		super.delete(actIdUser);
	}
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("sprisng-context*.xml");
		ActIdUserService actIdUserService=(ActIdUserService) context.getBean(ActIdUserService.class);

		ActIdUser actIdUser = new ActIdUser();
		List<ActIdUser> list = actIdUserService.findList(actIdUser);
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			ActIdUser user = list.get(i);
			String email = user.getEmail();
			System.out.println(email);
			
		}
	}
}