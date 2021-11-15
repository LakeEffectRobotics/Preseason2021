package ler.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import ler.robot.subsystems.Shooter;

/**
 * Command that runs the shooter.
 */
public class FeederCommand extends CommandBase  {

	/**
	 * The shooter prototype.
	 */
	Shooter shooter;


	/**
	 * Create a new ler.robot.commands.
	 * 
	 * @param shooter The shooter prototype
	 */
	public FeederCommand(Shooter shooter) {
		addRequirements(shooter);
		
		this.shooter = shooter;
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
    shooter.setFeederTalon(0.05);
	}

	/**
	 * Called when the command ends.
	 * @param interrupted Flag indicating if the command was interrupted
	 */
	@Override
	public void end(boolean interrupted) {
		//TODO: Cleanup subsystems
		shooter.setFeederTalon(0);
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 */
	@Override
	public boolean isFinished() {
		return false;
	}

}