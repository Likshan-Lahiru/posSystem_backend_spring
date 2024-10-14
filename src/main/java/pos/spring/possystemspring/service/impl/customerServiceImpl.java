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


}
