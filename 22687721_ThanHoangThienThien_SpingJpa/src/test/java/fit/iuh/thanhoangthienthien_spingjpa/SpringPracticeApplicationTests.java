package fit.iuh.thanhoangthienthien_spingjpa;

import fit.iuh.thanhoangthienthien_spingjpa.model.Department;
import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import fit.iuh.thanhoangthienthien_spingjpa.repository.DepartmentRepository;
import fit.iuh.thanhoangthienthien_spingjpa.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringPracticeApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindByDepartmentId() {
        // Tạo department test
        Department dept = new Department();
        dept.setName("IT");
        departmentRepository.save(dept);

        // Tạo employee test
        Employee emp = new Employee();
        emp.setName("Le Hoang Anh");
        emp.setSalary(1000);
        emp.setDepartment(dept);
        employeeRepository.save(emp);

        // Kiểm tra repository
        List<Employee> employees = employeeRepository.findByDepartment_Id(dept.getId());
        assertThat(employees).isNotEmpty();
        assertThat(employees.get(0).getName()).isEqualTo("Le Hoang Anh");
    }

    @Test
    void testFindByName() {
        Employee emp = new Employee();
        emp.setName("Than Hoang Thien Thien");
        emp.setSalary(1200);
        employeeRepository.save(emp);

        List<Employee> employees = employeeRepository.findEmployeeByName("Than Hoang Thien Thien");
        assertThat(employees).isNotEmpty();
        assertThat(employees.get(0).getName()).isEqualTo("Than Hoang Thien Thien");
    }

    @Test
    void testFindBySalaryBetween() {
        Employee emp1 = new Employee();
        emp1.setName("Dang Phuc Nguyen");
        emp1.setSalary(500);
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setName("Nguyen Phan Minh Man");
        emp2.setSalary(1500);
        employeeRepository.save(emp2);

        List<Employee> employees = employeeRepository.findEmployeeBySalaryBetween(400, 1000);
        assertThat(employees).isNotEmpty();
        assertThat(employees.get(0).getSalary()).isBetween(400.0, 1000.0);
    }
}
