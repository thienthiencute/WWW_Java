package fit.iuh.thanhoangthienthien_springmongodb.controller;

import fit.iuh.thanhoangthienthien_springmongodb.model.Employee;
import fit.iuh.thanhoangthienthien_springmongodb.service.EmployService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private final EmployService employService;

    public EmployeeController(EmployService employService) {
        this.employService = employService;
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> findByNameContainingIgnoreCase(String empName) {
        return employService.findByNameContainingIgnoreCase(empName);
    }

    @GetMapping("/employee/age/{age}")
    public List<Employee> findByAge(int age) {
        return employService.findByAge(age);
    }

    @GetMapping("/employee/salary")
    public List<Employee> findBySalaryBetween(double min, double max) {
        return employService.findBySalaryBetween(min, max);
    }

    @GetMapping("/employee/{id}")
    public Employee findById(@PathVariable("id") String id) {
        return employService.findById(id);
    }

    @GetMapping("/employee/{empId}")
    public Employee findByEmpId(@PathVariable("empId") String empId) {
        return employService.getByEmpId(empId);
    }

    @GetMapping("/employee/ds")
    public List<Employee> findAll() {
        return employService.findAll();
    }

    @GetMapping("/dept/{deptId}")
    public List<Employee> findByDeptId(@PathVariable("deptId") String deptId) {
        return employService.findByDeptId(deptId);
    }

    @PostMapping
    public Employee save(@RequestBody Employee em) {
        return employService.save(em);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable("id") String id, @RequestBody Employee em){
        em.setEmpId(id);
        return employService.save(em);
    };

    @GetMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        employService.deleteById(id);
        return ResponseEntity.ok("Deleted employee with ID: " + id);
    }
}
