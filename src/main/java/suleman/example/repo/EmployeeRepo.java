package suleman.example.repo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import suleman.example.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee , Integer> {
	
	boolean existsByEmail(String email);
	
	@Query(""" 
			SELECT e FROM Employee e WHERE 
			(:name IS NULL OR e.name = :name) AND 
			(:salary  IS NULL OR e.salary  = :salary) AND 
			(:department  IS NULL OR e.department = : department) 
	     """)
	Page<Employee> findEmployeeByNameSalaryDepartment(String name , Double salary , String department , Pageable pageable);
	
	

}
