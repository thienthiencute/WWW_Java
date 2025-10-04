package fit.iuh.thanhoangthienthien_springjdbc.repository;

import fit.iuh.thanhoangthienthien_springjdbc.model.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    @Query("SELECT * FROM Employee WHERE deptId = :deptId")
    List<Employee> findByDeptId(String deptId);

    // find tên
    List<Employee> findByEmpNameContainingIgnoreCase(String empName);

    // find  tuổi
    List<Employee> findByAge(int age);

    // find lương
    List<Employee> findBySalaryBetween(double min, double max);
}
