package com.example.md4_ss15_baitap3_tokhaiyte.model;

public class Customer {
    private int id;
    private  String name;
    private int year;
    private String gender;
    private String national;
    private String identityCard;

    public Customer(int id, String name, int year, String gender, String national, String identityCard) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.national = national;
        this.identityCard = identityCard;
    }

    public Customer() {
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", gender='" + gender + '\'' +
                ", national='" + national + '\'' +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }
}
