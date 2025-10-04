package fit.iuh.thanhoangthienthien_springjdbc.controller;

import fit.iuh.thanhoangthienthien_springjdbc.model.Employee;
import fit.iuh.thanhoangthienthien_springjdbc.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/ds")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{deptId}")
    public List<Employee> findByDeptId(@PathVariable("deptId") String deptId) {
        return employeeService.findByDeptId(deptId);
    }
    //@DeleteMapping
    @GetMapping("/delete/{empId}")
    public String deleteById(@PathVariable("empId") String empId) {
        employeeService.deleteById(empId);
        return "Deleted employee by ID " + empId;
    }
    // thêm
    //@GetMapping
    @PostMapping("/employee")
    public Employee create(@RequestBody Employee emp) {
        employeeService.save(emp);
        return emp;
    }
    // sửa
    //@GetMapping
    @PutMapping("/employee/{empId}")
    public Employee update(@PathVariable String empId, @RequestBody Employee emp) {
        emp.setEmpId(empId);
        employeeService.save(emp);
        return emp;
    }

    @GetMapping("/search/name/{name}")
    public List<Employee> searchByName(@PathVariable String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/search/age/{age}")
    public List<Employee> searchByAge(@PathVariable int age) {
        return employeeService.getByAge(age);
    }

    // Tìm theo khoảng lương
    @GetMapping("/search/salary/between")
    public List<Employee> searchBySalaryBetween(@RequestParam double min, @RequestParam double max) {
        return employeeService.getBySalaryBetween(min, max);
    }
}
