package pos.spring.possystemspring.service;

import pos.spring.possystemspring.dto.impl.OrderDto;

public interface OrderService {
    String generateOrderID();

    void saveOrder(OrderDto orderDTO);
}
