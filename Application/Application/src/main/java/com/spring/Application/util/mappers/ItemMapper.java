package com.spring.Application.util.mappers;

import com.spring.Application.dto.ItemDTO;
import com.spring.Application.dto.request.ItemSaveRequestDTO;
import com.spring.Application.dto.response.ItemGetResponseDTO;
import com.spring.Application.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item>items);
    ItemDTO entityToDto (Item item);
    List<ItemGetResponseDTO> PageToDTOList(Page<Item>items);

//    ItemGetResponseDTO entityToDto(Item item);
//    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);
//
//    List<ItemGetResponseDTO>LisDTOToPage(Page<Item> items);
}
