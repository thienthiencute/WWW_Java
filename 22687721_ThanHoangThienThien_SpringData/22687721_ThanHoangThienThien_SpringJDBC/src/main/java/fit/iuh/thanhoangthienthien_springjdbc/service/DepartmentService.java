package fit.iuh.thanhoangthienthien_springjdbc.service;

import fit.iuh.thanhoangthienthien_springjdbc.model.Department;
import fit.iuh.thanhoangthienthien_springjdbc.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DepartmentService {
    private DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public List<Department> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
