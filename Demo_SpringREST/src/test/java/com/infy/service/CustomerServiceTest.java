package com.infy.service;

import org.junit.jupiter.api.Test;

import com.infy.exception.InfyBankException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
	CustomerService customerService = new CustomerServiceImpl();

    @Test
    void testGetBirthdayDOW() throws InfyBankException {
        String name = customerService.getCustomer(1).getName();
        assertEquals("Martin", name);
    }

}
