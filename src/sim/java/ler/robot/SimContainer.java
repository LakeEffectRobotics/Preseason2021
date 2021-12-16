package ler.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.simulation.BatterySim;
import edu.wpi.first.wpilibj.simulation.RoboRioSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import ler.robot.subsystems.DrivetrainSim;

/**
 * Container for components used in simulation.
 * This class should only be used in simulation-specific areas, as it will not
 *  be initialized during real robot operation.
 */
public class SimContainer extends RobotContainer implements Sendable {

    public Field2d field = new Field2d();

    ArrayList<Simulateable> sims = new ArrayList<>();

    public double battVoltage = 0;
    public double battCurrent = 0;

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

        // Convert drivetrain to simulation wrapper
        sims.add(new DrivetrainSim(drivetrain));

        // Re-initialise mappings to updated subsystems
        initMappings();

        // Setup dashboard
        SmartDashboard.putData("Field", field);
        SmartDashboard.putData("Sim Control", this);
        for(Simulateable s : sims){
            SendableRegistry.addLW(s, s.getClass().getSimpleName(), s.getClass().getSimpleName());
        }
    }

    /**
     * Function called periodically during simulation.
     */
    public void periodic(){
        // Do not run this code on a real robot. It may cause lag and will break things
        if(Robot.isReal()){
            throw new IllegalStateException("Cannot run simulation code on real hardware.");
        }

        battCurrent = 0;
        double[] currents = new double[sims.size()];

        for(int i=0; i<sims.size(); i++){
            // TODO: Calculate dt properly
            Simulateable s = sims.get(i);
            s.simPeriodic(this, 0.02);
            
            battCurrent += s.getCurrentDraw();
            currents[i] = s.getCurrentDraw();
        }


        battVoltage = BatterySim.calculateDefaultBatteryLoadedVoltage(currents);
        RoboRioSim.setVInVoltage(battVoltage);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("Voltage", ()->battVoltage, null);
        builder.addDoubleProperty("Current", ()->battCurrent, null);
    }
}
