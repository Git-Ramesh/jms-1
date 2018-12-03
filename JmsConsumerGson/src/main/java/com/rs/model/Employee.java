package com.rs.model;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer empno;
	private String ename;
	
	public Employee() {
		//TODO No operations
	}
	public Employee(Integer empno, String ename) {
		this.empno = empno;
		this.ename =ename;
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
