package quicky.departmentservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import quicky.departmentservice.client.EmployeeClient;
import quicky.departmentservice.model.Department;
import quicky.departmentservice.model.Employee;
import quicky.departmentservice.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentRepository repository;

    private EmployeeClient employeeClient;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Department addDepartment(Department department){
        LOGGER.info("department at: {}",department);
        return (Department) repository.save(department);
    }
    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("department find");
        return  repository.findAll();
    }
    @GetMapping("/{id}")
    public Department findDepartment(@PathVariable Long id){
        LOGGER.info("Department find by id: {}",id);
        return repository.findById(id);
    }
    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments
                = repository.findAll();
        departments.forEach(department ->
                department.setEmployees(
                        employeeClient.findByDepartment(department.getId())));
        return  departments;
    }
}
