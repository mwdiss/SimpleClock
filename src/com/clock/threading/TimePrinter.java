package com.clock.threading;

import com.clock.model.Clock;

/**
* Runnable task to continuously print the shared clock's time.
* @author Malith Dissanayake
*/
public class TimePrinter implements Runnable {
    private final Clock clock;

    public TimePrinter(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(clock.getFormattedTime());
                Thread.sleep(1000); //pause for 1 sec
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //restore interrupt status
            System.err.println("printer thread interrupted.");
        }
    }
}