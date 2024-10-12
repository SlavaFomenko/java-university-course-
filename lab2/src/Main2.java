import enums.Location;
import models.Operation;

public class Main2 {

    public static void main(String[] args) {
        int[] numbers = {10, 5, 2};

        System.out.println("Addition: " + Operation.addition(numbers));
        System.out.println("Subtraction: " + Operation.subtraction(numbers));
        System.out.println("Multiplication: " + Operation.multiplication(numbers));
        System.out.println("Division: " + Operation.division(numbers));
        System.out.println("Average: " + Operation.average(numbers));
        System.out.println("Maximum: " + Operation.maximum(numbers));
        System.out.println("Minimum: " + Operation.minimum(numbers));

        System.out.println("Locations:");
        for (Location location : Location.values()) {
            System.out.println(location);
        }
    }
}
