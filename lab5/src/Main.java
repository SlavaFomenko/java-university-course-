import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        task3();
//        task4();
//        task5();
        task6();
//        task7();

    }
    public static void task3(){
        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1200.0, 5));
        products.add(new Product("Phone", 800.0, 10));
        products.add(new Product("Tablet", 300.0, 7));

        products.addAll(List.of(new Product("Monitor", 150.0, 3), new Product("Keyboard", 25.0, 20)));
        System.out.println("products: " + products);

        Product phone = products.get(1);
        System.out.println("second element: " + phone);

        int indexOfTablet = products.indexOf(new Product("Tablet", 300.0, 7));
        System.out.println("tablet index: " + indexOfTablet);

        products.set(2, new Product("Smartwatch", 200.0, 8));
        System.out.println("after setting third element: " + products);

        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("after sorting: " + products);

        List<Product> subList = products.subList(1, 3);
        System.out.println("sublist: " + subList);

        products.clear();
        System.out.println("list after clearing: " + products);
        System.out.println("is list empty? " + products.isEmpty());
    }
    public static void task4(){
        Deque<Product> productQueue = new ArrayDeque<>();

        productQueue.push(new Product("Router", 100.0, 4));
        productQueue.offerLast(new Product("Switch", 80.0, 2));
        productQueue.offerLast(new Product("Modem", 60.0, 1));

        System.out.println("first element: " + productQueue.getFirst());
        System.out.println("last element: " + productQueue.peekLast());

        Product removedFirst = productQueue.pop();
        System.out.println("removed first element: " + removedFirst);

        Product removedLast = productQueue.removeLast();
        System.out.println("removed last element: " + removedLast);

        System.out.println("queue after operations: " + productQueue);
    }
    public static void task5(){
        NavigableSet<Product> productSet = new TreeSet<>();

        productSet.add(new Product("Laptop", 1200.0, 5));
        productSet.add(new Product("Phone", 800.0, 10));
        productSet.add(new Product("Tablet", 300.0, 7));
        productSet.add(new Product("Monitor", 150.0, 3));

        System.out.println("product set: " + productSet);

        System.out.println("first element: " + productSet.first());
        System.out.println("last element: " + productSet.last());

        System.out.println("elements less than 800: " + productSet.headSet(new Product("", 800.0, 0)));
        System.out.println("elements between 300 and 1200: " + productSet.subSet(new Product("", 300.0, 0), new Product("", 1200.0, 0)));
        System.out.println("elements greater or equal to 800: " + productSet.tailSet(new Product("", 800.0, 0)));

        System.out.println("nearest element >= 400: " + productSet.ceiling(new Product("", 400.0, 0)));
        System.out.println("nearest element <= 1000: " + productSet.floor(new Product("", 1000.0, 0)));

        System.out.println("nearest element > 500: " + productSet.higher(new Product("", 500.0, 0)));
        System.out.println("nearest element < 900: " + productSet.lower(new Product("", 900.0, 0)));

        System.out.println("removing first element: " + productSet.pollFirst());
        System.out.println("removing last element: " + productSet.pollLast());

        System.out.println("set in descending order: " + productSet.descendingSet());
    }
    public static void task6(){
        Map<String, Product> productMap = new HashMap<>();

        productMap.put("Laptop", new Product("Laptop", 1200.0, 5));
        productMap.put("Phone", new Product("Phone", 800.0, 10));
        productMap.put("Tablet", new Product("Tablet", 300.0, 7));

        System.out.println("product map: " + productMap);

        System.out.println("getting product by key 'Phone': " + productMap.get("Phone"));
        System.out.println("map contains key 'Laptop'? " + productMap.containsKey("Laptop"));
        System.out.println("map contains value 'Tablet'? " + productMap.containsValue(new Product("Tablet", 300.0, 7)));

        productMap.putIfAbsent("Monitor", new Product("Monitor", 150.0, 3));
        System.out.println("after putIfAbsent: " + productMap);

        System.out.println("keys: " + productMap.keySet());
        System.out.println("values: " + productMap.values());

        productMap.remove("Tablet");
        System.out.println("after removing 'Tablet': " + productMap);

        System.out.println("map size: " + productMap.size());

        productMap.clear();
        System.out.println("after clearing map: " + productMap);

        productMap.put("Laptop", new Product("Laptop", 1200.0, 5));
        productMap.put("Phone", new Product("Phone", 800.0, 10));

        for (Map.Entry<String, Product> entry : productMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
    public static void task7(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 4, 8));

        Collections.sort(numbers);
        System.out.println("after sorting: " + numbers);

        Collections.reverse(numbers);
        System.out.println("after reverse: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("after shuffle: " + numbers);

        Collections.fill(numbers, 7);
        System.out.println("after fill: " + numbers);

        numbers = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 4, 8));
        System.out.println("max: " + Collections.max(numbers));
        System.out.println("min: " + Collections.min(numbers));

        List<Integer> copy = new ArrayList<>(Arrays.asList(new Integer[numbers.size()]));
        Collections.copy(copy, numbers);
        System.out.println("list copy: " + copy);

        Collections.rotate(numbers, 2);
        System.out.println("after rotate: " + numbers);

        int freq = Collections.frequency(numbers, 3);
        System.out.println("frequency of 3: " + freq);
    }
}
