package pos.spring.possystemspring.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.spring.possystemspring.dao.CustomerDao;
import pos.spring.possystemspring.dao.OrderDao;
import pos.spring.possystemspring.dto.impl.OrderDto;
import pos.spring.possystemspring.entity.impl.CustomerEntity;
import pos.spring.possystemspring.entity.impl.OrderEntity;
import pos.spring.possystemspring.exception.DataPersistException;
import pos.spring.possystemspring.service.OrderService;
import pos.spring.possystemspring.util.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapper;

    @Override
    public String generateOrderID() {

        TypedQuery<String> query = entityManager.createQuery(
                "SELECT c.id FROM OrderEntity c ORDER BY c.id DESC", String.class);
        query.setMaxResults(1);


        String lastItemId = query.getResultStream().findFirst().orElse(null);

        if (lastItemId != null) {

            int generatedOrderId = Integer.parseInt(lastItemId.replace("O00-", "")) + 1;
            return String.format("O00-%03d", generatedOrderId);
        } else {

            return "O00-001";
        }
    }

    @Override
    public void saveOrder(OrderDto orderDTO) {
        Optional<CustomerEntity> customer = customerDao.findById(orderDTO.getCustomerId());
        OrderEntity order = mapper.toOrderEntity(orderDTO);
        order.setId(generateOrderID());
        order.setCustomer(customer.get());
        OrderEntity save = orderDao.save(order);
        if (save == null) {
            throw new DataPersistException();
        }
    }
    @Override
    public List<OrderDto> getAllOrders() {
        Iterable<OrderEntity> all = orderDao.findAll();
        List<OrderDto> placeOrderDto = new ArrayList<>();

        all.forEach(placeOrder -> {
            placeOrderDto.add(mapper.toOrderDTO(placeOrder));
        });
        return placeOrderDto;
    }
}
