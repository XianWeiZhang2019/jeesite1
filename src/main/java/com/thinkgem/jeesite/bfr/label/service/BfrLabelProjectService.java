/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.bfr.label.entity.BfrLabelProject;
import com.thinkgem.jeesite.bfr.label.dao.BfrLabelProjectDao;

/**
 * 项目添加标签Service
 * @author 项目添加标签
 * @version 2019-07-25
 */
@Service
@Transactional(readOnly = true)
public class BfrLabelProjectService extends CrudService<BfrLabelProjectDao, BfrLabelProject> {

	public BfrLabelProject get(String id) {
		return super.get(id);
	}
	
	public List<BfrLabelProject> findList(BfrLabelProject bfrLabelProject) {
		return super.findList(bfrLabelProject);
	}
	
	public Page<BfrLabelProject> findPage(Page<BfrLabelProject> page, BfrLabelProject bfrLabelProject) {
		return super.findPage(page, bfrLabelProject);
	}
	
	@Transactional(readOnly = false)
	public void save(BfrLabelProject bfrLabelProject) {
		super.save(bfrLabelProject);
	}
	
	@Transactional(readOnly = false)
	public void delete(BfrLabelProject bfrLabelProject) {
		super.delete(bfrLabelProject);
	}
	
}