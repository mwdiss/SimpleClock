package com.clock.threading;

import com.clock.model.Clock;

/**
* runnable task to continuously update the shared clock.
* @author Malith Dissanayake
*/
public class TimeUpdater implements Runnable {
    private final Clock clock;

    public TimeUpdater(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        try {
            while (true) {
                clock.update();
                Thread.sleep(1000); //pause for 1 sec
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); //restore interrupt status
            System.err.println("updater thread interrupted.");
        }
    }
}