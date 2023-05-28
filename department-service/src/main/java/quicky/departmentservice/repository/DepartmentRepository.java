package quicky.departmentservice.repository;


import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Repository;
import quicky.departmentservice.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentRepository  {
    private List<Department> list = new ArrayList<>();

    public List<Department> findAll(){
        return list;
    }

    public Department save(Department department){
        list.add(department);
        return department;
    }

    public Department findById(Long id) {
        return list
                .stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
