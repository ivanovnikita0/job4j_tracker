package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Start");
    }

    @Override
    public void passengers(int pas) {
        System.out.println("Number of passengers - " + pas);
    }

    @Override
    public double refuel(int fuel) {
        return fuel * 100;
    }
}
