/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.web;

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
import com.thinkgem.jeesite.bfr.label.entity.BfrLabelProject;
import com.thinkgem.jeesite.bfr.label.service.BfrLabelProjectService;

/**
 * 项目添加标签Controller
 * @author 项目添加标签
 * @version 2019-07-25
 */
@Controller
@RequestMapping(value = "${adminPath}/label/bfrLabelProject")
public class BfrLabelProjectController extends BaseController {

	@Autowired
	private BfrLabelProjectService bfrLabelProjectService;
	
	@ModelAttribute
	public BfrLabelProject get(@RequestParam(required=false) String id) {
		BfrLabelProject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bfrLabelProjectService.get(id);
		}
		if (entity == null){
			entity = new BfrLabelProject();
		}
		return entity;
	}
	
	@RequiresPermissions("label:bfrLabelProject:view")
	@RequestMapping(value = {"list", ""})
	public String list(BfrLabelProject bfrLabelProject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BfrLabelProject> page = bfrLabelProjectService.findPage(new Page<BfrLabelProject>(request, response), bfrLabelProject); 
		model.addAttribute("page", page);
		return "bfr/label/bfrLabelProjectList";
	}

	@RequiresPermissions("label:bfrLabelProject:view")
	@RequestMapping(value = "form")
	public String form(BfrLabelProject bfrLabelProject, Model model) {
		model.addAttribute("bfrLabelProject", bfrLabelProject);
		return "bfr/label/bfrLabelProjectForm";
	}

	@RequiresPermissions("label:bfrLabelProject:edit")
	@RequestMapping(value = "save")
	public String save(BfrLabelProject bfrLabelProject, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bfrLabelProject)){
			return form(bfrLabelProject, model);
		}
		bfrLabelProjectService.save(bfrLabelProject);
		addMessage(redirectAttributes, "保存项目添加标签成功");
		return "redirect:"+Global.getAdminPath()+"/label/bfrLabelProject/?repage";
	}
	
	@RequiresPermissions("label:bfrLabelProject:edit")
	@RequestMapping(value = "delete")
	public String delete(BfrLabelProject bfrLabelProject, RedirectAttributes redirectAttributes) {
		bfrLabelProjectService.delete(bfrLabelProject);
		addMessage(redirectAttributes, "删除项目添加标签成功");
		return "redirect:"+Global.getAdminPath()+"/label/bfrLabelProject/?repage";
	}

}