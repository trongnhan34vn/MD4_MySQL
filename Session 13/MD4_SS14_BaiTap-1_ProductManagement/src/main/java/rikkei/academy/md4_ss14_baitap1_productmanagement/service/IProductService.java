package rikkei.academy.md4_ss14_baitap1_productmanagement.service;

import rikkei.academy.md4_ss14_baitap1_productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void remove(int id);
    Product findById(int id);
}
