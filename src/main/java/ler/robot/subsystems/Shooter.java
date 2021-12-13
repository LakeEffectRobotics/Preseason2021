package ler.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Subsystem representing the shooter prototype.
 */
public class Shooter extends SubsystemBase  {

	//TODO: Rename talons based on how they are used
	/**
	 * The first talon.
	 */
	WPI_TalonSRX talon1;
	/**
	 * The second talon.
	 */
	WPI_TalonSRX talon2;


	// TODO: Update descriptions of talons based on how they are used
	/**
	 * Create a new Shooter.
	 * 
	 * @param talon1 The first talon
	 * @param talon2 The second talon
	 */
	public Shooter(WPI_TalonSRX talon1, WPI_TalonSRX talon2) {
		this.talon1 = talon1;
		this.talon2 = talon2;
		
		//TODO: Add hardware initialization
	}

	//TODO: Add your subsystem functions here

}