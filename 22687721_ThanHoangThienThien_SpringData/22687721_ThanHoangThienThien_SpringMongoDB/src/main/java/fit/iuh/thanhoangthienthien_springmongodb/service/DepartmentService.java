package fit.iuh.thanhoangthienthien_springmongodb.service;

import fit.iuh.thanhoangthienthien_springmongodb.model.Department;
import fit.iuh.thanhoangthienthien_springmongodb.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }
    public Department save(Department department) {
        return repo.save(department);
    }

    public List<Department> getAll() {
        return repo.findAll();
    }

    public Department getByDeptId(String deptId) {
        return repo.findByDeptId(deptId);
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
