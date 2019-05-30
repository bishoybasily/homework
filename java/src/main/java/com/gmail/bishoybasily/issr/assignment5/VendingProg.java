package com.gmail.bishoybasily.issr.assignment5;

public class VendingProg {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();
        System.out.println(machine);
        System.out.println();

        try {
            machine.vend(0.50);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(machine);
        System.out.println();

        Double change1 = machine.vend(100.0);
        System.out.printf("Change1: %f\n", change1);
        System.out.println(machine);
        System.out.println();

        Double change2 = machine.vend(80.0);
        System.out.printf("Change2: %f\n", change2);
        System.out.println(machine);
        System.out.println();

        machine.restock();
        System.out.println(machine);
        System.out.println();

        machine.addMoney(0.7);
        System.out.println(machine);
        System.out.println();

        Double cash = machine.withdrawMoney();
        System.out.printf("Total cash: %f\n", cash);
        System.out.println(machine);
        System.out.println();

    }

}
