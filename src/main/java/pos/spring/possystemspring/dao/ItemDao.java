package pos.spring.possystemspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pos.spring.possystemspring.dto.impl.ItemDto;
import pos.spring.possystemspring.entity.impl.CustomerEntity;
import pos.spring.possystemspring.entity.impl.ItemEntity;

public interface ItemDao extends JpaRepository<ItemEntity, String> {
}
