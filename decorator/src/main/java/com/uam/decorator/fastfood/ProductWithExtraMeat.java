package com.uam.decorator.fastfood;

import com.google.common.base.Preconditions;

public class ProductWithExtraMeat implements Product {

    private final Product baseProduct;
    private final double extraCost;

    public ProductWithExtraMeat(Product baseProduct) {
        Preconditions.checkNotNull(baseProduct);
        this.baseProduct = baseProduct;
        this.extraCost = 2.5;
    }

    @Override
    public String toString() {
        return baseProduct + " [extra meat]";
    }

    @Override
    public double getCost() {
        return baseProduct.getCost() + extraCost;
    }
}