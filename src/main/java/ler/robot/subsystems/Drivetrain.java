package ler.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import ler.robot.SimContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Subsystem representing the robot's drivetrain.
 */
public class Drivetrain extends SubsystemBase  {

	/**
	 * Lead TalonSRX on left side.
	 */
	WPI_TalonSRX leftLead;
	/**
	 * Lead TalonSRX on right side.
	 */
	WPI_TalonSRX rightLead;


	/**
	 * Create a new Drivetrain.
	 * 
	 * @param leftLead Lead TalonSRX on left side
	 * @param rightLead Lead TalonSRX on right side
	 */
	public Drivetrain(WPI_TalonSRX leftLead, WPI_TalonSRX rightLead) {
		this.leftLead = leftLead;
		this.rightLead = rightLead;
	}

	/**
	 * Create a new Drivetrain.
	 * 
	 * @param leftLead Lead TalonSRX on left side
	 * @param rightLead Lead TalonSRX on right side
	 * @param defaultCommand Default command
	 */
	public Drivetrain(WPI_TalonSRX leftLead, WPI_TalonSRX rightLead, Command defaultCommand){
		this(leftLead, rightLead);

		setDefaultCommand(defaultCommand);
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

	@Override
	public void simulationPeriodic(){
		// Invert values to account for differences between hardware and simulation
		SimContainer.driveSim.setInputs(-leftLead.getMotorOutputPercent()*12, -rightLead.getMotorOutputPercent()*12);
		SimContainer.driveSim.update(0.02);

		SimContainer.field.setRobotPose(SimContainer.driveSim.getPose());
	}
}