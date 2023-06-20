package com.spring.Application.controller;

import com.spring.Application.dto.CustomerDTO;
import com.spring.Application.dto.ItemDTO;
import com.spring.Application.dto.paginated.PaginatedItemDTO;
import com.spring.Application.dto.request.ItemSaveRequestDTO;
import com.spring.Application.dto.response.ItemGetResponseDTO;
import com.spring.Application.service.ItemService;
import com.spring.Application.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RequestMapping("api/v1/item")
@CrossOrigin
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping(path = "/save")
//    public String saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
//    {
//       String message = itemService.saveItem(itemSaveRequestDTO);
//       return "saved";
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO)
    {
        String message = itemService.saveItem(itemSaveRequestDTO);
//        StandardResponse standardResponse = new StandardResponse(
//                201,
//                "Item saved Successfull",
//                itemSaveRequestDTO
//        );
//        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
//           standardResponse, HttpStatus.CREATED
//        );
//        return response;
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Item saved Successfull",itemSaveRequestDTO),
                HttpStatus.CREATED
        );
    }


//    @GetMapping(
//            path = "get-by-id",
//            params = "id"
//    )
//    public ItemDTO getItemById(@RequestParam(value = "id") int itemId)
//    {
//        ItemDTO itemDTO= itemService.getItemById(itemId);
//        return itemDTO;
//    }

        @GetMapping(
            path = "get-by-id",
            params = "id"
    )
        public ResponseEntity<StandardResponse> getItemById(@RequestParam(value = "id") int itemId)
        {
            ItemDTO itemDTO= itemService.getItemById(itemId);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200," Success",itemDTO),
                    HttpStatus.OK
            );
        }


    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam(value = "name")String name )
    {
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatusByMapstruct(name);
        return itemGetResponseDTOS;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = "activeStatus"
    )
    public ResponseEntity<StandardResponse> getItemByActiveStatus(
            @RequestParam(value ="activeStatus") boolean activeStatus,
            @RequestParam(value ="page") int page,
            @RequestParam(value ="size") @Max(50) int size
            )
    {
//        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByActiveStatusWithPaginated(activeStatus);
        PaginatedItemDTO paginatedItemDTO = itemService.getItemByActiveStatusWithPaginated(activeStatus,page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200," Success",paginatedItemDTO),
                HttpStatus.OK
        );
    }
}
