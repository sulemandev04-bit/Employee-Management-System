package suleman.example.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import suleman.example.dto.EmployeeRequestDto;
import suleman.example.dto.EmployeeResponseDto;
import suleman.example.dto.EmployeeUpdateRequestDto;
import suleman.example.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private final EmployeeService employeeservice;
	
	public EmployeeController(EmployeeService employeeservice) {
		this.employeeservice = employeeservice;
	}
	

	@Operation(
		    summary = "Create a new employee",
		    description = "Creates a new employee after validating the email"
		)
	
	@PostMapping("/employees")
	public ResponseEntity<EmployeeResponseDto> saveEmployee(@Valid @RequestBody EmployeeRequestDto dto){
		EmployeeResponseDto employee = employeeservice.createEmployee(dto);
		return new ResponseEntity<>(employee , HttpStatus.CREATED);
		
		
	}
	
	@Operation(
		    summary = "Get all employees",
		    description = "Returns paginated and sorted employee data"
		)
	
	@GetMapping("/employees")
	public ResponseEntity<Page<EmployeeResponseDto>> getemployee(Pageable pageable){
		Page<EmployeeResponseDto> allEmployee = employeeservice.getAllEmployee(pageable);
		return new ResponseEntity<>(allEmployee , HttpStatus.OK);
	}

	@Operation(summary = "Get employee by ID")
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200",
	        description = "Employee found successfully"
	    ),
	    @ApiResponse(
	        responseCode = "404",
	        description = "Employee not found"
	    )
	})
	@GetMapping("/employees/{id}")
	public ResponseEntity<String> getEmpByID(@PathVariable int id){
		
		String summary = employeeservice.getEmployeeById(id);
		return ResponseEntity.ok(summary);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponseDto> updateEmp(@Valid @RequestBody EmployeeRequestDto dto , @PathVariable int id){
		EmployeeResponseDto updateEmployee = employeeservice.updateEmployee(dto, id);
		return new ResponseEntity<>(updateEmployee , HttpStatus.OK);
	}
	
	@PatchMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponseDto> partialUpdateEmployee(@Valid @RequestBody EmployeeUpdateRequestDto dto ,  @PathVariable int id){
		EmployeeResponseDto partialUpdateEmployee = employeeservice.partialUpdateEmployee(dto, id);
		return new ResponseEntity<>(partialUpdateEmployee , HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteemp(@PathVariable int id) {
		String deleteEmployee = employeeservice.deleteEmployee(id);
		return new ResponseEntity<>(deleteEmployee , HttpStatus.OK);
		
	}
	
	@GetMapping("/employees/department/{department}")
	public Page<EmployeeResponseDto> getEmployeeByDepartmentName(@PathVariable String department , Pageable pageable){
		Page<EmployeeResponseDto> employeByDepatment = employeeservice.findEmployeesByDepartment(department, pageable);
		return employeByDepatment;
	}
	
	
	@Operation(
		    summary = "Search employees by name",
		    description = "Search employees using name"
		)
	@GetMapping("/employees/search")
	public Page<EmployeeResponseDto> getEmployeeByNamelikeOperater(@RequestParam  String name , Pageable pageable){
		Page<EmployeeResponseDto> searchEmployeeUsingLikeOperator = employeeservice.findEmployeesByName(name, pageable);
		return searchEmployeeUsingLikeOperator;
	}
	
	@Operation(
		    summary = "Filter employees by salary range",
		    description = "Returns employees whose salary falls between minimum and maximum salary"
		)
	
	@GetMapping("/employees/filter")
	public Page<EmployeeResponseDto> getEmployeeBySlararange(@RequestParam double minSalary , @RequestParam double maxSalary , Pageable pageable){
		Page<EmployeeResponseDto> employeeBasedOnSalaryRange = employeeservice.findEmployeesBySalaryRange(minSalary, maxSalary, pageable);
		return employeeBasedOnSalaryRange;
	}
	

}
