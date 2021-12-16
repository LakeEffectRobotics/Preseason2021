package ler.robot;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * Interface for subsystem simulation wrappers.
 */
public interface Simulateable extends Sendable {
    /**
     * Function called periodically in simulation.
     * @param sc Parent SimContainer instance
     * @param dt DeltaTime for simulation computations
     */
    public void simPeriodic(SimContainer sc, double dt);

    /**
     * Get the current draw of the represented hardware.
     * This value is used in battery voltage calculations
     * By default, this will return 0 amps
     * @return Current draw in amps
     */
    default double getCurrentDraw(){
        return 0;
    }
    
    @Override
    default void initSendable(SendableBuilder builder) {}
}
