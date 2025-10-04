package fit.iuh.repository;

import fit.iuh.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmpNameContaining(String name);
    List<Employee> findByAge(int age);
    List<Employee> findBySalaryBetween(double min, double max);
    List<Employee> findByDepartment_DeptId(String deptId); // tìm theo phòng ban
}
