class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Розрахунок завершено!!!");
                return;
            }
            if (i % 10 == 0) {
                System.out.println(i);
            }
            try {
                Thread.sleep(1); // пауза
            } catch (InterruptedException e) {
                System.out.println("Розрахунок завершено!!!");
                return;
            }
        }
    }
}