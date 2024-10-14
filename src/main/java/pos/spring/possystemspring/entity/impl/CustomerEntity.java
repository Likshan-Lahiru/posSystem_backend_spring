package pos.spring.possystemspring.entity.impl;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pos.spring.possystemspring.entity.SuperEntity;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;

}
