package fit.iuh.thanhoangthienthien_springmongodb.controller;

import fit.iuh.thanhoangthienthien_springmongodb.model.Department;
import fit.iuh.thanhoangthienthien_springmongodb.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/dept/ds")
    public List<Department> getAllDepartments() {
        return departmentService.getAll();
    }

    @GetMapping("/dept/{deptId}")
    public Department getByDeptId(@PathVariable String deptId) {
        return departmentService.getByDeptId(deptId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @PutMapping("/update/{deptId}")
    public Department updateDepartment(@PathVariable String deptId, @RequestBody Department department) {
        department.setDeptId(deptId);
        return departmentService.save(department);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable String id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok("Deleted department with ID: " + id);
    }
}
