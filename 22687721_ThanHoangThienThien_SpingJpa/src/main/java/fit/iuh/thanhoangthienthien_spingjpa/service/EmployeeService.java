package fit.iuh.thanhoangthienthien_spingjpa.service;

import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import fit.iuh.thanhoangthienthien_spingjpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

    public List<Employee> findByDepartmentId(Long id) {
        return employeeRepository.findEmployeeByDepartmentId(id);
    }

    public List<Employee> findEmployeeBySalaryBetween(int min, int max) {
        return employeeRepository.findEmployeeBySalaryBetween(min, max);
    }
}
