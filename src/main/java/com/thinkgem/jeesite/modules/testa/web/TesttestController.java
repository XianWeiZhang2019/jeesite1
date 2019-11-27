/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testa.web;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.testa.entity.Testtest;
import com.thinkgem.jeesite.modules.testa.service.TesttestService;

/**
 * 测试Controller
 * @author 张
 * @version 2019-02-27
 */
@Controller
@RequestMapping(value = "${adminPath}/testa/testtest")
public class TesttestController extends BaseController {

	@Autowired
	private TesttestService testtestService;
	
	@ModelAttribute
	public Testtest get(@RequestParam(required=false) String id) {
		Testtest entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testtestService.get(id);
		}
		if (entity == null){
			entity = new Testtest();
		}
		return entity;
	}
	
	@RequiresPermissions("testa:testtest:view")
	@RequestMapping(value = {"list", ""})
	public String list(Testtest testtest, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Testtest> page = testtestService.findPage(new Page<Testtest>(request, response), testtest); 
		model.addAttribute("page", page);
		return "modules/testa/testtestList";
	}

	@RequiresPermissions("testa:testtest:view")
	@RequestMapping(value = "form")
	public String form(Testtest testtest, Model model) {
		model.addAttribute("testtest", testtest);
		return "modules/testa/testtestForm";
	}

	@RequiresPermissions("testa:testtest:edit")
	@RequestMapping(value = "save")
	public String save(Testtest testtest, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testtest)){
			return form(testtest, model);
		}
		testtestService.save(testtest);
		addMessage(redirectAttributes, "保存测试成功");
		return "redirect:"+Global.getAdminPath()+"/testa/testtest/?repage";
	}
	
	@RequiresPermissions("testa:testtest:edit")
	@RequestMapping(value = "delete")
	public String delete(Testtest testtest, RedirectAttributes redirectAttributes) {
		testtestService.delete(testtest);
		addMessage(redirectAttributes, "删除测试成功");
		return "redirect:"+Global.getAdminPath()+"/testa/testtest/?repage";
	}

}