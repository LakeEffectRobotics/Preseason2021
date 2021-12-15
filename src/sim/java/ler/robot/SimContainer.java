package ler.robot;

import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Container for components used in simulation.
 * This class should only be used in simulation-specific areas, as it will not
 *  be initialized during real robot operation.
 */
public class SimContainer extends RobotContainer {

    public Field2d field;
    public static DifferentialDrivetrainSim driveSim;

    /**
     * Create a new SimContainer, should only be called in simulation conditions.
     */
    public SimContainer(){
        // Initialise the standard robot container
        super();

        // Do not run this code on a real robot. It may cause lag and will break things
        if(Robot.isReal()){
            throw new IllegalStateException("Cannot run simulation code on real hardware.");
        }

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

    /**
     * Function called periodically during simulation.
     */
    public void periodic(){
        // Do not run this code on a real robot. It may cause lag and will break things
        if(Robot.isReal()){
            throw new IllegalStateException("Cannot run simulation code on real hardware.");
        }

    }
}
