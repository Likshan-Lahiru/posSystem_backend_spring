package pos.spring.possystemspring.dto.impl;

import lombok.*;
import pos.spring.possystemspring.dto.SuperDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements SuperDto {
    private String orderId;
    private String customerId;
    private String date;
    private double discount;
    private double total;
}
