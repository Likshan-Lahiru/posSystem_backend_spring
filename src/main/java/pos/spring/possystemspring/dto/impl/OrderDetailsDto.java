package pos.spring.possystemspring.dto.impl;

import pos.spring.possystemspring.dto.SuperDto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailsDto implements SuperDto {
    private String orderDetailId;
    private String id;
    private String itemId;
    private double totalPrice;
    private int qty;
    private double unitPrice;
}
