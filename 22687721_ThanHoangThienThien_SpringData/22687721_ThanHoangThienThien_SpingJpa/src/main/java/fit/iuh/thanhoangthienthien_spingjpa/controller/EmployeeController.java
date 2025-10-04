package fit.iuh.thanhoangthienthien_spingjpa.controller;

import fit.iuh.thanhoangthienthien_spingjpa.model.Employee;
import fit.iuh.thanhoangthienthien_spingjpa.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    // GET: Lấy tất cả nhân viên
    @GetMapping
    public ResponseEntity<List<Employee>> findByEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    // GET: Lấy nhân viên theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable String id) {
        Employee emp = employeeService.findById(id);
        return emp != null ? ResponseEntity.ok(emp) : ResponseEntity.notFound().build();
    }

    // GET: Tìm nhân viên theo tên
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(employeeService.findByName(name));
    }

    // GET: Tìm nhân viên theo phòng ban
    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> findByDepartmentId(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.findByDepartmentId(id));
    }

    // GET: Tìm nhân viên theo khoảng lương
    @GetMapping("/salary-between/{min}/{max}")
    public ResponseEntity<List<Employee>> findEmployeeBySalaryBetween(@PathVariable int min, @PathVariable int max) {
        return ResponseEntity.ok(employeeService.findEmployeeBySalaryBetween(min, max));
    }

    // POST: Thêm nhân viên mới
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    // PUT: Cập nhật nhân viên theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        Employee existing = employeeService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        employee.setId(id); // giữ id cũ
        return ResponseEntity.ok(employeeService.save(employee));
    }

    // DELETE: Xóa nhân viên theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        Employee existing = employeeService.findById(id);
        if (existing == null) return ResponseEntity.notFound().build();
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
