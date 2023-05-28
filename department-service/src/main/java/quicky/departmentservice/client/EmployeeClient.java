package quicky.departmentservice.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import quicky.departmentservice.model.Employee;

import java.util.List;

public interface EmployeeClient {
    @GetExchange("/employee/department/{deparmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
}
