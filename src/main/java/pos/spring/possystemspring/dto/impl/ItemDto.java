package pos.spring.possystemspring.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
