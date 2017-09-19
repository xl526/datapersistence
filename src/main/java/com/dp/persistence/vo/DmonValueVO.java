package com.dp.persistence.vo;

public class DmonValueVO {
	
	//监控点uid
	private String id;
	
	//时间戳
	private Long t;
	
	//监控点名称
	private String name;
	
	//数据值
	private String value;
	
	//分组名称
	private String gname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getT() {
		return t;
	}

	public void setT(Long t) {
		this.t = t;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	
}
