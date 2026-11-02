package suleman.example.dto;

import suleman.example.entity.Employee;

public class EmployeeResponseDto {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String department;
	private double salary;
	private String joiningDate;
	
	
	
	public EmployeeResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public EmployeeResponseDto(int id, String name, String email, String phone, String department, double salary,
			String joiningDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	
	public EmployeeResponseDto(Employee employee) {
	    this.id = employee.getId();
	    this.name = employee.getName();
	    this.email = employee.getEmail();
	    this.phone = employee.getPhone();
	    this.department = employee.getDepartment();
	    this.salary = employee.getSalary();
	    this.joiningDate = employee.getJoiningDate();
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public String getJoiningDate() {
		return joiningDate;
	}



	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	
	
	
	

}
