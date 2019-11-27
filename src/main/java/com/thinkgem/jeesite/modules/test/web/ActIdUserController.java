/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.test.entity.ActIdUser;
import com.thinkgem.jeesite.modules.test.service.ActIdUserService;
import com.thinkgem.jeesite.common.utils.StringUtils;

/**
 * 不知道Controller
 * @author 测试者
 * @version 2018-12-25
 */
@Controller
@RequestMapping(value = "${adminPath}/test/actIdUser")//访问路径ceshi/actIdUser
public class ActIdUserController extends BaseController {

	@Autowired
	private ActIdUserService actIdUserService;
	
	@ModelAttribute
	public ActIdUser get(@RequestParam(required=false) String id) {
		ActIdUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = actIdUserService.get(id);
		}
		if (entity == null){
			entity = new ActIdUser();
		}
		return entity;
	}
	
	@RequiresPermissions("ceshi:actIdUser:view")//权限控制ceshi:actIdUser:view  view为查看权限
	@RequestMapping(value = {"list", ""})//方法的路径list或者空
	public String list(ActIdUser actIdUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ActIdUser> page = actIdUserService.findPage(new Page<ActIdUser>(request, response), actIdUser); 
		model.addAttribute("page", page);
		return "modules/woyaoceshi/actIdUserList";
	}

	@RequiresPermissions("ceshi:actIdUser:view")
	@RequestMapping(value = "form")
	public String form(ActIdUser actIdUser, Model model) {
		model.addAttribute("actIdUser", actIdUser);
		return "modules/woyaoceshi/actIdUserForm";
	}

	@RequiresPermissions("ceshi:actIdUser:edit")//edit为维护权限
	@RequestMapping(value = "save")
	public String save(ActIdUser actIdUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, actIdUser)){
			return form(actIdUser, model);
		}
		actIdUserService.save(actIdUser);
		addMessage(redirectAttributes, "保存测试成功");
		return "redirect:"+Global.getAdminPath()+"/test/actIdUser/?repage";
	}
	
	@RequiresPermissions("ceshi:actIdUser:edit")
	@RequestMapping(value = "delete")
	public String delete(ActIdUser actIdUser, RedirectAttributes redirectAttributes) {
		actIdUserService.delete(actIdUser);
		addMessage(redirectAttributes, "删除测试成功");
		return "redirect:"+Global.getAdminPath()+"/test/actIdUser/?repage";
	}

}