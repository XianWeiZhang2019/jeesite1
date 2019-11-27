/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目添加标签Entity
 * @author 项目添加标签
 * @version 2019-07-25
 */
public class BfrLabelProject extends DataEntity<BfrLabelProject> {
	
	private static final long serialVersionUID = 1L;
	private String labelProjectId;		// id
	private String labelId;		// 标签id
	private String projectId;		// 项目id
	private String other;		// other
	
	public BfrLabelProject() {
		super();
	}

	public BfrLabelProject(String id){
		super(id);
	}

	@Length(min=1, max=11, message="id长度必须介于 1 和 11 之间")
	public String getLabelProjectId() {
		return labelProjectId;
	}

	public void setLabelProjectId(String labelProjectId) {
		this.labelProjectId = labelProjectId;
	}
	
	@Length(min=0, max=11, message="标签id长度必须介于 0 和 11 之间")
	public String getLabelId() {
		return labelId;
	}

	public void setLabelId(String labelId) {
		this.labelId = labelId;
	}
	
	@Length(min=0, max=11, message="项目id长度必须介于 0 和 11 之间")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	@Length(min=0, max=64, message="other长度必须介于 0 和 64 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
}