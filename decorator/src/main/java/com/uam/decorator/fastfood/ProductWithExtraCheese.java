package com.uam.decorator.fastfood;

import com.google.common.base.Preconditions;

public class ProductWithExtraCheese implements Product {

    private final Product baseProduct;
    private final double extraCost;

    public ProductWithExtraCheese(Product baseProduct) {
        Preconditions.checkNotNull(baseProduct);
        this.baseProduct = baseProduct;
        this.extraCost = 0.5;
    }

    @Override
    public String toString() {
        return baseProduct + " [extra cheese]";
    }

    @Override
    public double getCost() {
        return baseProduct.getCost() + extraCost;
    }
}