package pos.spring.possystemspring.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pos.spring.possystemspring.service.OrderService;

@RestController
@Transactional
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/genOrderID")
    public String generateOrderId(){
      return orderService.generateOrderID();
    }
}
