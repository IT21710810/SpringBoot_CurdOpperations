package com.spring.Application.controller;

import com.spring.Application.dto.CustomerDTO;
import com.spring.Application.dto.request.CustomerUpdateDTO;
import com.spring.Application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/customer")
@CrossOrigin
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save-customer")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }


    @PostMapping("")
    public String saveEmployee(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update-customer")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message= customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping(
            path = "get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId)
    {
        CustomerDTO customerDTO= customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public String deleteCustomers(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomers(customerId);
        return deleted;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerDTO> getAllCustomers()
    {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        return customerDTOS;
    }

    @GetMapping(path = "/get-all-customers-active-state{status}")
    public List<CustomerDTO> getAllCustomersByActiveStatus(@PathVariable(value = "status") boolean activeStatus)
    {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomersByActiveStatus(activeStatus);
        return customerDTOS;
    }

}
