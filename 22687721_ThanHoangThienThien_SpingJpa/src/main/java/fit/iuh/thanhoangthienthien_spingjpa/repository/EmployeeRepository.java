package fit.iuh.thanhoangthienthien_spingjpa.repository;

import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment_Id(Long departmentId);

    List<Employee> findBySalary(double salary);

    List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeeByDepartmentId(Long departmentId);

    List<Employee> findEmployeeBySalaryBetween(double salaryAfter, double salaryBefore);

}
