package com.example.bai1_danhsachkhachhang;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    int id;
    String name;
    String birth;
    String address;
    String url;

    public Customer(int id, String name, String birth, String address, String url) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public static List<Customer> getCustomers() {
//        List<Customer> listCustomers = new ArrayList<>();
//        listCustomers.add(new Customer(1, "Mai Văn Hoàn", "1983-08-20","HN", "url"));
//        listCustomers.add(new Customer(2, "Nguyễn Văn Nam", "1983-08-21","HN", "url"));
//        listCustomers.add(new Customer(3, "Nguyễn Thái Hoà", "1983-08-22","HN", "url"));
//        listCustomers.add(new Customer(4, "Trần Đăng Khoa", "1983-08-17","HN", "url"));
//        listCustomers.add(new Customer(5, "Nguyễn Đình Thi", "1983-08-19","HN", "url"));
//        return listCustomers;
//    }
}


