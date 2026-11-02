package suleman.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PositiveOrZero;

public class EmployeeUpdateRequestDto {
	
	private String name;
	
	@Email
	private String email;
	
	private String phone;
	
	private String department;
	
	@PositiveOrZero
	private Double salary;
	
	private String joiningDate;
	
	

	public EmployeeUpdateRequestDto() {
		super();
	}

	public EmployeeUpdateRequestDto(String name, String email, String phone, String department,
			 Double salary, String joiningDate) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	


}
