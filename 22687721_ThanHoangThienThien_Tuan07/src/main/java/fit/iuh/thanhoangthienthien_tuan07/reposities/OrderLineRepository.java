package fit.iuh.thanhoangthienthien_tuan07.reposities;

import fit.iuh.thanhoangthienthien_tuan07.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    // Lấy các orderline theo order
    List<OrderLine> findByOrder_Id(Integer orderId);

    // Lấy các orderline theo product
    List<OrderLine> findByProduct_Id(Integer productId);

}