package pos.spring.possystemspring.dao;

import org.springframework.data.repository.CrudRepository;
import pos.spring.possystemspring.entity.impl.OrderEntity;

public interface OrderDao extends CrudRepository<OrderEntity, Integer> {
}
