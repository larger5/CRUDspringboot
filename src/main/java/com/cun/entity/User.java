package com.cun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 实体
@Table(name = "t_user") // 数据库表名
public class User {
	
    @Id // 主键
    @GeneratedValue // 自增
	private Integer id;
	
    @Column(length = 20) // 字段长度
	private String userName;
	
    @Column(length = 20) // 字段长度
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
