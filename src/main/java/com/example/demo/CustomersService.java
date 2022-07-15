package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {



    private final ICustomerRepo iCustomerRepo;

    public CustomersService(ICustomerRepo iCustomerRepo) {
        this.iCustomerRepo = iCustomerRepo;
    }



    public List<Customer> getAllCustomers() {
        return new ArrayList<>(iCustomerRepo.findAll());
    }

    public Optional<Customer> getCustomer(long id) {

        return iCustomerRepo.findById (id);

    }

    public Customer addCustomer(Customer customer) {

        return iCustomerRepo.save(customer);
    }


    public void updateCustomer(long id, Customer customer) {
        Optional<Customer> customerUp= iCustomerRepo.findById(id);
        customerUp.get().setName(customer.getName());
        customerUp.get().setAge(customer.getAge());
        customerUp.get().setLocation(customer.getLocation());
        iCustomerRepo.save(customerUp.get());
    }

    public void deleteCustomer(long id) {
        Optional<Customer>  customer=iCustomerRepo.findById(id);
        iCustomerRepo.delete(customer.get());
    }
}
