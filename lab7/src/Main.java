public class Main {
    public static void main(String[] args) {
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
    }

    public static void task2(){
        MyThread myThread = new MyThread();

        System.out.println("Стан потоку перед стартом: " + myThread.getState());

        myThread.start();

        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи живий потік: " + myThread.isAlive());
        System.out.println("Чи є потоком-демоном: " + myThread.isDaemon());

        myThread.setName("MyCustomThread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріоритет потоку: " + myThread.getPriority());

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
    }
    public static void task3(){
        MyRunnable task = new MyRunnable();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
    }
    public static void task4(){
        ArithmeticProgression task = new ArithmeticProgression();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static void task5(){
        ArithmeticProgression2 task = new ArithmeticProgression2();

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static void task6(){
        SharedData sharedData = new SharedData();

        Thread readerThread = new Thread(new Reader(sharedData));
        Thread printerThread = new Thread(new Printer(sharedData));

        readerThread.start();
        printerThread.start();
    }
    public static void task7(){}
}