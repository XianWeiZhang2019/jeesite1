/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.bfr.label.entity.BfrLabelProject;

/**
 * 项目添加标签DAO接口
 * @author 项目添加标签
 * @version 2019-07-25
 */
@MyBatisDao
public interface BfrLabelProjectDao extends CrudDao<BfrLabelProject> {
	
}