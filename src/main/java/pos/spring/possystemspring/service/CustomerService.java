package pos.spring.possystemspring.service;

import org.springframework.http.ResponseEntity;
import pos.spring.possystemspring.dto.impl.CustomerDto;

public interface CustomerService {
    ResponseEntity<Void> saveCustomer(CustomerDto customerDto);

    String generateCustomerID();
}
