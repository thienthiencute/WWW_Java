package fit.iuh.thanhoangthienthien_tuan07.services;

import fit.iuh.thanhoangthienthien_tuan07.entities.Order;
import fit.iuh.thanhoangthienthien_tuan07.reposities.OrderRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    // CRUD
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    // Tìm hóa đơn theo customerId
    public List<Order> getOrdersByCustomerId(Integer customerId) {
        return orderRepository.findByCustomer_Id(customerId);
    }

    // Tìm hóa đơn theo ngày
    public List<Order> getOrdersByDate(LocalDate date) {
        return orderRepository.findByDate(date);
    }
}