package fit.iuh.thanhoangthienthien_tuan07.reposities;


import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
}