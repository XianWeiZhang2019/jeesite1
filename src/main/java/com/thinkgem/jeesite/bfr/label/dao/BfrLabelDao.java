/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.bfr.label.entity.BfrLabel;

/**
 * 标签DAO接口
 * @author 标签
 * @version 2019-07-23
 */
@MyBatisDao
public interface BfrLabelDao extends CrudDao<BfrLabel> {
	
}