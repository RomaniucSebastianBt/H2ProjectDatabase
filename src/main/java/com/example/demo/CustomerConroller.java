package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class CustomerConroller {

    private final CustomersService customersService;

    public CustomerConroller(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){

        return new ArrayList<>(customersService.getAllCustomers());
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomer(@PathVariable int id ){
        return customersService.getCustomer(id);

    }

    @PostMapping("/addCustomer")
    public Customer addCustomer (@RequestBody Customer customer) {
        return customersService.addCustomer(customer);

    }

    @PutMapping ("/updateCustomer/{id}")

    public void updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        customersService.updateCustomer(id,customer);

    }
    @DeleteMapping ("/deleteCustomer/{id}")

    public void deleteCustomer(@PathVariable long id ){

    }
}