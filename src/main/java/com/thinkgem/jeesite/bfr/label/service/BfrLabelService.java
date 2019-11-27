/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.bfr.label.entity.BfrLabel;
import com.thinkgem.jeesite.bfr.label.dao.BfrLabelDao;

/**
 * 标签Service
 * @author 标签
 * @version 2019-07-23
 */
@Service
@Transactional(readOnly = true)
public class BfrLabelService extends CrudService<BfrLabelDao, BfrLabel> {

	public BfrLabel get(String id) {
		return super.get(id);
	}
	
	public List<BfrLabel> findList(BfrLabel bfrLabel) {
		return super.findList(bfrLabel);
	}
	
	public Page<BfrLabel> findPage(Page<BfrLabel> page, BfrLabel bfrLabel) {
		return super.findPage(page, bfrLabel);
	}
	
	@Transactional(readOnly = false)
	public void save(BfrLabel bfrLabel) {
		super.save(bfrLabel);
	}
	
	@Transactional(readOnly = false)
	public void delete(BfrLabel bfrLabel) {
		super.delete(bfrLabel);
	}
	
}