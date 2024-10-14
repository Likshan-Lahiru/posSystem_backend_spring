package pos.spring.possystemspring.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pos.spring.possystemspring.entity.SuperEntity;


import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String id;
    private String date;
    private double discount_value;
    private double sub_total;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private CustomerEntity customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<OrderDetailsEntity> orderDetails;
}
