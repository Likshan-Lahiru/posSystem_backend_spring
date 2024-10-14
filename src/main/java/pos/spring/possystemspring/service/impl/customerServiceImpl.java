package pos.spring.possystemspring.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pos.spring.possystemspring.dao.CustomerDao;
import pos.spring.possystemspring.dto.impl.CustomerDto;
import pos.spring.possystemspring.entity.impl.CustomerEntity;
import pos.spring.possystemspring.service.CustomerService;
import pos.spring.possystemspring.util.Mapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class customerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = mapper.customerEntity(customerDto);
        customerDao.save(customerEntity);
        if (customerEntity==null){
            throw new DataIntegrityViolationException("customer not found");
        }

    }

    @Transactional
    @Override
    public String generateCustomerID() {

        TypedQuery<String> query = entityManager.createQuery(
                "SELECT c.customerId FROM CustomerEntity c ORDER BY c.customerId DESC", String.class);
        query.setMaxResults(1);


        String lastCustomerId = query.getResultStream().findFirst().orElse(null);

        if (lastCustomerId != null) {

            int generatedCustomerId = Integer.parseInt(lastCustomerId.replace("C00-", "")) + 1;
            return String.format("C00-%03d", generatedCustomerId);
        } else {

            return "C00-001";
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDto customerDto) {
        Optional<CustomerEntity> tempCustomer = customerDao.findById(customerId);
        if (tempCustomer.isPresent()) {
            tempCustomer.get().setCustomerId(customerId);
            tempCustomer.get().setCustomerName(customerDto.getCustomerName());
            tempCustomer.get().setCustomerAddress(customerDto.getCustomerAddress());
            tempCustomer.get().setCustomerPhone(customerDto.getCustomerPhone());
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<CustomerEntity> all = customerDao.findAll();
        return mapper.customerDtoList(all);
    }

    @Override
    public void deleteCustmer(String customerId) {
        Optional<CustomerEntity> byId = customerDao.findById(customerId);
        if (!byId.isPresent()) {
            throw new DataIntegrityViolationException("Customer with id"+ customerId +"customer not found");
        }else {
            customerDao.deleteById(customerId);
        }

    }


}
