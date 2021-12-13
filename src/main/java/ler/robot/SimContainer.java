package ler.robot;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Container for components used in simulation.
 */
public class SimContainer {

    public static RobotContainer rc;

    public static Field2d field;
    public static DifferentialDrivetrainSim driveSim;

    /**
     * Create a new SimContainer, should only be called in simulation conditions.
     * @param rc RobotContainer with subsystems to simulate
     */
    public static void init(RobotContainer r){
        // Do not run this code on a real robot. It may cause lag and will break things
        if(Robot.isReal()) return;

        rc = r;
        System.out.println("Initializing simulation container");

        // Initialize sim outputs
        driveSim = DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kDualCIMPerSide, 
            KitbotGearing.k10p71, //TODO: Use real 
            KitbotWheelSize.SixInch,
            null);
        field = new Field2d();
        SmartDashboard.putData("Field", field);
    }
}
