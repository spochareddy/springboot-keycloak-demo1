package com.example.demo.controller;

import com.example.demo.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/")
public class DemoController {

    @GetMapping("customers")
    public List<Customer> getAll() {
        return addCustomers();
    }
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {

        List<Customer> list = addCustomers();
        Customer customer = list.stream().filter(x->x.getId()==1).collect(Collectors.toList()).get(0);

        if (customer != null)
            return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<Customer> addCustomers() {
        List<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setAddress("Saudi");
        customer1.setName("Neom");
        customer1.setServiceRendered("Travel");
        list.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setAddress("Dubai");
        customer2.setName("Tonamus");
        customer2.setServiceRendered("Booking");
        list.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setAddress("Malaysia");
        customer3.setName("Sindalah");
        customer3.setServiceRendered("Internet");
        list.add(customer3);

        return list;
    }
}
