package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import fit.iuh.thanhoangthienthien_tuan07.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Hiển thị danh sách tất cả sản phẩm
    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> productlist = productService.findAll();
        model.addAttribute("products", productlist);
        return "product/list";
    }

    // Hiển thị chi tiết sản phẩm theo id
    @GetMapping("/{id}")
    public String showProduct(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/productdetail";
    }
}
