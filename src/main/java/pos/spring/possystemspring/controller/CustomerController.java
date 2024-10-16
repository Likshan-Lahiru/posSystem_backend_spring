package pos.spring.possystemspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.spring.possystemspring.dto.impl.CustomerDto;
import pos.spring.possystemspring.exception.DataPersistException;
import pos.spring.possystemspring.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDto customerDto){
        System.out.println("test save customer");
        /*System.out.println(
                              "ID :" +   customerDto.getCustomerId() + " \n"
                              +"name :" + customerDto.getCustomerName() + "\n"
                              +"address :"+ customerDto.getCustomerAddress() +"\n"
                              +"Phone :"+ customerDto.getCustomerPhone()
                );*/
        try {
            customerService.saveCustomer(customerDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody CustomerDto customerDto){
        System.out.println("test Update customer");
        String customerId = customerDto.getCustomerId();
        System.out.println(
                              "ID :" + customerId   + " \n"
                              +"name :" + customerDto.getCustomerName() + "\n"
                              +"address :"+ customerDto.getCustomerAddress() +"\n"
                              +"Phone :"+ customerDto.getCustomerPhone()
                );

        try {
            customerService.updateCustomer(customerId,customerDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<CustomerDto> getAllCustomer(){
        System.out.println("test getAllCustomer");
      return customerService.getAllCustomer();
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("customerId") String customerId){
        System.out.println("test delete customer"+customerId);
        try {
            customerService.deleteCustmer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/genCusID")
    public String generateCustomerId(){
        String customerId = customerService.generateCustomerID();
        return customerId;


    }

    @GetMapping(value = "/{customerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDto findCustomerById(@PathVariable("customerID") String customerID){
        System.out.println("test findCustomerById"+customerID);
       return customerService.getCustomerById(customerID);
    }



}
