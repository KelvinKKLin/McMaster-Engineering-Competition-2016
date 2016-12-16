#McMaster Engineering Competition (Programming Division) 2016 Weather Station Simulation
This project simulates a weather system that broadcasts weather information and alerts sailors of critical/dangerous conditions. It was created for the McMaster Engineering Competition (Programming Division) 2016, where it received third place out of 20 participating teams.

This program runs in discrete time steps. Whenever the uesr presses `Start`, the program simulates 1 time step.

## Contents of the Repository
1. The source code is located in MEC-Team1-Code/Competition/src/competition
2. A Makefile is located in MEC-Team1-Code/Competition/src
3. The presentation used in the competition is located in the root directory.
4. A design document is available in the root directory.
5. JavaDocs are available in MEC-Team1-Code/Competition/doc.
6. Test cases are available in SystemTest.java, found in the root directory.

## Compiling the Source Code
The source code can be compiled using the provided Makefile. The Makefile is located in MEC-Team1-Code/Competition/src.

Navigate to the /src folder, and open a terminal. Type `make` to compile the source code. To run the source code, type `./run.sh` in the terminal, or double click on the Main.jar file.

To clean up the repository, you can use the `make clean` command. The `make clean` command will delete all of the generated .class files, the Manifest file, as well as the .jar file.

## Using the Program
1. To simulate a SINGLE time step, press `Start`.
2. To enter test values for sensors, press `Test`.
3. Enter test values in the provided fields.
4. Press `Test` to run a time step with your specified values.