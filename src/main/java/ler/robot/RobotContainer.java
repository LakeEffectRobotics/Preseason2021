// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package ler.robot;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import ler.robot.commands.DriveCommand;
import ler.robot.commands.DriveSlowCommand;
import ler.robot.commands.CloseGateCommand;
import ler.robot.subsystems.Drivetrain;
import ler.robot.subsystems.Gate;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /** The robot's drivetrain. */
  private Drivetrain drivetrain;
  
  /** The prototype shooter. */
  private Gate gate;

  /** 
   * The container for the robot. Contains subsystems and commands.
   */
  public RobotContainer() {
    // Initialise hardware
    RobotMap.init();

    // Create the drivetrain
    drivetrain = new Drivetrain(RobotMap.leftTalon1, RobotMap.rightTalon1);
    drivetrain.setDefaultCommand(new DriveCommand(drivetrain, OI.leftStickY, OI.rightStickY));
    gate = new Gate(RobotMap.gateMotor, RobotMap.topLimitSwitch, RobotMap.botLimitSwitch);

    // Initialise button mappings
    initMappings();
  }

  /**
   * Initialise IO mappings.
   */
  private void initMappings(){
    // When bumper is held, drive at 50% speed
    OI.halfSpeedButton.whileHeld(new DriveSlowCommand(drivetrain, OI.leftStickY, OI.rightStickY, 0.5));

    // When print button is pressed, print message
    OI.printButton.whenPressed(new PrintCommand("Print button pressed!"));
    // While shoot button is held run shoot command
    OI.openGateButton.whenPressed(new CloseGateCommand(gate));
  }

}
