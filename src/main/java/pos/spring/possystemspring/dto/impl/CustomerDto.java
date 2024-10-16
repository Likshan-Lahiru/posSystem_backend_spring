package pos.spring.possystemspring.dto.impl;

import lombok.*;
import pos.spring.possystemspring.dto.SuperDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto implements SuperDto {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
}
