package ler.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.simulation.BatterySim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj.simulation.RoboRioSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.system.plant.DCMotor;

/**
 * Container for components used in simulation.
 */
public class SimContainer {

    /**
     * Simulation delta time, assuming 50hz operation.
     */
    public static final double DT = 0.02;

    public static RobotContainer rc;

    public static HashMap<String, Double> currentDraw;

    public static Field2d field;
    public static DifferentialDrivetrainSim driveSim;

    public static FlywheelSim shooterSim;

    private static final double FLYWHEEL_GEARING = 9;
    /**
     * Mass moment of inertia for the 6in smoothgrip flywheel (kg*m^2).
     */
    private static final double FLYWHEEL_MOI = 0.004604;

    /**
     * Create a new SimContainer, should only be called in simulation conditions.
     * @param r RobotContainer with subsystems to simulate
     */
    public static void init(RobotContainer r){
        // Do not run this code on a real robot. It may cause lag and will break things
        if(Robot.isReal()) return;

        rc = r;
        System.out.println("Initializing simulation container");

        // Initialize sim outputs
        currentDraw = new HashMap<>();

        driveSim = DifferentialDrivetrainSim.createKitbotSim(
            KitbotMotor.kDualCIMPerSide, 
            KitbotGearing.k10p71, //TODO: Use real 
            KitbotWheelSize.SixInch,
            null);
        field = new Field2d();
        SmartDashboard.putData("Field", field);

        shooterSim = new FlywheelSim(DCMotor.getVex775Pro(1), FLYWHEEL_GEARING, FLYWHEEL_MOI); 
    }

    /**
     * Gobal simulation updates, should be called in Robot.simulationPeriodic().
     */
    public static void periodic(){
        // Do not run this code on a real robot. It may cause lag and will break things
        if(Robot.isReal()) return;

        // Unpackage current draws to array
        double[] arr = new double[currentDraw.size()];
        int i=0;
        double currSum = 0;
        for(double d : currentDraw.values()){
            arr[i++] = d;
            currSum += d;
        }

        // Calculate battery voltage
        double voltage = BatterySim.calculateDefaultBatteryLoadedVoltage(arr);
        SmartDashboard.putNumber("Voltage", voltage);
        SmartDashboard.putNumber("Current", currSum);
        RoboRioSim.setVInVoltage(voltage);
    }
}
