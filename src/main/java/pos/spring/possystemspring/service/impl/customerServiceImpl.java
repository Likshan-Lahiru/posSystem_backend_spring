package pos.spring.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pos.spring.possystemspring.dto.impl.CustomerDto;
import pos.spring.possystemspring.service.CustomerService;

@Service
@Transactional
public class customerServiceImpl implements CustomerService {
    @Override
    public ResponseEntity<Void> saveCustomer(CustomerDto customerDto) {
            return null;
    }

    @Override
    public String generateCustomerID() {
        return "C001";
    }
}
