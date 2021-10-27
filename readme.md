# LER 2021 Starter

This codebase serves as a starting point for developing your own robot code

It contains enough code that with some minor configuration you should be able to get a robot driving out of the box.

There is also a subsystem for you to use with your shooter prototype, and a command that is bound to the left bumper. If you want more subsystems or commands you are free to create them.

## Structure
The code has the following structure
```
src
└── main                                - Robot code folder
    ├── deploy                          - Anything in this folder is deployed to RIO memory
    │   └── example.txt        
    └── java/ler/robot
        ├── commands                    - Folder for commands
        │   ├── DriveCommand.java
        │   ├── DriveSlowCommand.java
        │   └── ShootCommand.java
        ├── subsystems                  - Folder for subsystems
        │   ├── Drivetrain.java
        │   └── Shooter.java
        ├── Main.java
        ├── OI.java                     - Controller mappings
        ├── Robot.java
        ├── RobotContainer.java         - Subsytem and command initialisation
        └── RobotMap.java               - Hardware mappings
```