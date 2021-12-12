package ler.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import ler.robot.subsystems.Gate;
import ler.robot.subsystems.GateState;

/**
 * Command that runs the shooter.
 */
public class CloseGateCommand extends CommandBase  {

	/**
	 * The shooter prototype.
	 */
	Gate gate;

	/** Limit Switches */
	DigitalInput topLimitSwitch;
	DigitalInput botLimitSwitch;

	static double GATESPEED = 0.5;
	/**
	 * Create a new ler.robot.commands.
	 * 
	 * @param gate The shooter prototype
	 */
	public CloseGateCommand(Gate gate) {
		addRequirements(gate);
		
		this.gate = gate;
	}

	/**
	 * Called when the command is initially scheduled.<br/>.
	 * May be triggered by a button/command group or as a default command
	 */
	@Override
	public void initialize() {
	
		GateState  initialState =  gate.getGateState();

		// if the gate is open or partially open, close it when we start
		switch(initialState)
		{
			case OPEN: 
			case PARTIAL:
				gate.closeGate(GATESPEED);
				break;
			case CLOSED:
			case BAD:
				// do nothing
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
		gate.stopGate();
	}

	/**
	 * Called to check command status, command will end if this returns true.
	 * Once the gate hits the lower limit switch we have closed
	 */
	@Override
	public boolean isFinished() {


		GateState limitHit = gate.getGateState();
		boolean bFinished;
		if(limitHit == GateState.CLOSED)
			bFinished = true;
		else
			bFinished = false;

		return bFinished;
	}


}