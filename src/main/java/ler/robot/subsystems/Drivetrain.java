package ler.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;

/**
 * Subsystem representing the robot's drivetrain.
 */
public class Drivetrain extends SubsystemBase  {

	/**
	 * Lead Spark Max on left side.
	 */
	CANSparkMax leftLead;
	/**
	 * Lead Spark Max on right side.
	 */
	CANSparkMax rightLead;


	/**
	 * Create a new Drivetrain.
	 * 
	 * @param leftLead Lead Spark Max on left side
	 * @param rightLead Lead Spark Max on right side
	 */
	public Drivetrain(CANSparkMax leftLead, CANSparkMax rightLead) {
		this.leftLead = leftLead;
		this.rightLead = rightLead;
	}

	/**
	 * Set the drivetrain output, using tank controls
	 * @param left left side output percent, [-1, 1]
	 * @param right right side output percet, [-1, 1]
	 */
	public void setOutput(double left, double right){
		leftLead.set(left);
		rightLead.set(right);
	}

	/**
	 * Stop the drivetrain
	 */
	public void stop(){
		leftLead.set(0);
		rightLead.set(0);
	}
}