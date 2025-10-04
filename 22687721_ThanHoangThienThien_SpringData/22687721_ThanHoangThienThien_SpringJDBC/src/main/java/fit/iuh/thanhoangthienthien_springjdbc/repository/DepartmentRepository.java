package fit.iuh.thanhoangthienthien_springjdbc.repository;

import fit.iuh.thanhoangthienthien_springjdbc.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
    List<Department> findAll();
}
