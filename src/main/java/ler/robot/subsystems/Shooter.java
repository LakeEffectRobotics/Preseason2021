package ler.robot.subsystems;

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
	TalonSRX feederTalon;
	/**
	 * The second talon.
	 */
	TalonSRX shooterTalon;


	// TODO: Update descriptions of talons based on how they are used
	/**
	 * Create a new Shooter.
	 * 
	 * @param feederTalon Talon that controls feeder wheel
	 * @param shooterTalon Talon that controls shooter wheel
	 */
	public Shooter(TalonSRX feederTalon, TalonSRX shooterTalon) {
		this.feederTalon = feederTalon;
		this.shooterTalon = shooterTalon;
		
		//TODO: Add hardware initialization
	}

	//TODO: Add your subsystem functions here
	public void setShooterTalon(double speed){
		shooterTalon.set(ControlMode.PercentOutput, speed);

	}

	public void setFeederTalon(double speed){
		feederTalon.set(ControlMode.PercentOutput, speed);

	}

	public void stop(){
		feederTalon.set(ControlMode.PercentOutput, 0);
		shooterTalon.set(ControlMode.PercentOutput, 0);
	}

}