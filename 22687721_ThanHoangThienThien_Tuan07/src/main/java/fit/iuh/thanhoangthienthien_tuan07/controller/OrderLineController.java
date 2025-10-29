package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.OrderLine;
import fit.iuh.thanhoangthienthien_tuan07.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orderlines")
public class OrderLineController {
    @Autowired
    private OrderLineService orderLineService;

    // Hiển thị tất cả chi tiết hóa đơn
    @GetMapping
    public String listOrderLines(Model model) {
        List<OrderLine> orderLines = orderLineService.getAllOrderLines();
        model.addAttribute("orderlines", orderLines);
        return "order/orderlines";
    }

    // Hiển thị chi tiết theo order
    @GetMapping("/order/{orderId}")
    public String listByOrder(@PathVariable Integer orderId, Model model) {
        List<OrderLine> orderLines = orderLineService.getOrderLinesByOrderId(orderId);
        model.addAttribute("orderlines", orderLines);
        model.addAttribute("orderId", orderId);
        return "order/orderlines";
    }

    // Hiển thị chi tiết theo sản phẩm
    @GetMapping("/product/{productId}")
    public String listByProduct(@PathVariable Integer productId, Model model) {
        List<OrderLine> orderLines = orderLineService.getOrderLinesByProductId(productId);
        model.addAttribute("orderlines", orderLines);
        model.addAttribute("productId", productId);
        return "order/orderlines";
    }

}