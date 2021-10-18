package ler.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import ler.robot.subsystems.Drivetrain;

/**
 * Command that controls the drivetrain.
 */
public class DriveCommand extends CommandBase  {

	/**
	 * The robot's drivetrain.
	 */
	Drivetrain drivetrain;

	/** Left input value */
	DoubleSupplier leftInput;
	/** Right input value */
	DoubleSupplier rightInput;

	/**
	 * Create a new frc.robot.commands.
	 * 
	 * @param drivetrain The robot's drivetrain
	 * @param leftInput Double Supplier (lambda) for left side input values
	 * @param rightInput Double Supplier (lambda) for right side input values
	 */
	public DriveCommand(Drivetrain drivetrain, DoubleSupplier leftInput, DoubleSupplier rightInput) {
		addRequirements(drivetrain);
		
		this.drivetrain = drivetrain;
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
		// Stop drivetrain for safety
		drivetrain.stop();
	}
	
	/**
	 * Called once every 20ms (nominally).
	 */
	@Override
	public void execute() {
		drivetrain.setOutput(leftInput.getAsDouble(), rightInput.getAsDouble());
	}
	
	/**
	 * Called when the command ends.
	 * @param interrupted Flag indicating if the command was interrupted
	 */
	@Override
	public void end(boolean interrupted) {
		// Stop drivetrain for safety
		drivetrain.stop();
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 */
	@Override
	public boolean isFinished() {
		return false;
	}

}