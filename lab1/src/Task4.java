import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("first num ");
        int firstNumber = scanner.nextInt();

        System.out.println("second num ");
        int secondNumber = scanner.nextInt();

        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }

        System.out.println("result " + firstNumber);


    }
}
