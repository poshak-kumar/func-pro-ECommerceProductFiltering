package com.ecommerce;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        ProductFilter filter = new ProductFilter();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nE-Commerce Product Filtering Menu:");
            System.out.println("1. Filter products by price");
            System.out.println("2. Filter products by category");
            System.out.println("3. Sort products by rating");
            System.out.println("4. Find product by name");
            System.out.println("5. Add new product");
            System.out.println("6. Exit");

            System.out.print("Choose an option (1-6): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter maximum price: ");
                        double maxPrice = Double.parseDouble(scanner.nextLine());
                        List<Product> affordableProducts = filter.filterByPrice(catalog, maxPrice);
                        System.out.println("Products under $" + maxPrice + ":");
                        affordableProducts.forEach(System.out::println);
                        break;

                    case 2:
                        System.out.print("Enter category: ");
                        String category = scanner.nextLine();
                        List<Product> categoryProducts = filter.filterByCategory(catalog, category);
                        System.out.println(category + " Products:");
                        categoryProducts.forEach(System.out::println);
                        break;

                    case 3:
                        List<Product> sortedProducts = filter.sortByRating(catalog);
                        System.out.println("Products sorted by rating:");
                        sortedProducts.forEach(System.out::println);
                        break;

                    case 4:
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        Optional<Product> product = filter.findProductByName(catalog, productName);
                        product.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Product not found.")
                        );
                        break;

                    case 5:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product category: ");
                        String prodCategory = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter product rating: ");
                        double rating = Double.parseDouble(scanner.nextLine());
                        Product newProduct = new Product(name, prodCategory, price, rating);
                        catalog.addProduct(newProduct);
                        System.out.println("Product added successfully!");
                        break;

                    case 6:
                        running = false;
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        scanner.close();
    }
}
