package com.suchitaSpringBootCRUD_6.Customer.ServiceImpl;

import com.suchitaSpringBootCRUD_6.Customer.Custom_CustomerException.CustomerNotFoundException;
import com.suchitaSpringBootCRUD_6.Customer.Entity.Customer;
import com.suchitaSpringBootCRUD_6.Customer.Repository.CustomerRepo;
import com.suchitaSpringBootCRUD_6.Customer.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    public CustomerServiceImpl(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;

    }


    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {

        return customerRepo.findAll();
    }

    @Override

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = getCustomerById(id);

        existingCustomer.setFirst_name(customer.getFirst_name());
        existingCustomer.setLast_name(customer.getLast_name());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setState(customer.getState());
        existingCustomer.setCountry(customer.getCountry());
        existingCustomer.setGender(customer.getGender());
        existingCustomer.setAge(customer.getAge());

        return customerRepo.save(existingCustomer);
    }



    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with id : " + id));

        customerRepo.delete(customer);
    }

    }

