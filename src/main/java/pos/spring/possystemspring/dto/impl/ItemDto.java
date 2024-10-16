package pos.spring.possystemspring.dto.impl;

import lombok.*;
import pos.spring.possystemspring.dto.SuperDto;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto implements SuperDto {
    private String itemId;
    private String description;
    private double unitPrice;
    private int quantity;
}
