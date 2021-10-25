package ler.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Map of hardware on robot.
 */
public class RobotMap {
    /**
     * Inner class to hold CAN ID constants.
     */
    private class CAN {
        /** CAN ID of left spark 1. */
        private static final int LEFT_TALON_1 = 2;
        /** CAN ID of left spark 2. */
        private static final int LEFT_TALON_2 = 3;
        
        /** CAN ID of right spark 1. */
        private static final int RIGHT_TALON_1 = 5;
        /** CAN ID of right spark 2. */
        private static final int RIGHT_TALON_2 = 6;
    }
    
    /* 
     * Hardware names break conventions for constants, so disable check for now
     * CHECKSTYLE OFF: ConstantNameCheck 
     */

    /** Primary SparkMax on left side. */
    public static final TalonSRX leftTalon1 = new TalonSRX(CAN.LEFT_TALON_1);
    /** SparkMax on left side, following {@link #leftTalon1}. */
    public static final TalonSRX leftTalon2 = new TalonSRX(CAN.LEFT_TALON_2);
    
    /** Primary SparkMax on right side. */
    public static final TalonSRX rightTalon1 = new TalonSRX(CAN.RIGHT_TALON_1);
    /** SparkMax on right side, following {@link #rightTalon1}. */
    public static final TalonSRX rightTalon2 = new TalonSRX(CAN.RIGHT_TALON_2);

    /**
     * Initialise robot hardware. <br/>
     * This must be called before creating subsystems.
     */
    public static void init(){
        // Configure drive motor following
        leftTalon2.follow(leftTalon1);
        
        rightTalon2.follow(rightTalon1);
    }
}
