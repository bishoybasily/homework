package com.gmail.bishoybasily.issr.assignment5;

public class VendingMachine {

    private Integer sodaCount;
    private Double moneyCredit;

    public VendingMachine() {
        this(Constants.STOCK_CAPACITY, 0.0);
    }

    public VendingMachine(Integer sodaCount, Double moneyCredit) {
        this.sodaCount = sodaCount;
        this.moneyCredit = moneyCredit;
    }

    public Double getMoneyCredit() {
        return moneyCredit;
    }

    public Integer getSodaCount() {
        return sodaCount;
    }

    public Double vend(Double paid) {

        if (paid < Constants.SODA_PRICE)
            throw new IllegalArgumentException(String.format("Sorry!, Soda price is: %f", Constants.SODA_PRICE));

        sodaCount--;

        moneyCredit += Constants.SODA_PRICE;

        return paid - Constants.SODA_PRICE;

    }

    public void addMoney(Double amount) {
        moneyCredit += amount;
    }

    public Double withdrawMoney() {
        Double cash = moneyCredit;
        moneyCredit = 0.0;
        return cash;
    }

    public void restock() {
        sodaCount = Constants.STOCK_CAPACITY;
    }

    @Override
    public String toString() {
        return "VendingMachine{" +
                "sodaCount=" + sodaCount +
                ", moneyCredit=" + moneyCredit +
                '}';
    }

    interface Constants {

        Double SODA_PRICE = 0.65;
        Integer STOCK_CAPACITY = 50;

    }
}
