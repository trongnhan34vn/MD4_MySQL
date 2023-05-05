package com.example.bai2_calculator;

public class Operator {
    int num1;
    int num2;
    String operator;
    float result;

    public Operator(int num1, int num2, String operator, float result) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        this.result = result;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
