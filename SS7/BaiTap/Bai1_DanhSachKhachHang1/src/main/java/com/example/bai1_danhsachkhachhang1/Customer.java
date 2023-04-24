package com.example.bai1_danhsachkhachhang1;

public class Customer {
    private int id;
    private String name;
    private String birth;
    private String address;
    private String url;

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
}
