package com.suchitaSpringBootCRUD_6.Customer.Controller;

import com.suchitaSpringBootCRUD_6.Customer.Entity.Customer;
import com.suchitaSpringBootCRUD_6.Customer.Repository.CustomerRepo;
import com.suchitaSpringBootCRUD_6.Customer.Service.CustomerService;
import com.suchitaSpringBootCRUD_6.Customer.ServiceImpl.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.hibernate.boot.internal.Target;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer( @Valid @RequestBody Customer customer) {
        Customer newCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer() {
List<Customer> getAllCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(getAllCustomer);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById( @PathVariable Long id){
        Customer getCustomer = customerService.getCustomerById(id);
        return  ResponseEntity.ok(getCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer( @Valid @PathVariable Long id,
                                   @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }
@DeleteMapping("/{id}")
    public ResponseEntity <String> deleteCustomer(@PathVariable Long id){
         customerService.deleteCustomer(id);
         return ResponseEntity.ok("The Customer is Deleted Successfully..!!!");



}


}
