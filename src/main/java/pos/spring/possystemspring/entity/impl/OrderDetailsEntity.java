package pos.spring.possystemspring.entity.impl;

import jakarta.persistence.*;
import lombok.*;
import pos.spring.possystemspring.entity.SuperEntity;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetailsEntity implements SuperEntity {




    @Id
    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;


    private String qty;
    private String unitPrice;
    private String totalPrice;

}
