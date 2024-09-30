import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("first num ");
        int firstNumber = scanner.nextInt();

        System.out.println("second num ");
        int secondNumber = scanner.nextInt();

        int sum = firstNumber + secondNumber;

        System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
    }
}
