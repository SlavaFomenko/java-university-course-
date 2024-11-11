import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;
import static java.util.stream.Collectors.*;


public class Main {
    public static void main(String[] args) {
//        task2();
//        task3();
//        task4();
        task6();
    }

    public static void task2(){
        Printable printable = () -> System.out.println("Printing from lambda!");

        printable.print();
    }

    public static void task3(){
//        task3_a();
//        task3_b();
//        task3_c();
//        task3_d();
    }

    public static void task3_a(){
        Predicate<String> isNumeric = s -> {
            try {
                Double.parseDouble(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Predicate<String> isNonEmpty = s -> !s.isEmpty();
        Predicate<String> isValidNumber = isNumeric.and(isNonEmpty);

        String testString = "123.45";
        System.out.println("Чи є \"" + testString + "\" числом: " + isValidNumber.test(testString));

        String invalidString = "abc";
        System.out.println("Чи є \"" + invalidString + "\" числом: " + isValidNumber.test(invalidString));
    }
    public static void task3_b(){
        Consumer<String> startMessage = s -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endMessage = s -> System.out.println("Пара закінчилася о 9:50");

        Consumer<String> fullMessage = startMessage.andThen(endMessage);

        fullMessage.accept("");
    }
    public static void task3_c(){
        Supplier<String> uppercaseSupplier = () -> "Hello, World!".toUpperCase();

        System.out.println(uppercaseSupplier.get());
    }
    public static void task3_d(){
        Function<String, Integer> multiplyNumbers = s -> Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);

        String numbers = "2 3 4";
        System.out.println("Добуток чисел: " + multiplyNumbers.apply(numbers));
    }


    public static void task4(){
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Dell", 1200, 10),
                new Product("Smartphone", "Apple", 999, 5),
                new Product("Tablet", "Samsung", 800, 7),
                new Product("Headphones", "Sony", 150, 15),
                new Product("Monitor", "LG", 400, 8)
        );

        System.out.println("Бренди:");
        products.stream()
                .map(Product::getBrand)   // Посилання на метод отримання бренду
                .distinct()
                .forEach(System.out::println); // Посилання на метод виведення в консоль

        System.out.println("\nТовари з ціною менше тисячі:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println); // Посилання на метод виведення в консоль

        int totalCount = products.stream()
                .map(Product::getCount) // Посилання на метод отримання кількості
                .reduce(0, Integer::sum); // Посилання на метод підсумовування
        System.out.println("\nЗагальна кількість товарів на складі: " + totalCount);

        System.out.println("\nТовари згруповані по бренду:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(groupingBy(Product::getBrand)); // Посилання на метод отримання бренду
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println(brand + ": " + productList);
        });

        System.out.println("\nТовари відсортовані за зростанням ціни:");
        Product[] sortedProducts = products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)) // Посилання на метод отримання ціни
                .toArray(Product[]::new);
        Arrays.stream(sortedProducts).forEach(System.out::println);
    }
    public static void task6(){
        Integer[] numbers = {1,2,3,6,2};

        String result = Arrays.stream(numbers)
                .max(Integer::compareTo)
                .map(String::valueOf)
                .orElse("Числа відсутні");

        System.out.println(result);
    }
    
}