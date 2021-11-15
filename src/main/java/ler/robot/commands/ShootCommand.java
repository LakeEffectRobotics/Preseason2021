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

	/** Feed Input values */
	DoubleSupplier feedInput;
	/** Shoot Input values */
	DoubleSupplier shootInput;

	/**
	 * Create a new ler.robot.commands.
	 * 
	 * @param shooter The shooter prototype
	 * @param feedInput Double Supplier (lambda) for feeder input values
	 * @param shootInput Double Supplier (lambda) for shooter input values
	 */
	public ShootCommand(Shooter shooter, DoubleSupplier feedInput /** left operator trigger */ , DoubleSupplier shootInput /** right operator trigger */) {
		addRequirements(shooter);
		
		this.shooter = shooter;
		this.feedInput = feedInput;
		this.shootInput = shootInput;
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
		//All Stop for safty
		shooter.allStop();
	}

	/**
	 * Called once every 20ms (nominally).
	 */
	@Override
	public void execute() {
		//TODO: Code that runs periodically while command is active
		//TODO: ie make the code the manage the shooters feed and fire speed
	}

	/**
	 * Called when the command ends.
	 * @param interrupted Flag indicating if the command was interrupted
	 */
	@Override
	public void end(boolean interrupted) {
		//All Stop for safety
		shooter.allStop();
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 */
	@Override
	public boolean isFinished() {
		return false;
	}

}
