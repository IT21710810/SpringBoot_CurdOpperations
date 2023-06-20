package com.spring.Application.service;

import com.spring.Application.dto.ItemDTO;
import com.spring.Application.dto.paginated.PaginatedItemDTO;
import com.spring.Application.dto.request.ItemSaveRequestDTO;
import com.spring.Application.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    ItemDTO getItemById(int itemId);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String name);


    PaginatedItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);


}
