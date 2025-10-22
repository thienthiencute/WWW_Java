package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.Customer;
import fit.iuh.thanhoangthienthien_tuan07.entities.Order;
import fit.iuh.thanhoangthienthien_tuan07.services.CustomerService;
import fit.iuh.thanhoangthienthien_tuan07.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService;

    // Hiển thị danh sách hóa đơn
    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("customers", customerService.getAllCustomers());
        return "order/orders";
    }

    // Xem chi tiết hóa đơn
    @GetMapping("/detail/{id}")
    public String viewDetail(@PathVariable Integer id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return "redirect:/orders";
        }
        model.addAttribute("order", order);
        return "order/order-detail";
    }

    // Hiển thị form thêm hóa đơn
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("isEdit", false);
        return "order/order-form";
    }

    // Xử lý thêm hóa đơn
    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order) {
        order.setDate(Calendar.getInstance());
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    // Hiển thị form sửa hóa đơn
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return "redirect:/orders";
        }
        model.addAttribute("order", order);
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("isEdit", true);
        return "order/order-form";
    }

    // Xử lý sửa hóa đơn
    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable Integer id, @ModelAttribute Order order) {
        order.setId(id);
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

    // Xóa hóa đơn
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    // Tìm kiếm hóa đơn theo mã khách hàng
    @GetMapping("/search/customer")
    public String searchByCustomer(@RequestParam(required = false) Integer customerId, Model model) {
        List<Order> orders;
        if (customerId == null || customerId == 0) {
            orders = orderService.getAllOrders();
        } else {
            orders = orderService.getOrdersByCustomerId(customerId);
        }
        model.addAttribute("orders", orders);
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("selectedCustomerId", customerId);
        return "order/orders";
    }

    // Tìm kiếm hóa đơn theo ngày
    @GetMapping("/search/date")
    public String searchByDate(@RequestParam(required = false) String dateStr, Model model) {
        List<Order> orders = new ArrayList<>();

        if (dateStr != null && !dateStr.isEmpty()) {
            try {
                Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
                Calendar date = Calendar.getInstance();
                date.setTime(parsedDate);
                orders = orderService.getOrdersByDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            orders = orderService.getAllOrders();
        }

        model.addAttribute("orders", orders);
        model.addAttribute("date", dateStr);
        model.addAttribute("customers", customerService.getAllCustomers());
        return "order/orders";
    }
}
