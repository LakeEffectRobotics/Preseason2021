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
        sim.setInputs(-system.leftLead.getMotorOutputPercent()*12, -system.rightLead.getMotorOutputPercent()*12);
		sim.update(dt);

		sc.field.setRobotPose(sim.getPose());
    }
    
}
