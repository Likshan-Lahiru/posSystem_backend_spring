package pos.spring.possystemspring.entity.impl;

import jakarta.persistence.*;
import lombok.*;
import pos.spring.possystemspring.entity.SuperEntity;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "OrderDetails")
public class OrderDetailsEntity implements SuperEntity {

    @Id
    private String orderId;

    @PrePersist
    public void generateOrderId() {
        this.orderId = UUID.randomUUID().toString();
    }

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemEntity item;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    private String qty;
    private String unitPrice;
    private String totalPrice;
}
