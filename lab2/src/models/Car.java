package models;

public class Car {
    private String brand;
    private Engine engine;

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }

    public class Engine {
        private boolean engineWorks;

        public void startEngine() {
            engineWorks = true;
            System.out.println("started");
        }

        public void stopEngine() {
            engineWorks = false;
            System.out.println("stopped");
        }

        public boolean isEngineWorks() {
            return engineWorks;
        }
    }

    public boolean engineIsRunning() {
        return engine.isEngineWorks();
    }
}
