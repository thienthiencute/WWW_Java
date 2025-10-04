package fit.iuh.thanhoangthienthien_spingjpa.service;

import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import fit.iuh.thanhoangthienthien_spingjpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    // Lấy tất cả nhân viên
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    // Lấy nhân viên theo ID
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Tìm theo tên
    public List<Employee> findByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    // Tìm theo phòng ban
    public List<Employee> findByDepartmentId(String departmentId) {
        return employeeRepository.findByDepartment_Id(departmentId);
    }

    // Tìm theo khoảng lương
    public List<Employee> findEmployeeBySalaryBetween(double min, double max) {
        return employeeRepository.findBySalaryBetween(min, max);
    }

    // Thêm hoặc sửa nhân viên
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Xóa nhân viên theo ID
    public void deleteById(String id) {
        employeeRepository.deleteById(id);
    }
}
