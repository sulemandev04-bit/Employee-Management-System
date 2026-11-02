package suleman.example.service;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import suleman.example.entity.Employee;
@Service
public class AiService {

	private final OllamaChatModel chatmodel;

	public AiService(OllamaChatModel chatmodel) {
		super();
		this.chatmodel = chatmodel;
	}
	
	public String genrateEmployeeSummary(Employee employee) {
		
		String prompt = """
		        Create a professional employee profile summary.

		        Employee Name: %s
		        Employee Email: %s
		        Department: %s
		        Joining Date: %s
		        Salary: %s

		        Keep the summary professional and concise.
		        """.formatted(
		        employee.getName(),
		        employee.getEmail(),
		        employee.getDepartment(),
		        employee.getJoiningDate(),
		        employee.getSalary()
		);


		return chatmodel.call(prompt);
	}



}
