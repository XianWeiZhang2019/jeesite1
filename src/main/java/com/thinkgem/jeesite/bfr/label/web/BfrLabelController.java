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
import com.thinkgem.jeesite.bfr.label.entity.BfrLabel;
import com.thinkgem.jeesite.bfr.label.service.BfrLabelService;

/**
 * 标签Controller
 * @author 标签
 * @version 2019-07-23
 */
@Controller
@RequestMapping(value = "${adminPath}/label/bfrLabel")
public class BfrLabelController extends BaseController {

	@Autowired
	private BfrLabelService bfrLabelService;
	
	@ModelAttribute
	public BfrLabel get(@RequestParam(required=false) String id) {
		BfrLabel entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = bfrLabelService.get(id);
		}
		if (entity == null){
			entity = new BfrLabel();
		}
		return entity;
	}
	
	@RequiresPermissions("label:bfrLabel:view")
	@RequestMapping(value = {"list", ""})
	public String list(BfrLabel bfrLabel, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BfrLabel> page = bfrLabelService.findPage(new Page<BfrLabel>(request, response), bfrLabel); 
		model.addAttribute("page", page);
		return "bfr/label/bfrLabelList";
	}

	@RequiresPermissions("label:bfrLabel:view")
	@RequestMapping(value = "form")
	public String form(BfrLabel bfrLabel, Model model) {
		model.addAttribute("bfrLabel", bfrLabel);
		return "bfr/label/bfrLabelForm";
	}

	@RequiresPermissions("label:bfrLabel:edit")
	@RequestMapping(value = "save")
	public String save(BfrLabel bfrLabel, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, bfrLabel)){
			return form(bfrLabel, model);
		}
		bfrLabelService.save(bfrLabel);
		addMessage(redirectAttributes, "保存标签成功");
		return "redirect:"+Global.getAdminPath()+"/label/bfrLabel/?repage";
	}
	
	@RequiresPermissions("label:bfrLabel:edit")
	@RequestMapping(value = "delete")
	public String delete(BfrLabel bfrLabel, RedirectAttributes redirectAttributes) {
		bfrLabelService.delete(bfrLabel);
		addMessage(redirectAttributes, "删除标签成功");
		return "redirect:"+Global.getAdminPath()+"/label/bfrLabel/?repage";
	}

}