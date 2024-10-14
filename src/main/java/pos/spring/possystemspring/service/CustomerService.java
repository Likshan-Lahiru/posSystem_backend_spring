package pos.spring.possystemspring.service;

import java.util.List;
import pos.spring.possystemspring.dto.impl.CustomerDto;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    String generateCustomerID();

    void updateCustomer(String customerId, CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    void deleteCustmer(String customerId);
}

