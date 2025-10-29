package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.Comment;
import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import fit.iuh.thanhoangthienthien_tuan07.services.CommentService;
import fit.iuh.thanhoangthienthien_tuan07.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products/{productId}/comments")
public class CommentController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CommentService commentService;

    // Hiển thị form thêm comment
    @GetMapping("/add")
    public String showCommentForm(@PathVariable Integer productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        model.addAttribute("comment", new Comment());
        return "product/comment-form";
    }

    // Xử lý thêm comment
    @PostMapping("/add")
    public String addComment(@PathVariable Integer productId, @ModelAttribute Comment comment) {
        Product product = productService.getProductById(productId);
        comment.setProduct(product);
        commentService.saveComment(comment);
        return "redirect:/products/detail/" + productId;
    }
}
