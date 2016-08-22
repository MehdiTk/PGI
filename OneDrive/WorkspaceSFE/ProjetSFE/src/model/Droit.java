package model;
// Generated 4 juil. 2016 00:52:55 by Hibernate Tools 3.6.0.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Droit generated by hbm2java
 */
public class Droit implements java.io.Serializable {

	private BigDecimal droitId;
	private String droitDesc;
	private BigDecimal droitBool;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Droit() {
	}

	public Droit(BigDecimal droitId) {
		this.droitId = droitId;
	}

	public Droit(BigDecimal droitId, String droitDesc, BigDecimal droitBool, Set<Employee> employees) {
		this.droitId = droitId;
		this.droitDesc = droitDesc;
		this.droitBool = droitBool;
		this.employees = employees;
	}

	public BigDecimal getDroitId() {
		return this.droitId;
	}

	public void setDroitId(BigDecimal droitId) {
		this.droitId = droitId;
	}

	public String getDroitDesc() {
		return this.droitDesc;
	}

	public void setDroitDesc(String droitDesc) {
		this.droitDesc = droitDesc;
	}

	public BigDecimal getDroitBool() {
		return this.droitBool;
	}

	public void setDroitBool(BigDecimal droitBool) {
		this.droitBool = droitBool;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
