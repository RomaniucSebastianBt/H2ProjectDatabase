package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
public class CustomerTest {

    @Autowired
    private ICustomerRepo iCustomerRepo;


    @Test
    @Rollback(false)
    public void addCustomerTest() {

        Customer customer = new Customer(1L, "Gheorghe", 17, "Bucuresti");
        Customer customer2 = new Customer(2L, "Ion", 27, "Bucuresti");
        iCustomerRepo.save(customer);
        iCustomerRepo.save(customer2);
        Assertions.assertThat(customer.getId()).isGreaterThan(0);
        Assertions.assertThat(customer2.getId()).isGreaterThan(0);


    }

    @Test
    @Rollback(false)
    public void FindCustomerById() {
        Customer customer = iCustomerRepo.getReferenceById(1L);
        Assertions.assertThat(customer.getId()).isEqualTo(1L);

    }

    @Test
    @Rollback(false)
    public void FindAllCustomers() {
        List<Customer> customer = new ArrayList<>(iCustomerRepo.findAll());
        Assertions.assertThat(customer).size().isGreaterThan(0);


    }

    @Test
    @Rollback(false)
    public void UpdateCustomer() {
        Customer customer = iCustomerRepo.getReferenceById(1l);
        customer.setLocation("Suceava");

        iCustomerRepo.save(customer);

        Customer updatedCustomer = iCustomerRepo.getReferenceById(1l);

        Assertions.assertThat(updatedCustomer.getLocation()).isEqualTo("Suceava");

    }

    @Test
    @Rollback(false)
    public void DeleteCustomerById() {
        Customer customer = iCustomerRepo.getReferenceById(1l);
boolean exist= iCustomerRepo.findById(1L).isPresent();

        iCustomerRepo.deleteById(customer.getId());

boolean doseNotExist= iCustomerRepo.findById(1L).isPresent();

        assertTrue(exist);
        assertFalse(doseNotExist);

    }
}
