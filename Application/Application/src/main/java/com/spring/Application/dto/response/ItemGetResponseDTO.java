package com.spring.Application.dto.response;

import com.spring.Application.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private double sellingPrice;
    private boolean activeState;
}
