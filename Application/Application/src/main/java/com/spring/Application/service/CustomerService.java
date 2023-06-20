package com.spring.Application.service;

import com.spring.Application.dto.CustomerDTO;
import com.spring.Application.dto.request.CustomerUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public String  saveCustomer(CustomerDTO customerDTO);
    
    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    String deleteCustomers(int customerId);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus);
}
