package fit.iuh.service;

import fit.iuh.model.Department;
import fit.iuh.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department save(Department dept) {
        return departmentRepository.save(dept);
    }

    public void deleteById(String id) {
        departmentRepository.deleteById(id);
    }

    public Department findById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }
}
