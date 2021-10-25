# LER 2021 Starter

This codebase serves as a starting point for developing your own robot code

It contains enough code that with some minor configuration you should be able to get a robot driving out of the box.

## Structure
The code has the following structure
```
src
├── main                                - Robot code folder
│   ├── deploy                          - Anything in this folder is deployed to RIO memory
│   │   └── example.txt        
│   └── java/ler/robot
│       ├── commands                    - Folder for commands
│       │   ├── DriveCommand.java
│       │   └── DriveSlowCommand.java
│       ├── subsystems                  - Folder for subsystems
│       │   └── Drivetrain.java
│       ├── Main.java
│       ├── OI.java                     - Controller mappings
│       ├── Robot.java
│       ├── RobotContainer.java         - Subsytem and command initialisation
│       └── RobotMap.java               - Hardware mappings
└── test                                - Testing code folder
    └── java/ler/robot
        ├── commands                    - Test code for commands
        │   ├── DriveCommandTest.java
        │   └── DriveSlowCommandTest.java
        └── subsystems                  - Test code for subsystems
            └── DrivetrainTest.java
```