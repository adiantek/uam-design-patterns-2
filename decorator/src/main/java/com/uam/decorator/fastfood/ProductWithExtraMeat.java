package com.uam.decorator.fastfood;

public class ProductWithExtraMeat {

    private final double extraCost;

    public ProductWithExtraMeat() {
        this.extraCost = 2.5;
    }

    public void describe() {
        System.out.print(" [extra meat]");
    }
}