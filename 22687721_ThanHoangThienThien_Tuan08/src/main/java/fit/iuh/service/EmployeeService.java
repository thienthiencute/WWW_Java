package fit.iuh.service;

import fit.iuh.model.Employee;
import fit.iuh.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CRUD cơ bản
    public List<Employee> findAll() { return employeeRepository.findAll(); }
    public Employee findById(String id) { return employeeRepository.findById(id).orElse(null); }
    public Employee save(Employee emp) { return employeeRepository.save(emp); }
    public void deleteById(String id) { employeeRepository.deleteById(id); }

    // Tìm kiếm nâng cao
    public List<Employee> findByName(String name) { return employeeRepository.findByEmpNameContaining(name); }
    public List<Employee> findByAge(int age) { return employeeRepository.findByAge(age); }
    public List<Employee> findBySalaryRange(double min, double max) { return employeeRepository.findBySalaryBetween(min, max); }

    // Tìm theo phòng ban
    public List<Employee> findByDepartmentId(String deptId) { return employeeRepository.findByDepartment_DeptId(deptId); }
}
