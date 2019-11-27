/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test.entity.ActIdUser;

/**
 * 不知道DAO接口
 * @author 测试者
 * @version 2018-12-25
 */
@MyBatisDao
public interface ActIdUserDao extends CrudDao<ActIdUser> {
	
}