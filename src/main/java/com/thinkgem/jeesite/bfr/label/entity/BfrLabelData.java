/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.bfr.label.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 贴标签Entity
 * @author 贴标签
 * @version 2019-07-24
 */
public class BfrLabelData extends DataEntity<BfrLabelData> {
	
	private static final long serialVersionUID = 1L;
	private String labelDataId;		// label_data_id
	private String lableId;		// 标签id
	private String dataId;		// 数据项id
	private String dbType;		// 表类型，代表哪张表：0 bfr_testing_data, 1 bfr_treatment_plan_data, 2 bfr_patient_data,3 bfr_donor_data
	
	public BfrLabelData() {
		super();
	}

	public BfrLabelData(String id){
		super(id);
	}

	@Length(min=1, max=11, message="label_data_id长度必须介于 1 和 11 之间")
	public String getLabelDataId() {
		return labelDataId;
	}

	public void setLabelDataId(String labelDataId) {
		this.labelDataId = labelDataId;
	}
	
	@Length(min=0, max=11, message="标签id长度必须介于 0 和 11 之间")
	public String getLableId() {
		return lableId;
	}

	public void setLableId(String lableId) {
		this.lableId = lableId;
	}
	
	@Length(min=0, max=11, message="数据项id长度必须介于 0 和 11 之间")
	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
	@Length(min=0, max=11, message="表类型，代表哪张表：0 bfr_testing_data, 1 bfr_treatment_plan_data, 2 bfr_patient_data,3 bfr_donor_data长度必须介于 0 和 11 之间")
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
}