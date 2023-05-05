package rikkei.academy.service;

import rikkei.academy.model.Customer;
import rikkei.academy.util.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceIMPL implements ICustomerService {
    private static final Map<Integer, Customer> customers = new HashMap<>();
    static {
        customers.put(1, new Customer(1, "John", "john@rikkei.academy", "HN"));
        customers.put(2, new Customer(2, "Bill", "bill@rikkei.academy", "Đà Nẵng"));
        customers.put(3, new Customer(3, "Alex", "alex@rikkei.academy", "Sài Gòn"));
        customers.put(4, new Customer(4, "Adam", "adam@rikkei.academy", "Miami"));
        customers.put(5, new Customer(5, "Sophia", "sophia@rikkei.academy", "New York"));
        customers.put(6, new Customer(6, "Rose", "rose@rikkei.academy", "HN"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    @Override
    public List<Customer> findAllDB() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection conn  = ConnectionDB.getConnection();
            PreparedStatement pre = conn.prepareStatement("SELECT * FROM customers");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setName(rs.getString("customerName"));
                customer.setAddress(rs.getString("country"));
                list.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
