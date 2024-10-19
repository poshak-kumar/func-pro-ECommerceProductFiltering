# E-Commerce Product Filtering Project Documentation

## Project Overview

The **E-Commerce Product Filtering** project is a console application developed in Core Java. It allows users to filter and sort products based on various criteria such as price, category, and rating. Users can also add new products, which are stored in a text file for persistence. The project demonstrates the use of Java's Stream API, Lambda Expressions, and the Optional class, along with exception handling for robust input validation and error management.

### Technologies Used

- **Java SE**: Core language features, including Stream API and Lambda Expressions.
- **File I/O**: Reading from and writing to a text file for data persistence.
- **Exception Handling**: Managing potential errors and providing user feedback.

## Project Structure

```
ECommerceProductFiltering/
└── src/
    └── com/
        └── ecommerce/
            ├── Main.java
            ├── Product.java
            ├── ProductCatalog.java
            └── ProductFilter.java
```

## Class Descriptions

### 1. `Product`

**Purpose**: Represents a product in the e-commerce platform, encapsulating product details such as name, category, price, and rating.

#### Fields:
- `String name`: The name of the product.
- `String category`: The category to which the product belongs.
- `double price`: The price of the product.
- `double rating`: The rating of the product.

#### Constructors:
- `Product(String name, String category, double price, double rating)`: Initializes a new Product instance with the specified details.

#### Methods:
- `String getName()`: Returns the name of the product.
- `String getCategory()`: Returns the category of the product.
- `double getPrice()`: Returns the price of the product.
- `double getRating()`: Returns the rating of the product.
- `String toString()`: Returns a string representation of the product in a readable format.
- `String toCSV()`: Converts the product details into a CSV (Comma-Separated Values) format string for easy file storage.
- `static Product fromCSV(String csv)`: Static method that converts a CSV string back into a Product object.

### 2. `ProductCatalog`

**Purpose**: Manages a collection of Product instances, allowing for loading from, saving to, and modifying the product list.

#### Fields:
- `List<Product> products`: A list that stores the products.
- `String filePath`: The file path for storing product data in a text file.

#### Constructor:
- `ProductCatalog()`: Initializes a new ProductCatalog instance and loads products from the specified file.

#### Methods:
- `List<Product> getProducts()`: Returns the list of products.
- `void addProduct(Product product)`: Adds a new product to the catalog and saves it to the file.
- `private void loadProductsFromFile()`: Loads products from the text file into the product list. Handles file not found and input parsing exceptions.
- `private void saveProductToFile(Product product)`: Saves a new product to the text file. Handles IO exceptions.

### 3. `ProductFilter`

**Purpose**: Provides filtering and sorting functionalities for the product catalog using Stream API and lambda expressions.

#### Methods:
- `List<Product> filterByPrice(ProductCatalog catalog, double maxPrice)`: Filters products that are within the specified price range and returns a list of such products.
- `List<Product> filterByCategory(ProductCatalog catalog, String category)`: Filters products based on the specified category and returns a list of matching products.
- `List<Product> sortByRating(ProductCatalog catalog)`: Sorts the products by their rating in descending order and returns the sorted list.
- `Optional<Product> findProductByName(ProductCatalog catalog, String name)`: Searches for a product by name and returns an Optional containing the product if found.

### 4. `Main`

**Purpose**: Acts as the entry point of the application. Provides a user interface for interaction, allowing users to filter, sort, add, and find products.

#### Main Method:
- `public static void main(String[] args)`: Contains the main application loop, displaying the menu and handling user input. It uses a `Scanner` for reading user input and manages user choices, invoking methods from the `ProductCatalog` and `ProductFilter` classes.

## Detailed Step-by-Step Implementation

### Step 1: Set Up the Development Environment

1. **Install JDK**: Ensure that the Java Development Kit (JDK) is installed on your machine.
2. **Choose an IDE**: Use an Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse to facilitate coding and project management.

### Step 2: Create the Project

1. **Create a New Java Project**: Name it `ECommerceProductFiltering`.
2. **Create Package**: Inside the `src` directory, create a package called `com.ecommerce`.

### Step 3: Implement the Product Class

- Create a new file named `Product.java` and implement the `Product` class, as explained above. This class is responsible for managing product data.

### Step 4: Implement the ProductCatalog Class

- Create a new file named `ProductCatalog.java`. This class manages the list of products and handles file I/O operations to load and save product data.

### Step 5: Implement the ProductFilter Class

- Create a new file named `ProductFilter.java`. This class provides methods for filtering and sorting products using Java's functional programming features.

### Step 6: Implement the Main Class

- Create a new file named `Main.java`. This class serves as the user interface for the application, displaying the menu options and handling user inputs.

### Step 7: Run and Test the Application

1. **Compile and Run**: Compile the `Main` class and run the application.
2. **Test User Scenarios**: Interact with the menu options to filter products, add new products, and handle invalid inputs to ensure the application behaves as expected.

### Step 8: Exception Handling

- Exception handling has been incorporated throughout the application:
  - **File I/O**: `FileNotFoundException` and `IOException` are handled in `ProductCatalog` to manage file operations gracefully.
  - **User Input**: `NumberFormatException` is handled in the `Main` class to validate user inputs and prevent the application from crashing.

## Example Usage

### Menu Options
- **1. Filter products by price**: Enter a maximum price to see all products within that price range.
- **2. Filter products by category**: Enter a product category to see all products belonging to that category.
- **3. Sort products by rating**: View a list of products sorted by their rating in descending order.
- **4. Find product by name**: Search for a product by its name. If found, the product details will be displayed.
- **5. Add new product**: Input details for a new product, which will then be saved to the product list and file.
- **6. Exit**: Close the application.

### Sample Output

```
E-Commerce Product Filtering Menu:
1. Filter products by price
2. Filter products by category
3. Sort products by rating
4. Find product by name
5. Add new product
6. Exit
Choose an option (1-6): 1
Enter maximum price: 50.00
Products under $50.00:
Product{name='Product A', category='Electronics', price=29.99, rating=4.5}
Product{name='Product B', category='Books', price=19.99, rating=4.7}
```

## Future Enhancements

- **Improve User Interface**: Implement a graphical user interface (GUI) using Java Swing or JavaFX for better user experience.
- **Add More Filters**: Provide options to filter by product rating range or other attributes.
- **Database Integration**: Implement a database (e.g., SQLite, MySQL) for more robust data management instead of using a text file.
- **Unit Testing**: Add unit tests to ensure the correctness of methods and functionalities.

## Conclusion

The **E-Commerce Product Filtering** project showcases the application of core Java concepts, including object-oriented programming, functional programming with the Stream API, and exception handling. This documentation serves as a comprehensive guide to understanding the structure and functionality of the project. It provides a solid foundation for further enhancements and scalability.
