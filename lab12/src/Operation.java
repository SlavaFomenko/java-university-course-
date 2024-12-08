
public class Operation {

    public static int addition(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int subtraction(int... numbers) {
        if (numbers.length == 0) return 0;
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static int multiplication(int... numbers) {
        if (numbers.length == 0) return 0;
        int product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }

    public static double division(int... numbers) {
        if (numbers.length == 0) return 0;
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            result /= numbers[i];
        }
        return result;
    }

    public static double average(int... numbers) {
        if (numbers.length == 0) return 0;
        return (double) addition(numbers) / numbers.length;
    }

    public static int maximum(int... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("No numbers provided");
        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static int minimum(int... numbers) {
        if (numbers.length == 0) throw new IllegalArgumentException("No numbers provided");
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
