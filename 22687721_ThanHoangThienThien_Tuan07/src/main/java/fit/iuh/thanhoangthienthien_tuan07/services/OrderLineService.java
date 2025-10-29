package fit.iuh.thanhoangthienthien_tuan07.services;

import fit.iuh.thanhoangthienthien_tuan07.entities.OrderLine;
import fit.iuh.thanhoangthienthien_tuan07.reposities.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;

    // CRUD
    public List<OrderLine> getAllOrderLines() {
        return orderLineRepository.findAll();
    }

    public OrderLine getOrderLineById(Integer id) {
        return orderLineRepository.findById(id).orElse(null);
    }

    public OrderLine saveOrderLine(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    public void deleteOrderLine(Integer id) {
        orderLineRepository.deleteById(id);
    }

    // Lấy các orderline theo order
    public List<OrderLine> getOrderLinesByOrderId(Integer orderId) {
        return orderLineRepository.findByOrder_Id(orderId);
    }

    // Lấy các orderline theo product
    public List<OrderLine> getOrderLinesByProductId(Integer productId) {
        return orderLineRepository.findByProduct_Id(productId);
    }
}