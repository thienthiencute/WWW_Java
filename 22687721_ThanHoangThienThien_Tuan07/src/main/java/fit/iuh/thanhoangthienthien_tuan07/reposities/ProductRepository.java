package fit.iuh.thanhoangthienthien_tuan07.reposities;


import fit.iuh.thanhoangthienthien_tuan07.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}