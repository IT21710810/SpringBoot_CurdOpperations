package com.spring.Application.service.impl;

import com.spring.Application.dto.CustomerDTO;
import com.spring.Application.dto.ItemDTO;
import com.spring.Application.dto.paginated.PaginatedItemDTO;
import com.spring.Application.dto.request.ItemSaveRequestDTO;
import com.spring.Application.dto.response.ItemGetResponseDTO;
import com.spring.Application.entity.Customer;
import com.spring.Application.entity.Item;
import com.spring.Application.entity.enums.MeasuringUnitType;
import com.spring.Application.repo.ItemRepo;
import com.spring.Application.service.ItemService;
import com.spring.Application.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                0,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                itemSaveRequestDTO.getSellingPrice(),
//                itemSaveRequestDTO.isActiveState()
//        );
        Item item = modelMapper.map(itemSaveRequestDTO,Item.class);
        itemRepo.save(item);
        return item.getItemName() + "saved";
    }

    @Override
    public ItemDTO getItemById(int itemId) {

        if (itemRepo.existsById(itemId)) {
            Item item = itemRepo.getReferenceById(itemId);
            ItemDTO itemDTO = modelMapper.map(item,ItemDTO.class);
//            OR
//            ItemDTO i = itemMapper.entityToDto(item);
            return itemDTO;
        } else {
            throw new RuntimeException("No Items");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String name) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(name,b);
        if (items.size() > 0)
        {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("No items to show");
        }

    }

    @Override
    public PaginatedItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page, size));
        if (items.getSize()<1)
        {
            throw new RuntimeException("No find data");
        }
        PaginatedItemDTO paginatedItemDTO = new PaginatedItemDTO(
                itemMapper.PageToDTOList(items),
                itemRepo.countAllByActiveStateEquals(activeStatus)
        );
        return paginatedItemDTO;
    }

}
