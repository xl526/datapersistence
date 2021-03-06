package com.dp.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPMENT")
public class Equipment extends BaseDomain {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7733805311850035229L;

	@Column(name="ENO")
	private String eno;

	@Column(name="ENAME")
	private String ename;
	
	@Column(name="ESTATUS")
	private String estatus;
	
	@Column(name="EDESCRIPTION")
	private String edescription;

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getEdescription() {
		return edescription;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}
	
}
