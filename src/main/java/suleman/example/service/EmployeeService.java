package suleman.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import suleman.example.dto.EmployeeRequestDto;
import suleman.example.dto.EmployeeResponseDto;
import suleman.example.dto.EmployeeUpdateRequestDto;
import suleman.example.entity.Employee;
import suleman.example.exception.EmployeeAllReadyExist;
import suleman.example.exception.EmployeeNotFoundException;
import suleman.example.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private final EmployeeRepo employeerepo;
	

	public EmployeeService(EmployeeRepo employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}

	public EmployeeResponseDto createEmployee(EmployeeRequestDto request) {
		if(employeerepo.existsByEmail(request.getEmail())) {
			throw new EmployeeAllReadyExist("Employee Allready Exist with this email: " + request.getEmail());
		}
		Employee  employee  = new Employee();
		
		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setDepartment(request.getDepartment());
		employee.setPhone(request.getPhone());
		employee.setSalary(request.getSalary());
		employee.setJoiningDate(request.getJoiningDate());
		
		Employee emp = employeerepo.save(employee);
		
		return new EmployeeResponseDto(emp);
	}
	
	public Page<EmployeeResponseDto> getAllEmployee(Pageable pageable){
		Page<Employee> all = employeerepo.findAll(pageable);
		Page<EmployeeResponseDto> response = all.map(EmployeeResponseDto::new);
		return response;
	}
	
	
	public EmployeeResponseDto updateEmployee(EmployeeRequestDto request , int id) {
		
		Employee employee = employeerepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee dose not exist with this id: " + id));	
	
		if(!employee.getEmail().equals(request.getEmail()) && employeerepo.existsByEmail(request.getEmail())) {
			throw new EmployeeAllReadyExist("Email Allready used");
		}
		employee.setName(request.getName());
		employee.setEmail(request.getEmail());
		employee.setDepartment(request.getDepartment());
		employee.setPhone(request.getPhone());
		employee.setSalary(request.getSalary());
		employee.setJoiningDate(request.getJoiningDate());
		
		Employee emp = employeerepo.save(employee);
		
		return new EmployeeResponseDto(emp);
	}
	
	public EmployeeResponseDto partialUpdateEmployee(EmployeeUpdateRequestDto request , int id) {
		
		Employee employee = employeerepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee dose not exist with this id: " + id));	
	
		  if (request.getEmail() != null
		            && !employee.getEmail().equals(request.getEmail())
		            && employeerepo.existsByEmail(request.getEmail())) {

		        throw new EmployeeAllReadyExist("Email Already used");
		    }

		
		if(request.getName() != null) {
			employee.setName(request.getName());
		}
		
		if(request.getEmail() != null) {			
			employee.setEmail(request.getEmail());
		}
		
		if(request.getDepartment() != null) {
			employee.setDepartment(request.getDepartment());
		}
		if(request.getPhone() != null) {
			employee.setPhone(request.getPhone());
		}
		if(request.getSalary() != null) {
			employee.setSalary(request.getSalary());
		}
		if(request.getJoiningDate() != null) {
			employee.setJoiningDate(request.getJoiningDate());
		}
		
		Employee emp = employeerepo.save(employee);
		
		return new EmployeeResponseDto(emp);
	}
	
	public String deleteEmployee(int id) {
		employeerepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee dose not exist with this id: " + id));
		employeerepo.deleteById(id);
		return "Employee deleted successfully whith this id: " + id;
	}
	
//	Searching and filtering start here only
	
	
	public Page<EmployeeResponseDto> findEmployeesByNameSalaryDepartment(String name , Double salary , String department , Pageable pageable) {
		Page<Employee> employeeByNameSalaryDepartment = employeerepo.findEmployeeByNameSalaryDepartment(name, salary, department, pageable);
		Page<EmployeeResponseDto> employeedata = employeeByNameSalaryDepartment.map(EmployeeResponseDto::new);
		return  employeedata;
		
		
		
	}
	
	
}
