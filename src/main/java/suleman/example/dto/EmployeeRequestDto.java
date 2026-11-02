package suleman.example.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Component
public class EmployeeRequestDto {

	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	private String phone;
	
	private String department;
	
	@PositiveOrZero
	private double salary;
	
	private String joiningDate;

	public EmployeeRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeRequestDto(@NotBlank String name, @NotBlank @Email String email, String phone, String department,
			@PositiveOrZero double salary, String joiningDate) {
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
