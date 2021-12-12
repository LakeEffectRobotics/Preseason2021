package ler.robot.subsystems;



import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/**
 * Subsystem representing the shooter prototype.
 */
public class Gate extends SubsystemBase  {

	//TODO: Rename talons based on how they are used
	/**
	 * The first talon.
	 */
	TalonSRX gateMotor;


	DigitalInput botLimitSwitch;
	DigitalInput topLimitSwitch;




	// TODO: Update descriptions of talons based on how they are used
	/**
	 * Create a new Shooter.
	 * 
	 * @param gateMotor The first talon
	 * @param botLimitSwitch The bottom limit switch
	 * @param topLimitSwitch The top limit switch
	 */
	public Gate(TalonSRX gateMotor, DigitalInput topLimitSwitch, DigitalInput botLimitSwitch) {
		this.gateMotor = gateMotor;
		this.botLimitSwitch = botLimitSwitch;
		this.topLimitSwitch = topLimitSwitch;
		
		//TODO: Add hardware initialization
	}

	//All of our subsystem functions are here
	//This is the HOW we are going to do things
	public void setSpeed (double speed) {
		gateMotor.set(ControlMode.PercentOutput, speed);
	}

	public void openGate(double speed)
	{
		gateMotor.set(ControlMode.PercentOutput, Math.abs(speed));
	}

	public void closeGate(double speed)
	{
		// as a safeguard, take the abs of the speed coming in and negate it
		// It is totally possible that we have it backwards, in that case we will switch the
		// logic with liftGate
		gateMotor.set(ControlMode.PercentOutput, Math.abs(speed)*(-1));
	}

	// this is mostly for the interrupt function called by the scheduler
	public void stopGate()
	{
		gateMotor.set(ControlMode.PercentOutput, 0);
	}

	public GateState getGateState()
	{
		GateState currentState = GateState.BAD;
		boolean topLimitHit = topLimitSwitch.get();
		boolean bottomLimitHit = botLimitSwitch.get();

		if(topLimitHit==true)
		{
			if(bottomLimitHit==false){
				currentState = GateState.OPEN;
			} else
			{
				currentState = GateState.BAD;
			}

		}
		else //topLimitHit = false
		{
			if(bottomLimitHit==false){
				currentState = GateState.PARTIAL;
			} else
			{
				currentState = GateState.CLOSED;
			}
		}
		
		
		return(currentState);
	}
}