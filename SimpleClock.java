import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
* Multithreaded clock application.
* Demonstrates threads, priorities and shared state.
* @author Malith Dissanayake
*/
public class SimpleClock {

    public static void main(String[] args) {
        System.out.println("starting simple clock application...");

        Clock sharedClock = new Clock();

        //create threads using a helper method to avoid duplicate code
        Thread updater = new Thread(createClockTask(sharedClock::update));
        Thread printer = new Thread(createClockTask(() -> System.out.println(sharedClock.getFormattedTime())));

        //requirement 3: set thread priorities
        updater.setPriority(Thread.MIN_PRIORITY); //priority 1
        printer.setPriority(Thread.MAX_PRIORITY); //priority 10

        System.out.println("starting threads (display has higher priority)...");
        updater.start();
        printer.start();
    }

    /** helper method to create a looping, sleeping runnable task. */
    private static Runnable createClockTask(Runnable action) {
        return () -> {
            try {
                while (true) {
                    action.run();
                    Thread.sleep(1000); //pause for 1 sec
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //restore interrupt status
            }
        };
    }

    /**
    * static nested class for the shared clock object.
    * thread-safe for time access.
    */
    static class Clock {
        private volatile String formattedTime; //volatile for instant thread visibility
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

        public Clock() { this.update(); } //set initial time
        
        public synchronized void update() { //synchronized to prevent race conditions
            this.formattedTime = LocalDateTime.now().format(formatter);
        }
        
        public String getFormattedTime() { return this.formattedTime; }
    }
}