package net.furikuri.clients;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;

    public Product() {
    }

    public Product(
            final String name,
            final BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
