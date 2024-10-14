package pos.spring.possystemspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pos.spring.possystemspring.entity.impl.CustomerEntity;

public interface CustomerDao extends JpaRepository<CustomerEntity, String> {

}
