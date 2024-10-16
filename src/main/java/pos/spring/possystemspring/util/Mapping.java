package pos.spring.possystemspring.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pos.spring.possystemspring.dto.impl.CustomerDto;
import pos.spring.possystemspring.dto.impl.ItemDto;
import pos.spring.possystemspring.dto.impl.OrderDetailsDto;
import pos.spring.possystemspring.dto.impl.OrderDto;
import pos.spring.possystemspring.entity.impl.CustomerEntity;
import pos.spring.possystemspring.entity.impl.ItemEntity;
import pos.spring.possystemspring.entity.impl.OrderDetailsEntity;
import pos.spring.possystemspring.entity.impl.OrderEntity;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerEntity customerEntity(CustomerDto customerDto){
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
    public List<CustomerDto> customerDtoList(List<CustomerEntity> customerEntityList){
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDto>>() {}.getType());

    }
    public List<ItemDto> itemDtoList(List<ItemEntity> itemEntityList){
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDto>>() {}.getType());
    }
    public CustomerDto customerDto(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity, CustomerDto.class);
    }
    public ItemEntity itemEntity(ItemDto itemDto){
        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto itemDto(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDto.class);
    }

    public OrderEntity toOrderEntity(OrderDto orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    public OrderDto toOrderDTO(OrderEntity placeOrder) {
        return modelMapper.map(placeOrder, OrderDto.class);
    }

    public OrderDetailsEntity toOrderDetailEntity(OrderDetailsDto orderDetailsDTO) {
        return modelMapper.map(orderDetailsDTO, OrderDetailsEntity.class);
    }
}
