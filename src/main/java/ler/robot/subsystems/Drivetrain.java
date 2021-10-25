package ler.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Subsystem representing the robot's drivetrain.
 */
public class Drivetrain extends SubsystemBase  {

	/**
	 * Lead Spark Max on left side.
	 */
	TalonSRX leftLead;
	/**
	 * Lead Spark Max on right side.
	 */
	TalonSRX rightLead;


	/**
	 * Create a new Drivetrain.
	 * 
	 * @param leftLead Lead Spark Max on left side
	 * @param rightLead Lead Spark Max on right side
	 */
	public Drivetrain(TalonSRX leftLead, TalonSRX rightLead) {
		this.leftLead = leftLead;
		this.rightLead = rightLead;
	}

	/**
	 * Set the drivetrain output, using tank controls.
	 * @param left left side output percent, [-1, 1]
	 * @param right right side output percet, [-1, 1]
	 */
	public void setOutput(double left, double right){
		leftLead.set(ControlMode.PercentOutput, left);
		rightLead.set(ControlMode.PercentOutput, right);
	}

	/**
	 * Stop the drivetrain.
	 */
	public void stop(){
		leftLead.set(ControlMode.PercentOutput, 0);
		rightLead.set(ControlMode.PercentOutput, 0);
	}
}