package pos.spring.possystemspring.service;

import pos.spring.possystemspring.dto.impl.OrderDto;

import java.util.List;

public interface OrderService {
    String generateOrderID();

    void saveOrder(OrderDto orderDTO);

    List<OrderDto> getAllOrders();
}
