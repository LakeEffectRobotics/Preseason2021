package ler.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import ler.robot.commands.ShootCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Subsystem representing the shooter prototype.
 */
public class Shooter extends SubsystemBase  {

	//TODO: Rename talons based on how they are used
	/**
	 * The first talon.
	 */
	TalonSRX feedLead;
	/**
	 * The second talon.
	 */
	TalonSRX shootLead;


	// TODO: Update descriptions of talons based on how they are used
	/**
	 * Create a new Shooter.
	 * 
	 * @param feedLead The talon used to feed balls into the shooter
	 * @param shootLead Used to shoot the ball
	 */
	public Shooter(TalonSRX feedLead, TalonSRX shootLead) {
		this.feedLead = feedLead;
		this.shootLead = shootLead;
		
		//TODO: Add hardware initialization
	}

	//TODO: Add your subsystem functions here

	public Shooter(TalonSRX feedLead, TalonSRX shootLead, Command defaultCommand) {
		this(feedLead, shootLead);

		setDefaultCommand(defaultCommand);
	}

	public void setFeedSpeed(double feedSpeed) {
		feedLead.set(ControlMode.PercentOutput, feedSpeed);
	}

	public void setShoot(double shootSpeed) {
		shootLead.set(ControlMode.PercentOutput, shootSpeed);
	}

	public void allStop() {
		feedLead.set(ControlMode.PercentOutput, 0);
		shootLead.set(ControlMode.PercentOutput, 0);
	}

}