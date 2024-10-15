package pos.spring.possystemspring.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
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
    @PersistenceContext
    private EntityManager entityManager;

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
        TypedQuery<String> query = entityManager.createQuery(
                "SELECT c.itemId FROM ItemEntity c ORDER BY c.itemId DESC", String.class);
        query.setMaxResults(1);


        String lastItemId = query.getResultStream().findFirst().orElse(null);

        if (lastItemId != null) {

            int generatedCustomerId = Integer.parseInt(lastItemId.replace("I00-", "")) + 1;
            return String.format("I00-%03d", generatedCustomerId);
        } else {

            return "I00-001";
        }
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
        return mapper.itemDtoList(itemDao.findAll());
    }

    @Override
    public void deleteItem(String itemId) {

    }

    @Override
    public ItemDto getItemById(String ItemId) {
        return null;
    }
}
