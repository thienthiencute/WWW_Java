package fit.iuh.thanhoangthienthien_tuan07.reposities;

import fit.iuh.thanhoangthienthien_tuan07.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByNameContainingIgnoreCase(String name);}