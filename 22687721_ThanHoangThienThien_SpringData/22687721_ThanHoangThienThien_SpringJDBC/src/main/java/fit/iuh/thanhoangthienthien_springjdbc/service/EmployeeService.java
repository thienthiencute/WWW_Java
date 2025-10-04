package fit.iuh.thanhoangthienthien_springjdbc.service;

import fit.iuh.thanhoangthienthien_springjdbc.model.Employee;
import fit.iuh.thanhoangthienthien_springjdbc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;


    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public void save(Employee employee) {
        repo.save(employee);
    }

    public Employee getById(String empId) {
        return repo.findById(empId).orElse(null);
    }

    public List<Employee> getAll() {
        return StreamSupport.stream(repo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteById(String empId) {
        repo.deleteById(empId);
    }

    public List<Employee> findByDeptId(String deptId) {
        return repo.findByDeptId(deptId);
    }

    public List<Employee> findByName(String empName) {
        return repo.findByEmpNameContainingIgnoreCase(empName);
    }

    public List<Employee> getByAge(int age) {
        return repo.findByAge(age);
    }

    public List<Employee> getBySalaryBetween(double min, double max) {
         return repo.findBySalaryBetween(min, max);
    }
}