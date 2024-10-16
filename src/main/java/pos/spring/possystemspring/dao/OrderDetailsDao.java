package pos.spring.possystemspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pos.spring.possystemspring.entity.impl.OrderDetailsEntity;


public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity, String> {

}
