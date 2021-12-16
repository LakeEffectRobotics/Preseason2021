package ler.robot.subsystems;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import ler.robot.SimContainer;
import ler.robot.Simulateable;

/**
 * Simulation wrapper for the robot's drivetrain.
 */
public class DrivetrainSim extends Drivetrain implements Simulateable {


    DifferentialDrivetrainSim sim;

    /**
     * Create a new DrivetrainSim from an existing Drivetrain.
     * @param d Drivetrain to build from;
     */
    public DrivetrainSim(Drivetrain d){
        super(d.leftLead, d.rightLead);
        setDefaultCommand(d.getDefaultCommand());

        // Initialise physics simulation
        sim = DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kDualCIMPerSide, 
            KitbotGearing.k10p71, //TODO: Use real 
            KitbotWheelSize.SixInch,
            null);
    }

    @Override
    public void simPeriodic(SimContainer sc, double dt) {
        sim.setInputs(-leftLead.getMotorOutputPercent()*12, -rightLead.getMotorOutputPercent()*12);
		sim.update(dt);

		sc.field.setRobotPose(sim.getPose());
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("Subsystem");

        builder.addBooleanProperty(".hasDefault", () -> getDefaultCommand() != null, null);
        builder.addStringProperty(
            ".default",
            () -> getDefaultCommand() != null ? getDefaultCommand().getName() : "none",
            null);
        builder.addBooleanProperty(".hasCommand", () -> getCurrentCommand() != null, null);
        builder.addStringProperty(
            ".command",
            () -> {
                System.out.println(getCurrentCommand());
                return getCurrentCommand() != null ? getCurrentCommand().getName() : "none";
            },
            null);
    }
    
}
