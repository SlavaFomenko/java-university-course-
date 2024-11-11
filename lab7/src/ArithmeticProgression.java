class ArithmeticProgression implements Runnable {
    private static int result = 1;

    private static synchronized void printNext() {
        if (result <= 100) {
            System.out.print(result + " ");
            result++;
        }
    }

    @Override
    public void run() {
        while (result <= 100) {
            printNext();
            try {
                Thread.sleep(200);  // пауза
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}