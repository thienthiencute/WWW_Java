package fit.iuh.thanhoangthienthien_tuan07.services;


import fit.iuh.thanhoangthienthien_tuan07.entities.Customer;
import fit.iuh.thanhoangthienthien_tuan07.reposities.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
}

