package com.reshma.spring.boot.Sample1;

public class Employee {
	private Integer empNo;
	private Integer deptNo;
	private String name;
	private String job;
	private Double salary;

	public Employee() {
	}

	public Employee(Integer empNo, Integer deptNo, String name, String job, Double salary) {
		super();
		this.empNo = empNo;
		this.deptNo = deptNo;
		this.name = name;
		this.job = job;
		this.salary = salary;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", deptNo=" + deptNo + ", name=" + name + ", job=" + job + ", salary="
				+ salary + "]";
	}

}