package pos.spring.possystemspring.dto.impl;

import pos.spring.possystemspring.dto.SuperDto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailsDto implements SuperDto {
    private String orderId;
    private String productId;
    private double price;
    private int quantity;
    private double unitPrice;
}
