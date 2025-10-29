package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import fit.iuh.thanhoangthienthien_tuan07.services.CategoryService;
import fit.iuh.thanhoangthienthien_tuan07.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // Đường dẫn thư mục upload được cấu hình trong application.properties
    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    // Hiển thị toàn bộ sản phẩm
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product/products";
    }

    // Chi tiết sản phẩm
    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product/product-detail";
    }

    // Hiển thị form thêm sản phẩm
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "product/product-form";
    }

    // Lưu sản phẩm mới
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product,
                             @RequestParam("fileImage") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            // Lấy tên file duy nhất
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            // Đường dẫn tuyệt đối đến thư mục static/uploads trong target
            Path uploadPath = Paths.get("src/main/resources/static/uploads/");

            // Tạo thư mục nếu chưa có
            Files.createDirectories(uploadPath);

            // Sao chép file
            file.transferTo(uploadPath.resolve(fileName).toFile());

            // Gán tên file cho Product
            product.setImage(fileName);
        }

        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Hiển thị form chỉnh sửa sản phẩm
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "product/product-form";
    }

    // Cập nhật sản phẩm
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, @ModelAttribute Product product,
                              @RequestParam("fileImage") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path uploadPath = Paths.get(uploadDir);
            Files.createDirectories(uploadPath);
            file.transferTo(uploadPath.resolve(fileName));
            product.setImage(fileName);
        } else {
            // Giữ lại hình ảnh hiện có
            Product existing = productService.getProductById(id);
            if (existing != null) {
                product.setImage(existing.getImage());
            }
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Xóa sản phẩm
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    // Tìm kiếm sản phẩm
    @GetMapping("/search")
    public String searchProducts(@RequestParam String name, Model model) {
        List<Product> products = productService.searchByName(name);
        model.addAttribute("products", products);
        model.addAttribute("keyword", name);
        return "product/products";
    }
}
