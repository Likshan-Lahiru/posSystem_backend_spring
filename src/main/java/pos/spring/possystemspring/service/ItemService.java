package pos.spring.possystemspring.service;


import pos.spring.possystemspring.dto.impl.ItemDto;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDto itemDto);

    String generateItemID();

    void updateCustomer(String itemId, ItemDto itemDto);

    List<ItemDto> getAllItem();

    void deleteItem(String itemId);

    ItemDto getItemById(String ItemId);
}
