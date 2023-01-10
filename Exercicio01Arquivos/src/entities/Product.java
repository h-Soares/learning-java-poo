package entities;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Product {
    private String name;
    private BigDecimal price;
    private int quantity;
    
    public Product(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + ",");
        sb.append(NumberFormat.getCurrencyInstance().format(price.multiply(BigDecimal.valueOf(quantity))));
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}