/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.bfr.label.entity.BfrLabelData;

/**
 * 贴标签DAO接口
 * @author 贴标签
 * @version 2019-07-24
 */
@MyBatisDao
public interface BfrLabelDataDao extends CrudDao<BfrLabelData> {
	
}