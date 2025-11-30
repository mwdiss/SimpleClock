import com.clock.model.Clock;
import com.clock.threading.TimePrinter;
import com.clock.threading.TimeUpdater;

/**
* Main app for the simple clock.
* Demonstrates creating threads with different priorities.
* @author Malith Dissanayake
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("starting simple clock application...");
        
        //single shared clock instance
        Clock sharedClock = new Clock();

        //create runnable tasks and their threads
        Thread updaterThread = new Thread(new TimeUpdater(sharedClock));
        Thread printerThread = new Thread(new TimePrinter(sharedClock));

        //requirement 3: set thread priorities
        //display thread (printer) gets higher priority for responsiveness
        updaterThread.setPriority(Thread.MIN_PRIORITY); //priority 1
        printerThread.setPriority(Thread.MAX_PRIORITY); //priority 10
        
        System.out.println("starting clock threads (display has higher priority)...");

        //start both threads to run concurrently
        updaterThread.start();
        printerThread.start();
    }
}