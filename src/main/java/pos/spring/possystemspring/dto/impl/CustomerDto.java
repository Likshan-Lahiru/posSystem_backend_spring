package pos.spring.possystemspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
