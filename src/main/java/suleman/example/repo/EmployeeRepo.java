package suleman.example.repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import suleman.example.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee , Integer> {
	
	boolean existsByEmail(String email);
	Page<Employee> findByDepartment(String department , Pageable pageable);
	Page<Employee> findByNameContaining(String name , Pageable pageable);
	Page<Employee> findBySalaryBetween(double minSalary , double maxSalary , Pageable pageable);
	

}
