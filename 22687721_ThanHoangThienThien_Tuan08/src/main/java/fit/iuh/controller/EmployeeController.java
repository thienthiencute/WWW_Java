package fit.iuh.controller;

import fit.iuh.model.Employee;
import fit.iuh.model.Department;
import fit.iuh.service.EmployeeService;
import fit.iuh.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    // 1. Hiển thị danh sách nhân viên
    @GetMapping
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list";
    }

    // 2. Hiển thị form thêm nhân viên
    @GetMapping("/add")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.findAll());
        return "employees/form"; // form chung add/edit
    }

    // 3. Lưu nhân viên mới
    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute Employee employee) {
        // Lấy Department thực từ DB
        if (employee.getDepartment() != null && employee.getDepartment().getDeptId() != null) {
            Department dept = departmentService.findById(employee.getDepartment().getDeptId());
            employee.setDepartment(dept);
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    // 4. Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable String id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.findAll());
        return "employees/form"; // dùng chung form add/edit
    }

    // 5. Cập nhật nhân viên
    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable String id, @ModelAttribute Employee employee) {
        employee.setEmpId(id);
        // Lấy Department thực từ DB
        if (employee.getDepartment() != null && employee.getDepartment().getDeptId() != null) {
            Department dept = departmentService.findById(employee.getDepartment().getDeptId());
            employee.setDepartment(dept);
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    // 6. Xóa nhân viên
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    // 7. Tìm kiếm nâng cao (theo tên, tuổi, khoảng lương)
    @GetMapping("/filter")
    public String filterEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Double minSalary,
            @RequestParam(required = false) Double maxSalary,
            Model model
    ) {
        List<Employee> employees = employeeService.findAll();

        if (name != null && !name.isEmpty()) {
            employees = employees.stream()
                    .filter(e -> e.getEmpName().toLowerCase().contains(name.toLowerCase()))
                    .toList();
        }

        if (age != null) {
            employees = employees.stream()
                    .filter(e -> e.getAge() == age)
                    .toList();
        }

        if (minSalary != null && maxSalary != null) {
            employees = employees.stream()
                    .filter(e -> e.getSalary() >= minSalary && e.getSalary() <= maxSalary)
                    .toList();
        }

        model.addAttribute("employees", employees);
        return "employees/list";
    }

    // 8. Hiển thị danh sách nhân viên theo phòng ban (quan hệ 1 - nhiều)
    @GetMapping("/department/{deptId}")
    public String listByDepartment(@PathVariable String deptId, Model model) {
        List<Employee> employees = employeeService.findByDepartmentId(deptId);
        Department dept = departmentService.findById(deptId);
        model.addAttribute("employees", employees);
        model.addAttribute("department", dept);
        return "employees/list-by-department";
    }
}
