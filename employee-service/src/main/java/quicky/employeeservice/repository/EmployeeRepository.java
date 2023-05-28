package quicky.employeeservice.repository;

import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Repository;
import quicky.employeeservice.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> list = new ArrayList<>();

    public List<Employee> findAll(){
        return list;
    }

    public Employee save(Employee employee){
        list.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return list
                .stream()
                .filter(employee -> employee.id().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    public List<Employee> findByDepartment(Long departmentId) {
        return list.stream()
                .filter(a -> a.deparment().equals(departmentId))
                .toList();
    }
}
