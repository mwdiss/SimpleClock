package com.clock.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
* shared clock object for thread-safe time access.
* @author Malith Dissanayake
*/
public class Clock {
    //volatile for instant visibility between threads
    private volatile String formattedTime;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    public Clock() {
        this.update(); //set initial time
    }

    //synchronized to prevent multiple threads from updating at once
    public synchronized void update() {
        this.formattedTime = LocalDateTime.now().format(this.formatter);
    }

    public String getFormattedTime() {
        return this.formattedTime;
    }
}