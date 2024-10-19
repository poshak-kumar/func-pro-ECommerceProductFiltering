### **Lambda Expressions in Java: A Comprehensive Guide**

**Lambda expressions** are one of the most significant features introduced in **Java 8**. They allow for a more concise way to express instances of single-method interfaces (functional interfaces). Lambda expressions improve code readability and help in writing code in a functional programming style.

This guide covers everything about lambda expressions, from the basics to advanced topics, including syntax, use cases, functional interfaces, method references, and how lambda expressions integrate with the **Streams API**.

---

### **1. What is a Lambda Expression?**

A **lambda expression** is a short block of code that takes in parameters and returns a value. Lambda expressions are primarily used to define the behavior of functional interfaces (an interface with only one abstract method).

**Lambda Expression** is a **anonymous function**, having **no name**, **no modifier** and **no return type**.

Before Java 8, we had to use **anonymous inner classes** to implement functional interfaces. With lambda expressions, this becomes much simpler and more readable.

#### Basic Example:
```java
// Traditional way using an anonymous inner class
Runnable runnable = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
};

// Using lambda expression (Java 8 and later)
Runnable runnable = () -> System.out.println("Hello World");
```

---

### **2. Lambda Expression Syntax**

The syntax for a lambda expression is more concise than that of an anonymous inner class. It has three components:

1. **Parameters**: These are the inputs to the lambda expression.
2. **Arrow Token (`->`)**: Separates the parameters and the body of the lambda.
3. **Body**: This can be a single expression or a block of statements.

#### Syntax:
```java
(parameters) -> expression
```

OR

```java
(parameters) -> { statements; }
```

#### Example:
```java
// Lambda with no parameters
() -> System.out.println("Hello");

// Lambda with a single parameter
x -> x * x;

// Lambda with multiple parameters
(x, y) -> x + y;

// Lambda with block of statements
(x, y) -> {
    int sum = x + y;
    return sum;
};
```

### Benifits of Lambda Expression
- Reduces the lines of code. but it can be used only with Functional Interface.
- Sequential and parallel exicution support by passing as an argument in methods.
- To call APIs very effectively.
- To write more readable, maintainable and concise code.
- **Imp point📌** In **Lambda Expression** Java Compiler also automatically inffer the type of variable passed in arguments, so type is optional.

---

### **3. Functional Interfaces**

A **functional interface** is an interface with a single abstract method. Lambda expressions work with functional interfaces because they are used to provide an implementation for that single abstract method.
<br>
&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;``OR``
<br>
The Functional Interface contains only one abstract method.
**Ex:** Runnable Interface, Callable Interface, Comparable Interface, etc. (These are the Functional Interfaces).

To call the Lambda Expression we required Functional Interface and Lambda is used to implement Functional Interface in very simple and short manner.

#### Example of a Functional Interface:
```java
@FunctionalInterface
interface Calculator {
    int calculate(int x, int y);
}
```

Lambda expressions can be used to instantiate a functional interface by directly providing the implementation for the abstract method.

#### Example:
```java
public class Main {
    public static void main(String[] args) {
        // Lambda expression providing implementation for the calculate() method
        Calculator addition = (a, b) -> a + b;

        // Using the lambda expression
        int result = addition.calculate(10, 20);  // result will be 30
        System.out.println(result);
    }
}
```

---

### **4. Types of Lambda Expressions**

There are different types of lambda expressions based on how they are written:

1. **No Parameters**: A lambda with no parameters.
   ```java
   () -> System.out.println("No parameters");
   ```

2. **One Parameter**: A lambda with a single parameter. Parentheses are optional for single parameters.
   ```java
   x -> x * x;
   ```

3. **Multiple Parameters**: A lambda with multiple parameters.
   ```java
   (x, y) -> x + y;
   ```

4. **With Multiple Statements**: A lambda can contain multiple statements enclosed within curly braces.
   ```java
   (x, y) -> {
       int sum = x + y;
       System.out.println("Sum: " + sum);
       return sum;
   };
   ```

5. **Lambda with Return Statement**: If the body has a single expression, the return keyword can be omitted. For multiple statements, the return keyword is necessary.
   ```java
   (a, b) -> {
       int result = a + b;
       return result;
   };
   ```

---

### **5. Lambda Expressions with Functional Interfaces**

Java provides several built-in functional interfaces in the `java.util.function` package. These interfaces can be used with lambda expressions. Some common functional interfaces are:

