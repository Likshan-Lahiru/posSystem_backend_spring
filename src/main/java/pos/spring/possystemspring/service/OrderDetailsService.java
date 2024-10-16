package pos.spring.possystemspring.service;

import pos.spring.possystemspring.dto.impl.OrderDetailsDto;

import java.util.List;

public interface OrderDetailsService {
    void saveOrderDetail(OrderDetailsDto orderDetailsDTO);
    List<OrderDetailsDto> getOrderDetails(String orderId);
}
