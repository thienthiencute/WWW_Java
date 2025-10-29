package fit.iuh.thanhoangthienthien_tuan07.controller;

import fit.iuh.thanhoangthienthien_tuan07.entities.CartBean;
import fit.iuh.thanhoangthienthien_tuan07.entities.CartItemBean;
import fit.iuh.thanhoangthienthien_tuan07.entities.Customer;
import fit.iuh.thanhoangthienthien_tuan07.entities.Order;
import fit.iuh.thanhoangthienthien_tuan07.entities.OrderLine;
import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import fit.iuh.thanhoangthienthien_tuan07.services.CustomerService;
import fit.iuh.thanhoangthienthien_tuan07.services.OrderService;
import fit.iuh.thanhoangthienthien_tuan07.services.ProductService;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {
  @Autowired
  private ProductService productService;

  @Autowired
  private OrderService orderService;

  @Autowired
  private CustomerService customerService;

  // Lấy giỏ hàng từ session
  private CartBean getCart(HttpSession session) {
    CartBean cart = (CartBean) session.getAttribute("cart");
    if (cart == null) {
      cart = new CartBean();
      session.setAttribute("cart", cart);
    }
    return cart;
  }

  // Hiển thị giỏ hàng
  @GetMapping
  public String viewCart(HttpSession session, Model model) {
    CartBean cart = getCart(session);
    model.addAttribute("cart", cart);
    return "order/cart";
  }

  // Thêm sản phẩm vào giỏ hàng
  @PostMapping("/add")
  public String addToCart(@RequestParam Integer productId,
      @RequestParam(defaultValue = "1") int quantity,
      HttpSession session) {
    Product product = productService.getProductById(productId);
    if (product != null) {
      CartBean cart = getCart(session);
      cart.addProduct(product, quantity);
    }
    return "redirect:/cart";
  }


  // Cập nhật số lượng
  @PostMapping("/update")
  public String updateCart(@RequestParam Integer productId,
      @RequestParam int quantity,
      HttpSession session) {
    CartBean cart = getCart(session);
    cart.updateQuantity(productId, quantity);
    return "redirect:/cart";
  }

  // Xóa sản phẩm
  @GetMapping("/remove/{productId}")
  public String removeFromCart(@PathVariable Integer productId, HttpSession session) {
    CartBean cart = getCart(session);
    cart.removeProduct(productId);
    return "redirect:/cart";
  }

  // Xóa toàn bộ giỏ hàng
  @GetMapping("/clear")
  public String clearCart(HttpSession session) {
    CartBean cart = getCart(session);
    cart.clear();
    return "redirect:/cart";
  }

  // Checkout - chuyển giỏ hàng thành đơn hàng
  @GetMapping("/checkout")
  public String showCheckout(HttpSession session, Model model) {
    CartBean cart = getCart(session);
    if (cart.isEmpty()) {
      return "redirect:/cart";
    }
    model.addAttribute("cart", cart);
    model.addAttribute("customers", customerService.getAllCustomers());
    return "order/checkout";
  }

  // Xử lý checkout
  @PostMapping("/checkout")
  public String processCheckout(@RequestParam Integer customerId, HttpSession session) {
    CartBean cart = getCart(session);

    // Tạo Order mới
    Order order = new Order();
    order.setDate(LocalDate.now()); // Sử dụng LocalDate.now()

    // Lấy customer từ customerId
    Customer customer = customerService.getCustomerById(customerId);
    order.setCustomer(customer);

    // Chuyển CartBean thành OrderLines
    List<OrderLine> orderLines = new ArrayList<>();
    for (CartItemBean cartItem : cart.getItems()) {
      OrderLine line = new OrderLine();
      line.setOrder(order);
      line.setProduct(cartItem.getProduct());
      line.setAmount(cartItem.getQuantity());
      line.setPurchasePrice(cartItem.getSubtotal());
      orderLines.add(line);
    }

    order.setOrderLines(orderLines);
    orderService.saveOrder(order);

    // Xóa giỏ hàng sau khi đặt hàng
    cart.clear();

    return "redirect:/orders/detail/" + order.getId();
  }
}
