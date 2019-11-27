/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.bfr.label.entity.BfrLabelData;
import com.thinkgem.jeesite.bfr.label.dao.BfrLabelDataDao;

/**
 * 贴标签Service
 * @author 贴标签
 * @version 2019-07-24
 */
@Service
@Transactional(readOnly = true)
public class BfrLabelDataService extends CrudService<BfrLabelDataDao, BfrLabelData> {

	public BfrLabelData get(String id) {
		return super.get(id);
	}
	
	public List<BfrLabelData> findList(BfrLabelData bfrLabelData) {
		return super.findList(bfrLabelData);
	}
	
	public Page<BfrLabelData> findPage(Page<BfrLabelData> page, BfrLabelData bfrLabelData) {
		return super.findPage(page, bfrLabelData);
	}
	
	@Transactional(readOnly = false)
	public void save(BfrLabelData bfrLabelData) {
		super.save(bfrLabelData);
	}
	
	@Transactional(readOnly = false)
	public void delete(BfrLabelData bfrLabelData) {
		super.delete(bfrLabelData);
	}
	
}