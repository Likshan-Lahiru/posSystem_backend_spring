package pos.spring.possystemspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pos.spring.possystemspring.dto.impl.CustomerDto;
import pos.spring.possystemspring.dto.impl.ItemDto;
import pos.spring.possystemspring.exception.DataPersistException;
import pos.spring.possystemspring.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody ItemDto itemDto) throws DataPersistException {
        System.out.println("Test Item customer");
        System.out.println(
                              "ID :" +   itemDto.getItemId() + " \n"
                              +"name :" + itemDto.getDescription() + "\n"
                              +"address :"+ itemDto.getQuantity() +"\n"
                              +"Phone :"+ itemDto.getUnitPrice()
                );
        try {
            itemService.saveItem(itemDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping
    public ResponseEntity<Void> updateItem(@RequestBody ItemDto itemDto) throws DataPersistException {
        System.out.println("test Update customer");
        String itemId = itemDto.getItemId();
        System.out.println(
                "ID :" + itemId   + " \n"
                        +"name :" + itemDto.getDescription() + "\n"
                        +"quantity :"+ itemDto.getQuantity() +"\n"
                        +"rice :"+ itemDto.getUnitPrice()
        );

        try {
            itemService.updateItem(itemId, itemDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/genItemID")
    public String generateItemId(){
        String ItemId = itemService.generateItemID();
        return ItemId;
    }

    @GetMapping
    public List<ItemDto> getAllCustomer(){
        System.out.println("Item getAllItem");
        return  itemService.getAllItem();
    }

    @DeleteMapping(value = "/{itemId}")
    public ResponseEntity<Object> deleteItem(@PathVariable("itemId") String itemId){
        System.out.println("test delete item"+itemId);
        try {
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
