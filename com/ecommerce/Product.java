package com.ecommerce;

public class Product {
    private String name;
    private String category;
    private double price;
    private double rating;

    public Product(String name, String category, double price, double rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    public String toCSV() {
        return name + "," + category + "," + price + "," + rating;
    }

    public static Product fromCSV(String csv) {
        String[] values = csv.split(",");
        return new Product(values[0], values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]));
    }
}
