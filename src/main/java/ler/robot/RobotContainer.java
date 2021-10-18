// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package ler.robot;

import ler.robot.commands.DriveCommand;
import ler.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /** The robot's drivetrain */
  private final Drivetrain drivetrain = new Drivetrain(RobotMap.leftSpark1, RobotMap.rightSpark1);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Drivetrain should run drivecommand if nothing else is using it
    drivetrain.setDefaultCommand(new DriveCommand(drivetrain, OI.leftStickY, OI.rightStickY));
  }

}
