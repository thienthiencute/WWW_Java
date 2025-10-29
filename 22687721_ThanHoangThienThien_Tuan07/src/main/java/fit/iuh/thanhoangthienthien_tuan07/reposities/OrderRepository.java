package fit.iuh.thanhoangthienthien_tuan07.reposities;

import fit.iuh.thanhoangthienthien_tuan07.entities.Order;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_Id(Integer customerId);

    List<Order> findByDate(LocalDate date);
}