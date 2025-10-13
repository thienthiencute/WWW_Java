package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.Comment;
import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import fit.iuh.thanhoangthienthien_tuan07.services.CommentService;
import fit.iuh.thanhoangthienthien_tuan07.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final ProductService productService;

    @PostMapping("/add")
    public String addComment(@RequestParam Integer productId, @RequestParam String text) {
        Product product = productService.findById(productId);
        if (product != null) {
            Comment comment = Comment.builder()
                    .text(text)
                    .product(product)
                    .build();
            commentService.save(comment);
        }
        return "redirect:/product/" + productId;
    }

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable Integer id, @RequestParam Integer productId) {
        commentService.deleteById(id);
        return "redirect:/product/" + productId;
    }

}
