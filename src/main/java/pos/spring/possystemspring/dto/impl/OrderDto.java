package pos.spring.possystemspring.dto.impl;

import lombok.*;
import pos.spring.possystemspring.dto.SuperDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements SuperDto {
    private String id;
    private String date;
    private double discount_value;
    private double sub_total;
    private String customerId;
}
