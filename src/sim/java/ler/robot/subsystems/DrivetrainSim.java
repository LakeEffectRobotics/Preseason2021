package ler.robot.subsystems;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import ler.robot.SimContainer;
import ler.robot.SubsystemSim;

/**
 * Simulation wrapper for the robot's drivetrain.
 */
public class DrivetrainSim extends SubsystemSim<Drivetrain> {


    DifferentialDrivetrainSim sim;

    /**
     * Create a new DrivetrainSim from an existing Drivetrain.
     * @param d Drivetrain to build from;
     */
    public DrivetrainSim(Drivetrain d){
        super(d);

        // Initialise physics simulation
        sim = DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kDualCIMPerSide, 
            KitbotGearing.k10p71, //TODO: Use real 
            KitbotWheelSize.SixInch,
            null);
    }

    @Override
    public void simPeriodic(SimContainer sc, double dt) {
        system.leftLead.getSimCollection().setBusVoltage(sc.battVoltage);
        system.rightLead.getSimCollection().setBusVoltage(sc.battVoltage);

        sim.setInputs(-system.leftLead.getMotorOutputVoltage(), -system.rightLead.getMotorOutputVoltage());
		sim.update(dt);

		sc.field.setRobotPose(sim.getPose());
    }

    @Override
    public double getCurrentDraw() {
        return sim.getCurrentDrawAmps();
    }
    
}
