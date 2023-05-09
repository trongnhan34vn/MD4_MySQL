package com.example.md4_ss14_baith1_quanlykhachhang.service;

import com.example.md4_ss14_baith1_quanlykhachhang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void remove(int id);
}
