package ler.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Base class for subsystem simulation wrappers.
 */
public abstract class SubsystemSim<T extends SubsystemBase> implements Simulateable {
    public T system;
    
    /**
     * Create a new subsystem simulation wrapper.
     * @param system Subsystem to be wrapped
     */
    public SubsystemSim(T system){
        this.system = system;
    }

    @Override
    public final void initSendable(SendableBuilder builder){}

}
