package fit.iuh.thanhoangthienthien_spingjpa;

import fit.iuh.thanhoangthienthien_spingjpa.model.Department;
import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import fit.iuh.thanhoangthienthien_spingjpa.repository.DepartmentRepository;
import fit.iuh.thanhoangthienthien_spingjpa.repository.EmployeeRepository;
import fit.iuh.thanhoangthienthien_spingjpa.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringMariaDBApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeService employeeService;

    private Department itDept;

    @BeforeEach
    void setupAllEmployees() {

        // Tạo phòng ban IT
        itDept = new Department();
        itDept.setId("D01");
        itDept.setName("IT");
        departmentRepository.save(itDept);

        // Thêm tất cả nhân viên
        Employee emp1 = new Employee("E01", "Le Hoang Anh", 1000, itDept);
        Employee emp2 = new Employee("E02", "Nguyen Van A", 1200, itDept);
        Employee emp3 = new Employee("E03", "Than Hoang Thien Thien", 1200, null);
        Employee emp4 = new Employee("E04", "Dang Phuc Nguyen", 500, null);
        Employee emp5 = new Employee("E05", "Nguyen Phan Minh Man", 1500, null);
        Employee emp6 = new Employee("E06", "Dang Gia Bao", 1000, null);
        Employee emp7 = new Employee("E07", "Pham Huu Loc", 1000, null);
        Employee emp8 = new Employee("E08", "Employee 1", 1000, itDept);
        Employee emp9 = new Employee("E09", "Employee 2", 1500, itDept);

        employeeRepository.saveAll(List.of(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9));
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee();
        emp.setId("E10");
        emp.setName("New Employee");
        emp.setSalary(2000);
        emp.setDepartment(itDept);

        Employee saved = employeeService.save(emp);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isEqualTo("E10");
    }

    @Test
    void testFindByDepartmentId() {
        List<Employee> employees = employeeRepository.findByDepartment_Id(itDept.getId());
        assertThat(employees).isNotEmpty();
        assertThat(employees.get(0).getDepartment().getName()).isEqualTo("IT");
    }

    @Test
    void testFindByName() {
        List<Employee> employees = employeeRepository.findByNameContaining("Thien");
        assertThat(employees).isNotEmpty();
        assertThat(employees.get(0).getName()).contains("Thien");
    }

    @Test
    void testFindBySalaryBetween() {
        List<Employee> employees = employeeRepository.findBySalaryBetween(400, 1000);
        assertThat(employees).isNotEmpty();
        for (Employee e : employees) {
            assertThat(e.getSalary()).isBetween(400.0, 1000.0);
        }
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = employeeRepository.findById("E06").orElse(null);
        assertThat(emp).isNotNull();

        emp.setName("Pham Hoang Phat");
        emp.setSalary(2000);
        Employee updated = employeeService.save(emp);

        assertThat(updated.getName()).isEqualTo("Pham Hoang Phat");
        assertThat(updated.getSalary()).isEqualTo(2000);
    }

    @Test
    void testDeleteEmployee() {
        Employee emp = employeeRepository.findById("E07").orElse(null);
        assertThat(emp).isNotNull();

        employeeService.deleteById(emp.getId());
        Employee deleted = employeeRepository.findById(emp.getId()).orElse(null);
        assertThat(deleted).isNull();
    }

    @Test
    void testFindAllEmployees() {
        List<Employee> all = employeeService.findAll();
        assertThat(all.size()).isGreaterThanOrEqualTo(9);
    }
}
