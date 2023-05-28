package quicky.employeeservice.controller;


import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import quicky.employeeservice.model.Employee;
import quicky.employeeservice.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee addDepartment(Employee employee){
        LOGGER.info("employee at: {}",employee);
        return (Employee) repository.save(employee);
    }
    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("department find");
        return  repository.findAll();
    }
    @GetMapping("/{id}")
    public Employee findDepartment(@PathVariable Long id){
        LOGGER.info("Department find by id: {}",id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId){
        LOGGER.info("employee find by department id :{}",departmentId);
        return repository.findByDepartment(departmentId);
    }
}
