package com.ecommerce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;
    private final String filePath = "products.txt"; // File path for storing products

    public ProductCatalog() {
        this.products = new ArrayList<>();
        loadProductsFromFile();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        saveProductToFile(product);
    }

    private void loadProductsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                products.add(Product.fromCSV(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Product file not found. Starting with an empty catalog.");
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing product data: " + e.getMessage());
        }
    }

    private void saveProductToFile(Product product) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(product.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error saving product: " + e.getMessage());
        }
    }
}
