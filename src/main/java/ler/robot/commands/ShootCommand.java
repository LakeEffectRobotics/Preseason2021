package ler.robot.commands;



import edu.wpi.first.wpilibj.DigitalInput;
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

	/** Limit Switches */
	DigitalInput topLimitSwitch;
	DigitalInput botLimitSwitch;

	/**
	 * Create a new ler.robot.commands.
	 * 
	 * @param shooter The shooter prototype
	 * @param botLimitSwitch
	 * @param topLimitSwitch
	 */
	public ShootCommand(Shooter shooter, DigitalInput topLimitSwitch, DigitalInput botLimitSwitch) {
		addRequirements(shooter);
		
		this.shooter = shooter;
		this.topLimitSwitch = topLimitSwitch;
		this.botLimitSwitch = botLimitSwitch;
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
		//TODO: Initialize subsystems
		double speed = 0.5;
		if (topLimitSwitch.get()) {
			shooter.setSpeed(speed);
		} else if (botLimitSwitch.get()) {
			shooter.setSpeed(-speed);
		}
		
	}

	/**
	 * Called once every 20ms (nominally).
	 */
	@Override
	public void execute() {
		//TODO: Code that runs periodically while command is active

	}

	/**
	 * Called when the command ends.
	 * @param interrupted Flag indicating if the command was interrupted
	 */
	@Override
	public void end(boolean interrupted) {
		shooter.setSpeed(0);
		
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 */
	@Override
	public boolean isFinished() {
		if (topLimitSwitch.get()) {
			return true;
		} else if (botLimitSwitch.get()) {
			return true;
		} else {
			return false;
		}
	}

}