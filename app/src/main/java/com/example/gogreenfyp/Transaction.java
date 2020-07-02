package com.example.gogreenfyp;

public class Transaction {

    private double amount;
    private String place;
    private String item;
    private String transactionNo;
    private int points;

    public Transaction(){

    }

    public Transaction(double amount, String place, String item, String transactionNo, int points) {
        this.amount = amount;
        this.place = place;
        this.item = item;
        this.transactionNo = transactionNo;
        this.points = points;
    }

    public double getAmount() {
        return amount;
    }

    public String getPlace() {
        return place;
    }

    public String getItem() {
        return item;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public int getPoints() {
        return points;
    }


}
