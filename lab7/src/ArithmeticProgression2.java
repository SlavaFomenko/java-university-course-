class ArithmeticProgression2 implements Runnable {
    private static int result = 1;
    private static final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (result > 100) {
                    break;
                }
                System.out.print(result + " ");
                result++;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}