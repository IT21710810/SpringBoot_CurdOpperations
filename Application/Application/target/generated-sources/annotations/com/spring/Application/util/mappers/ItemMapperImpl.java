package com.spring.Application.util.mappers;

import com.spring.Application.dto.ItemDTO;
import com.spring.Application.dto.response.ItemGetResponseDTO;
import com.spring.Application.entity.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T12:18:34+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public List<ItemGetResponseDTO> entityListToDtoList(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>( items.size() );
        for ( Item item : items ) {
            list.add( itemToItemGetResponseDTO( item ) );
        }

        return list;
    }

    @Override
    public ItemDTO entityToDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setItemId( item.getItemId() );
        itemDTO.setItemName( item.getItemName() );
        itemDTO.setMeasuringType( item.getMeasuringType() );
        itemDTO.setBalanceQty( item.getBalanceQty() );
        itemDTO.setSupplierPrice( item.getSupplierPrice() );
        itemDTO.setSellingPrice( item.getSellingPrice() );
        itemDTO.setActiveState( item.isActiveState() );

        return itemDTO;
    }

    @Override
    public List<ItemGetResponseDTO> PageToDTOList(Page<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemGetResponseDTO> list = new ArrayList<ItemGetResponseDTO>();
        for ( Item item : items ) {
            list.add( itemToItemGetResponseDTO( item ) );
        }

        return list;
    }

    protected ItemGetResponseDTO itemToItemGetResponseDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO();

        itemGetResponseDTO.setItemId( item.getItemId() );
        itemGetResponseDTO.setItemName( item.getItemName() );
        itemGetResponseDTO.setBalanceQty( item.getBalanceQty() );
        itemGetResponseDTO.setSellingPrice( item.getSellingPrice() );
        itemGetResponseDTO.setActiveState( item.isActiveState() );

        return itemGetResponseDTO;
    }
}
