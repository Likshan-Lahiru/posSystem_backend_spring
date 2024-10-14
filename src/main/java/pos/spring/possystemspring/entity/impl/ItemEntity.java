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
@Table(name = "item")
public class ItemEntity implements SuperEntity {
    @Id
    private String itemId;
    private String description;
    private double unitPrice;
    private int quantity;
    @OneToMany(mappedBy = "item")
    private List<OrderDetailsEntity> orderDetail;
}