1. **`Function<T, R>`**: Takes one argument and produces a result.
2. **`Predicate<T>`**: Takes one argument and returns a boolean.
3. **`Consumer<T>`**: Takes one argument and performs an operation without returning a result.
4. **`Supplier<T>`**: Provides a result without taking any argument.

#### Example:
```java
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // Using Function interface: converts String to Integer
        Function<String, Integer> lengthFunc = str -> str.length();
        System.out.println(lengthFunc.apply("Lambda"));  // Output: 6

        // Using Predicate interface: checks if a number is even
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10));  // Output: true
    }
}
```

---

### **6. Method References**

**Method references** are a shorthand for writing lambdas. They allow you to refer to methods directly by their names.

Types of method references:
1. **Static Method Reference**: ClassName::staticMethod
2. **Instance Method Reference of an Object**: object::instanceMethod
3. **Instance Method Reference of a Class**: ClassName::instanceMethod
4. **Constructor Reference**: ClassName::new

#### Example:
```java
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Lambda expression
        Consumer<String> printerLambda = str -> System.out.println(str);

        // Method reference (shorter form of above lambda)
        Consumer<String> printerMethodRef = System.out::println;

        printerMethodRef.accept("Hello with Method Reference");  // Output: Hello with Method Reference
    }
}
```

---

### **7. Lambda Expressions with Collections (Streams API)**

One of the most powerful applications of lambda expressions is their integration with the **Streams API**. The Streams API allows processing of sequences of elements using functional-style operations such as `filter`, `map`, `reduce`, etc.

#### Example with Streams API:
```java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Paul", "George", "Ringo");

        // Using lambda with Streams API to filter and print names
        names.stream()
             .filter(name -> name.startsWith("J"))
             .forEach(System.out::println);  // Output: John
    }
}
```

---

### **8. Variable Capture in Lambda Expressions**

Lambda expressions can capture and use variables from their surrounding scope. This is similar to anonymous classes, but with lambda expressions, the captured variables must be **effectively final** (i.e., they should not be modified after they are initialized).

#### Example:
```java
public class Main {
    public static void main(String[] args) {
        int factor = 10;

        // Lambda capturing the 'factor' variable from the surrounding scope
        Function<Integer, Integer> multiply = x -> x * factor;

        // factor is effectively final and can be used in lambda
        System.out.println(multiply.apply(5));  // Output: 50
    }
}
```

---

### **9. Lexical Scope and Closure**

A **lambda expression** has access to the variables in the lexical scope where it is defined, i.e., it can access local variables, instance variables, and static variables. This is known as **closure**.

#### Example:
```java
public class Main {
    int instanceVar = 20;

    public static void main(String[] args) {
        Main obj = new Main();
        obj.demo();
    }

    public void demo() {
        int localVar = 10;

        // Lambda has access to both instanceVar and localVar
        Function<Integer, Integer> adder = x -> x + localVar + instanceVar;

        System.out.println(adder.apply(5));  // Output: 35
    }
}
```

---

### **10. Limitations of Lambda Expressions**

1. **No Checked Exceptions**: Lambda expressions cannot directly throw checked exceptions unless the abstract method of the functional interface allows it. You need to handle checked exceptions using try-catch blocks or create custom functional interfaces.

   ```java
   // This will result in a compilation error because checked exception IOException is not handled
   Consumer<String> fileOpener = (filename) -> {
       Files.readAllLines(Paths.get(filename));  // IOException
   };
   ```

2. **Limited Control Flow**: Lambda expressions cannot contain certain control flow structures like `break`, `continue`, or `return` when used inside loops or switch cases.

---

### **Conclusion**

Lambda expressions in Java bring functional programming elements to the language, offering a cleaner and more expressive way of handling single-method interfaces. Key takeaways include:

- **Syntax**: Lambda expressions provide a concise syntax for anonymous functions.
- **Functional Interfaces**: Lambda expressions work with functional interfaces, especially those in `java.util.function`.
- **Method References**: Simplify lambda expressions by referring to existing methods.
- **Streams API**: Lambda expressions enable functional-style operations on collections.
- **Variable Capture**: Lambdas can access variables from their enclosing scope, as long as they are effectively final.

Lambda expressions are a powerful tool that simplifies coding and improves readability, making Java code

 more expressive and easier to maintain.