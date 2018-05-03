package com.learn.dto;

public class Associates {
	
	private String desgination;
	private String role;
	private String salary;
	
	public String getDesgination() {
		return desgination;
	}
	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Associates [desgination=" + desgination + ", role=" + role + ", salary=" + salary + "]";
	}
	
	
}
