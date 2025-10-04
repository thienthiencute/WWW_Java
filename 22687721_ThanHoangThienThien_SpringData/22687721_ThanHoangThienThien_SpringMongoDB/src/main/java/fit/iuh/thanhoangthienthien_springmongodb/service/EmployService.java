package fit.iuh.thanhoangthienthien_springmongodb.service;

import fit.iuh.thanhoangthienthien_springmongodb.model.Employee;
import fit.iuh.thanhoangthienthien_springmongodb.repository.EmployeeRepositoty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployService {
    private final EmployeeRepositoty repo;

    public EmployService(EmployeeRepositoty repo) {
        this.repo = repo;
    }

    public List<Employee> findByNameContainingIgnoreCase(String empName) {
        return repo.findByEmpNameContainingIgnoreCase(empName);
    }

    public List<Employee> findByAge(int age) {
        return repo.findByAge(age);
    }

    public List<Employee> findBySalaryBetween(double min, double max) {
        return repo.findBySalaryBetween(min, max);
    }

    public Employee findById(String id) {
        Optional<Employee> em = repo.findById(id);
        return em.orElse(null);
    }

    public Employee getByEmpId(String empId) {
        return repo.findByEmpId(empId);
    }

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public List<Employee> findByDeptId(String deptId) {
        return repo.findByDeptId(deptId);
    }

    public Employee save(Employee em) {
        repo.save(em);
        return em;
    }

    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
