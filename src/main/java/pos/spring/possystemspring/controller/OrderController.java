package pos.spring.possystemspring.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.spring.possystemspring.dto.impl.OrderDto;
import pos.spring.possystemspring.exception.DataPersistException;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDTO) {
        System.out.println(orderDTO.getId());
        System.out.println(orderDTO.getDate());
        System.out.println(orderDTO.getDiscount_value());
        System.out.println(orderDTO.getSub_total());
        System.out.println(orderDTO.getCustomerId());
        try {
            orderService.saveOrder(orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
           // logger.error("Faild with: ",e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
          //  logger.error("Faild with: ",e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
