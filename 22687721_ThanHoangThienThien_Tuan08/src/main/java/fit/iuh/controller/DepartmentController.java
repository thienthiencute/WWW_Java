package fit.iuh.controller;

import fit.iuh.model.Department;
import fit.iuh.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // Hiển thị danh sách
    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "departments/list";
    }

    // Form thêm mới
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("department", new Department());
        return "departments/form";
    }

    // Form sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Department dept = departmentService.findById(id);
        model.addAttribute("department", dept);
        return "departments/form";
    }

    // Lưu (thêm hoặc sửa)
    @PostMapping("/save")
    public String save(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        departmentService.deleteById(id);
        return "redirect:/departments";
    }
}
