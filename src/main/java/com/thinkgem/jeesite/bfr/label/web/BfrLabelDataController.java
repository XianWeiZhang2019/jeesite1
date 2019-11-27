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
import com.thinkgem.jeesite.bfr.label.entity.BfrLabelData;
import com.thinkgem.jeesite.bfr.label.service.BfrLabelDataService;

/**
 * 贴标签Controller
 * @author 贴标签
 * @version 2019-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/label/bfrLabelData")
public class BfrLabelDataController extends BaseController {

	@Autowired
	private BfrLabelDataService bfrLabelDataService;
	
	@ModelAttribute
	public BfrLabelData get(@RequestParam(required=false) String id) {
		BfrLabelData entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bfrLabelDataService.get(id);
		}
		if (entity == null){
			entity = new BfrLabelData();
		}
		return entity;
	}
	
	@RequiresPermissions("label:bfrLabelData:view")
	@RequestMapping(value = {"list", ""})
	public String list(BfrLabelData bfrLabelData, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BfrLabelData> page = bfrLabelDataService.findPage(new Page<BfrLabelData>(request, response), bfrLabelData); 
		model.addAttribute("page", page);
		return "bfr/label/bfrLabelDataList";
	}

	@RequiresPermissions("label:bfrLabelData:view")
	@RequestMapping(value = "form")
	public String form(BfrLabelData bfrLabelData, Model model) {
		model.addAttribute("bfrLabelData", bfrLabelData);
		return "bfr/label/bfrLabelDataForm";
	}

	@RequiresPermissions("label:bfrLabelData:edit")
	@RequestMapping(value = "save")
	public String save(BfrLabelData bfrLabelData, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bfrLabelData)){
			return form(bfrLabelData, model);
		}
		bfrLabelDataService.save(bfrLabelData);
		addMessage(redirectAttributes, "保存贴标签成功");
		return "redirect:"+Global.getAdminPath()+"/label/bfrLabelData/?repage";
	}
	
	@RequiresPermissions("label:bfrLabelData:edit")
	@RequestMapping(value = "delete")
	public String delete(BfrLabelData bfrLabelData, RedirectAttributes redirectAttributes) {
		bfrLabelDataService.delete(bfrLabelData);
		addMessage(redirectAttributes, "删除贴标签成功");
		return "redirect:"+Global.getAdminPath()+"/label/bfrLabelData/?repage";
	}

}