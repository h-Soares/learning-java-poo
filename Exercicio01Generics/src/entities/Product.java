package entities;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Product implements Comparable<Product> {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + ", ");
        sb.append(NumberFormat.getCurrencyInstance().format(price));
        return sb.toString();
    }

    @Override
    public int compareTo(Product o) {
        return price.compareTo(o.getPrice());
    }   
}