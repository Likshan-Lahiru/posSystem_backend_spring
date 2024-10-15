package pos.spring.possystemspring.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pos.spring.possystemspring.dao.ItemDao;
import pos.spring.possystemspring.dto.impl.ItemDto;
import pos.spring.possystemspring.entity.impl.CustomerEntity;
import pos.spring.possystemspring.entity.impl.ItemEntity;
import pos.spring.possystemspring.service.ItemService;
import pos.spring.possystemspring.util.Mapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapper;

    @Override
    public void saveItem(ItemDto itemDto) {

        ItemEntity save = itemDao.save(mapper.itemEntity(itemDto));
        if(save == null) {
            throw new DataIntegrityViolationException("Item saved failed");
        }
    }

    @Override
    public String generateItemID() {
        return "";
    }

    @Override
    public void updateItem(String itemId, ItemDto itemDto) {
        Optional<ItemEntity> tempItem = itemDao.findById(itemId);
        if (tempItem.isPresent()) {
            tempItem.get().setItemId(itemId);
            tempItem.get().setDescription(itemDto.getDescription());
            tempItem.get().setQuantity(itemDto.getQuantity());
            tempItem.get().setUnitPrice(itemDto.getUnitPrice());
        }
    }

    @Override
    public List<ItemDto> getAllItem() {
        return List.of();
    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public ItemDto getItemById(String ItemId) {
        return null;
    }
}
