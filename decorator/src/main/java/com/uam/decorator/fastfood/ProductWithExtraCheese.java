package com.uam.decorator.fastfood;

public class ProductWithExtraCheese {

    private final double extraCost;

    public ProductWithExtraCheese() {
        this.extraCost = 0.5;
    }

    public void describe() {
        System.out.print(" [extra cheese]");
    }
}