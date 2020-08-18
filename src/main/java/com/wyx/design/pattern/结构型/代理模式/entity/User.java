package com.wyx.design.pattern.结构型.代理模式.entity;

/**
 * @author : Just wyx
 * @Description : TODO 2020/8/18
 * @Date : 2020/8/18
 */
public class User {

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
