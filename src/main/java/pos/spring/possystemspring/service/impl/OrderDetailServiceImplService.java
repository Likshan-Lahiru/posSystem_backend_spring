package pos.spring.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pos.spring.possystemspring.dao.ItemDao;
import pos.spring.possystemspring.dao.OrderDao;
import pos.spring.possystemspring.dao.OrderDetailsDao;
import pos.spring.possystemspring.dto.impl.OrderDetailsDto;
import pos.spring.possystemspring.entity.impl.ItemEntity;
import pos.spring.possystemspring.entity.impl.OrderDetailsEntity;
import pos.spring.possystemspring.entity.impl.OrderEntity;
import pos.spring.possystemspring.exception.DataPersistException;
import pos.spring.possystemspring.service.OrderDetailsService;
import pos.spring.possystemspring.util.Mapping;

import java.util.List;


@Service
@Transactional
public class OrderDetailServiceImplService implements OrderDetailsService {
    @Autowired
    private Mapping mapper;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;
    @Override
    public void saveOrderDetail(OrderDetailsDto orderDetailsDTO) {

        OrderDetailsEntity orderDetail = mapper.toOrderDetailEntity(orderDetailsDTO);
        OrderEntity selectedOrder = orderDao.getReferenceById(orderDetailsDTO.getId());
        ItemEntity selectedItem = itemDao.getReferenceById(orderDetailsDTO.getItemId());
        orderDetail.setOrder(selectedOrder);
        orderDetail.setItem(selectedItem);


        OrderDetailsEntity savedOrderDetail = orderDetailsDao.save(orderDetail);

        String itemId = orderDetailsDTO.getItemId();
        int qty = orderDetailsDTO.getQty();

        ItemEntity fetchItem = itemDao.getReferenceById(itemId);
        fetchItem.setQuantity(fetchItem.getQuantity() - qty);

        ItemEntity savedItem = itemDao.save(fetchItem);

        if (savedOrderDetail == null || savedItem == null) {
            throw new DataPersistException();
        }
    }

    @Override
    public List<OrderDetailsDto> getOrderDetails(String orderId) {
        return List.of();
    }
}
