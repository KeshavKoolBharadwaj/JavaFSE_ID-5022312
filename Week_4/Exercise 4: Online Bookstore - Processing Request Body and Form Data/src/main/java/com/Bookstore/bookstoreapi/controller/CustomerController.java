package com.Bookstore.bookstoreapi.controller;

import com.Bookstore.bookstoreapi.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PostMapping("/customers/json")
    public ResponseEntity<?> createCustomerJson(@RequestBody Customer customer) {
        if (customer.getId() == 0 || customer.getFirstName() == null || customer.getLastName() == null ||
                customer.getEmail() == null || customer.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All fields are required");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PostMapping("/customers/form")
    public ResponseEntity<?> createCustomerForm(
            @RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password) {

        if (id == 0 || firstName == null || lastName == null || email == null || password == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("All fields are required");
        }

        Customer customer = new Customer(id, firstName, lastName, email, password);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
