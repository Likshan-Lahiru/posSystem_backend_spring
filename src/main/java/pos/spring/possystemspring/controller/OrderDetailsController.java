package pos.spring.possystemspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pos.spring.possystemspring.dto.impl.OrderDetailsDto;
import pos.spring.possystemspring.exception.DataPersistException;
import pos.spring.possystemspring.service.OrderDetailsService;

@RestController
@RequestMapping("api/v1/orderDetail")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailService;

    static Logger logger = LoggerFactory.getLogger(OrderDetailsController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addOrderDetail(@RequestBody OrderDetailsDto orderDetailsDto) {
        System.out.println(orderDetailsDto);
        try {
            orderDetailService.saveOrderDetail(orderDetailsDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
