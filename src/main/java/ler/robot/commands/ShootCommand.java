package ler.robot.commands;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import ler.robot.subsystems.Shooter;

/**
 * Command that runs the shooter.
 */
public class ShootCommand extends CommandBase  {

	/**
	 * The shooter prototype.
	 */
	Shooter shooter;

	DoubleSupplier input;


	/**
	 * Create a new ler.robot.commands.
	 * 
	 * @param shooter The shooter prototype
	 * @param input The input power
	 */
	public ShootCommand(Shooter shooter, DoubleSupplier input) {
		// addRequirements(shooter);
		
		this.shooter = shooter;
		this.input = input;
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
		//TODO: Initialize subsystems
		
	}

	/**
	 * Called once every 20ms (nominally).
	 */
	@Override
	public void execute() {
		//TODO: Code that runs periodically while command is active
		shooter.setShooterTalon(input.getAsDouble());
	}

	/**
	 * Called when the command ends.
	 * @param interrupted Flag indicating if the command was interrupted
	 */
	@Override
	public void end(boolean interrupted) {
		//TODO: Cleanup subsystems
		shooter.setShooterTalon(0);
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 */
	@Override
	public boolean isFinished() {
		return false;
	}

}