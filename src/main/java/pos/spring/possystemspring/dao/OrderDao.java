package pos.spring.possystemspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pos.spring.possystemspring.entity.impl.OrderEntity;

public interface OrderDao extends JpaRepository<OrderEntity, String> {
}
