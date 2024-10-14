package pos.spring.possystemspring.service;

import org.springframework.http.ResponseEntity;
import pos.spring.possystemspring.dto.impl.CustomerDto;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    String generateCustomerID();

    void updateCustomer(String customerId, CustomerDto customerDto);
}

