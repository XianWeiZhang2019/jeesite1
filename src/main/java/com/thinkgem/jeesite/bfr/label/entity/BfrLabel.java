/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 标签Entity
 * @author 标签
 * @version 2019-07-23
 */
public class BfrLabel extends DataEntity<BfrLabel> {
	
	private static final long serialVersionUID = 1L;
	private Integer labelId;		// id，也是键值
	private String labelName;		// 标签名称
	private String other;		// other
	
	public BfrLabel() {
		super();
	}

	public BfrLabel(String id){
		super(id);
	}

	@NotNull(message="id，也是键值不能为空")
	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	
	@Length(min=0, max=64, message="标签名称长度必须介于 0 和 64 之间")
	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	
	@Length(min=0, max=64, message="other长度必须介于 0 和 64 之间")
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
}