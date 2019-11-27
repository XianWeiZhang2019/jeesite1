/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testa.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.testa.entity.Testtest;
import com.thinkgem.jeesite.modules.testa.dao.TesttestDao;

/**
 * 测试Service
 * @author 张
 * @version 2019-02-27
 */
@Service
@Transactional(readOnly = true)
public class TesttestService extends CrudService<TesttestDao, Testtest> {

	public Testtest get(String id) {
		return super.get(id);
	}
	
	public List<Testtest> findList(Testtest testtest) {
		return super.findList(testtest);
	}
	
	public Page<Testtest> findPage(Page<Testtest> page, Testtest testtest) {
		return super.findPage(page, testtest);
	}
	
	@Transactional(readOnly = false)
	public void save(Testtest testtest) {
		super.save(testtest);
	}
	
	@Transactional(readOnly = false)
	public void delete(Testtest testtest) {
		super.delete(testtest);
	}
	
}