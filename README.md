# SimpleClock 🕒

[![Java](https://img.shields.io/badge/Java-17+-blue?logo=java)](https://www.oracle.com/java/technologies/downloads/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A simple Java application to update and print the current time and date in the console.

This project is a compact demonstration of core **multithreading** concepts. It uses separate threads for **concurrent** tasks and manages their execution order using **thread priorities**.

### Key Concepts Showcased

-   **Thread Implementation** - Creating tasks with the `Runnable` interface
-   **Thread Priorities** - Setting `MAX_PRIORITY` vs `MIN_PRIORITY` to manage execution
-   **Concurrency** - Safely updating a shared object from multiple threads
-   **Package Structure** - Organizing code into logical modules

---

### How to Run

Modern JDKs can compile and run source files directly.

#### Single-File Version

Navigate to the file's location and double click the `SimpleClock.java` file. Alternatively you can run the following command.

```sh
java SimpleClock.java
```

#### Multi-File (Package) Version

Navigate to the project's root directory (the one containing the `src` folder) and double click the `Main.java` file. Alternatively you can run the following command. Java launcher will automatically find and compile the necessary dependency files.

```sh
java src/Main.java
```
