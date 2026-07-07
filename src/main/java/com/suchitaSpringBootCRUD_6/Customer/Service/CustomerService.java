package com.suchitaSpringBootCRUD_6.Customer.Service;

import com.suchitaSpringBootCRUD_6.Customer.Entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);


}

