/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testa.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.testa.entity.Testtest;

/**
 * 测试DAO接口
 * @author 张
 * @version 2019-02-27
 */
@MyBatisDao
public interface TesttestDao extends CrudDao<Testtest> {
	
}