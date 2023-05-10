package com.example.md4_ss15_baitap3_tokhaiyte.model;

public class DeclareForm {
    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private Symtoms symptoms;
    private HistoryInfection historyInfection;

    public DeclareForm() {
    }

    public DeclareForm(int id, Customer customer, Vehicle vehicle, Symtoms symptoms, HistoryInfection historyInfection) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.symptoms = symptoms;
        this.historyInfection = historyInfection;
    }

    public DeclareForm(Customer customer, Vehicle vehicle, Symtoms symptoms, HistoryInfection historyInfection) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.symptoms = symptoms;
        this.historyInfection = historyInfection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Symtoms getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Symtoms symptoms) {
        this.symptoms = symptoms;
    }

    public HistoryInfection getHistoryInfection() {
        return historyInfection;
    }

    public void setHistoryInfection(HistoryInfection historyInfection) {
        this.historyInfection = historyInfection;
    }

    @Override
    public String toString() {
        return "DeclareForm{" +
                "id=" + id +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", symptoms=" + symptoms +
                ", historyInfection=" + historyInfection +
                '}';
    }
}
