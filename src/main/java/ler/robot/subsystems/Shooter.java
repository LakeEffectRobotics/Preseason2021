package ler.robot.subsystems;



import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
	TalonSRX talon1;
	/**
	 * The second talon.
	 */
	TalonSRX talon2;

	DigitalInput botLimitSwitch;
	DigitalInput topLimitSwitch;




	// TODO: Update descriptions of talons based on how they are used
	/**
	 * Create a new Shooter.
	 * 
	 * @param talon1 The first talon
	 * @param talon2 The second talon
	 * @param botLimitSwitch The bottom limit switch
	 * @param topLimitSwitch The top limit switch
	 */
	public Shooter(TalonSRX talon1, TalonSRX talon2, DigitalInput topLimitSwitch, DigitalInput botLimitSwitch) {
		this.talon1 = talon1;
		this.talon2 = talon2;
		this.botLimitSwitch = botLimitSwitch;
		this.topLimitSwitch = topLimitSwitch;
		
		//TODO: Add hardware initialization
	}

	//TODO: Add your subsystem functions here
	public void setSpeed (double speed) {
		talon1.set(ControlMode.PercentOutput, speed);
	}
}