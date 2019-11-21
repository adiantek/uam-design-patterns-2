package com.uam.decorator;

import com.uam.decorator.fastfood.Cheeseburger;
import com.uam.decorator.fastfood.Product;
import com.uam.decorator.fastfood.ProductWithExtraCheese;
import com.uam.decorator.fastfood.ProductWithExtraMeat;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Cheeseburger());
        products.add(new ProductWithExtraCheese(new Cheeseburger()));
        products.add(new ProductWithExtraMeat(new Cheeseburger()));
        products.add(new ProductWithExtraMeat(new ProductWithExtraCheese(new Cheeseburger())));
        products.forEach(p -> System.out.println(p.getCost() + " - " + p));
        System.out.println("==========");
        System.out.println(products.stream().mapToDouble(Product::getCost).sum() + " - Total");
    }
}
