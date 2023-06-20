package com.spring.Application.service.impl;

import com.spring.Application.dto.CustomerDTO;
import com.spring.Application.dto.request.CustomerUpdateDTO;
import com.spring.Application.entity.Customer;
import com.spring.Application.exception.NotFoundException;
import com.spring.Application.repo.CustomerRepo;
import com.spring.Application.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );
        customerRepo.save(customer);
        return customer.getCustomerName() + " saved";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setNic(customerUpdateDTO.getNic());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " updated";

        } else {
         throw new RuntimeException("No data found for that id");

        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            return customerDTO;
        } else {
//            throw new RuntimeException("No Customer");
                  throw new NotFoundException("No customers for that id");
        }
    }

    @Override
    public String deleteCustomers(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return customerId +" Deleted";

        }else {
            throw new RuntimeException("No customer for delete");
        }
    }

    @Override
//    public List<CustomerDTO> getAllCustomers() {
//        List<Customer> customerDTOList = customerRepo.findAll();
//        System.out.println("Come " + customerDTOList);
//        return null;
//    }
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerDTOList = customerRepo.findAll();
        System.out.println(customerDTOList.size());
        List<CustomerDTO> customerDTOS = new ArrayList<>();

//        for (int i=0 ;i< customerDTOList.size();i++)
//        {
//            System.out.println("List "+customerDTOList.get(i));
//        }

//        OR

        for (Customer customer : customerDTOList)
        {
            System.out.println("Come " + customer);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus) {
        List<Customer> customerDTOList = customerRepo.findByActiveState(activeStatus);

        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customerDTOList)
        {
            System.out.println("Come " + customer);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActiveState()
            );
            customerDTOS.add(customerDTO);
        }
        return customerDTOS;
    }
}
