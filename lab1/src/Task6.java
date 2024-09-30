import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("quantity num: ");
        int n = scanner.nextInt();

        int[] fibonacciArray = new int[n];
        if (n >= 1) fibonacciArray[0] = 1;
        if (n >= 2) fibonacciArray[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        int[] reverseFibonacciArray = new int[n];
        for (int i = 0; i < n; i++) {
            reverseFibonacciArray[i] = fibonacciArray[n - 1 - i];
        }

        System.out.print("first arr ");
        for (int num : fibonacciArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("last arr ");
        for (int num : reverseFibonacciArray) {
            System.out.print(num + " ");
        }
    }
}
