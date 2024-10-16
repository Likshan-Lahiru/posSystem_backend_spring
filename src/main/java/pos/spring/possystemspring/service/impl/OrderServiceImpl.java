package pos.spring.possystemspring.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.spring.possystemspring.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private EntityManager entityManager;
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
}
