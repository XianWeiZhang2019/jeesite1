/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 不知道Entity
 * @author 测试者
 * @version 2018-12-25
 */
public class ActIdUser extends DataEntity<ActIdUser> {
	
	private static final long serialVersionUID = 1L;
	private String id;		// rev_
	private String rev;		// rev_
	private String first;		// first_
	private String last;		// last_
	private String email;		// email_
	private String pwd;		// pwd_
	private String pictureId;		// picture_id_
	
	public ActIdUser() {
		super();
	}

	public ActIdUser(String id){
		super(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Length(min=0, max=11, message="rev_长度必须介于 0 和 11 之间")
	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}
	
	@Length(min=0, max=255, message="first_长度必须介于 0 和 255 之间")
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
	
	@Length(min=0, max=255, message="last_长度必须介于 0 和 255 之间")
	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	@Length(min=0, max=255, message="email_长度必须介于 0 和 255 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=255, message="pwd_长度必须介于 0 和 255 之间")
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Length(min=0, max=64, message="picture_id_长度必须介于 0 和 64 之间")
	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	
}