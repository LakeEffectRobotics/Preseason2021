// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package ler.robot;

import ler.robot.commands.DriveCommand;
import ler.robot.commands.DriveSlowCommand;
import ler.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /** The robot's drivetrain. */
  private final Drivetrain drivetrain;
  
  /** 
   * The container for the robot. Contains subsystems, OI devices, and commands.
   * @param robot The robot
   */
  public RobotContainer(Robot robot) {
    // Create the drivetrain
    drivetrain = new Drivetrain(robot.map.leftSpark1, robot.map.rightSpark1);
    // Drivetrain should run drivecommand if nothing else is using it
    drivetrain.setDefaultCommand(new DriveCommand(drivetrain, robot.oi.leftStickY, robot.oi.rightStickY));
    // When bumper is held, drive at 50% speed
    robot.oi.leftBumper.whileHeld(new DriveSlowCommand(drivetrain, robot.oi.leftStickY, robot.oi.rightStickY, 0.5));
  }

}
