package com.ecommerce;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductFilter {

    public List<Product> filterByPrice(ProductCatalog catalog, double maxPrice) {
        return catalog.getProducts().stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public List<Product> filterByCategory(ProductCatalog catalog, String category) {
        return catalog.getProducts().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> sortByRating(ProductCatalog catalog) {
        return catalog.getProducts().stream()
                .sorted((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()))
                .collect(Collectors.toList());
    }

    public Optional<Product> findProductByName(ProductCatalog catalog, String name) {
        return catalog.getProducts().stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
