import java.util.Scanner;

class SharedData {
    private String data;
    private boolean running = true;

    public synchronized void readData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рядок (або 'exit' для завершення): ");
        data = scanner.nextLine();

        if (data.equalsIgnoreCase("exit")) {
            running = false;
        }

        notify();

        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printData() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (data != null) {
            System.out.println("Отриманий рядок: " + data);
        }

        notify();
    }

    public boolean isRunning() {
        return running;
    }
}