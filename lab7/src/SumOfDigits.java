import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SumOfDigits {

    private static final int SIZE = 1_000_000_000; //прийшлось додати часу
    private static final Random random = new Random();

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static long singleThreadedSum(int[] array) {
        long startTime = System.currentTimeMillis();
        long totalSum = 0;
        for (int num : array) {
            totalSum += sumOfDigits(num);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Однопотокова сума: " + totalSum);
        return endTime - startTime;
    }

    public static long multiThreadedSum(int[] array) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        int chunkSize = SIZE / 5;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<Long>> tasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == 4) ? SIZE : (i + 1) * chunkSize;
            tasks.add(() -> {
                long sum = 0;
                for (int j = startIndex; j < endIndex; j++) {
                    sum += sumOfDigits(array[j]);
                }
                return sum;
            });
        }

        List<Future<Long>> results = executor.invokeAll(tasks);
        long totalSum = 0;
        for (Future<Long> result : results) {
            totalSum += result.get();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Багатопотокова сума: " + totalSum);
        executor.shutdown();
        return endTime - startTime;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100000);
        }

        long singleThreadTime = singleThreadedSum(array);
        System.out.println("Час виконання однопотокового варіанту: " + singleThreadTime + " мс");

        long multiThreadTime = multiThreadedSum(array);
        System.out.println("Час виконання багатопотокового варіанту: " + multiThreadTime + " мс");
    }
}
