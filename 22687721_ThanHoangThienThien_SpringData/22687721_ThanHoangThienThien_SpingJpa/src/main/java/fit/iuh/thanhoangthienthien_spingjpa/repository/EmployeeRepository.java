package fit.iuh.thanhoangthienthien_spingjpa.repository;

import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    // Tìm nhân viên theo phòng ban
    List<Employee> findByDepartment_Id(String departmentId);

    // Tìm nhân viên theo tên chứa chuỗi
    List<Employee> findByNameContaining(String name);

    // Tìm nhân viên theo khoảng lương
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);

    // Tìm nhân viên theo mức lương chính xác
    List<Employee> findBySalary(double salary);
}
