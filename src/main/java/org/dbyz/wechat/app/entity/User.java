package org.dbyz.wechat.app.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @ClassName: User
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a> 
 * @version: V1.0
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;// 姓名
	private String phone;// 手机号
	private String department;// 部门
	private String openId;// 微信标识
	private Integer rank;// 等级
	private Date bindTime;// 绑定时间
	private Date createTime;// 创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getBindTime() {
		return bindTime;
	}

	public void setBindTime(Date bindTime) {
		this.bindTime = bindTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", phone=" + phone + ", department="
				+ department + ", openId=" + openId + ", rank=" + rank
				+ ", bindTime=" + bindTime + ", createTime=" + createTime + "]";
	}
}
