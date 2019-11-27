package com.thinkgem.jeesite.modules.cms.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "${adminPath}/cms/test")
public class Test {
	
	@RequiresPermissions("cms:category:view")
	@RequestMapping(value = {"list", ""})
	public String ceshi(Model model) {
//		List<Category> list = Lists.newArrayList();
//		List<Category> sourcelist = categoryService.findByUser(true, null);
//		Category.sortList(list, sourcelist, "1");
//		model.addAttribute("list", list);
		return "modules/woyaoceshi/MyJsp";
	}
	@RequiresPermissions("cms:category:view")
	@RequestMapping(value = "ceshi")
	public String ceshia(Model model) {
//		List<Category> list = Lists.newArrayList();
//		List<Category> sourcelist = categoryService.findByUser(true, null);
//		Category.sortList(list, sourcelist, "1");
//		model.addAttribute("list", list);
		return "modules/woyaoceshi/MyJspa";
	}

}
