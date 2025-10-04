package fit.iuh.thanhoangthienthien_springmongodb.repository;

import fit.iuh.thanhoangthienthien_springmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoty extends MongoRepository<Employee, String> {
    // find ten
    List<Employee> findByEmpNameContainingIgnoreCase(String empName);

    // find tuoi
    List<Employee> findByAge(int age);

    // find luong
    List<Employee> findBySalaryBetween(double min, double max);

    // find empId
    Employee findByEmpId(String empId);

    // find deptId
    List<Employee> findByDeptId(String deptId);
}
