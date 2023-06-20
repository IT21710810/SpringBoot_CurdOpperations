package com.spring.Application.dto.paginated;

import com.spring.Application.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedItemDTO {
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
