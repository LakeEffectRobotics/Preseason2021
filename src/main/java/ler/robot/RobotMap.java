package ler.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Map of hardware on robot.
 */
public class RobotMap {
    /**
     * Inner class to hold CAN ID constants.
     */
    private class CAN {
        /** CAN ID of left talon 1. */
        private static final int LEFT_TALON_1 = 2;
        /** CAN ID of left talon 2. */
        private static final int LEFT_TALON_2 = 3;
        
        /** CAN ID of right talon 1. */
        private static final int RIGHT_TALON_1 = 4;
        /** CAN ID of right talon 2. */
        private static final int RIGHT_TALON_2 = 5;

        /** CAN ID of shooter talon 1. */
        private static final int GATE_MOTOR_ID = 6;

    }
        // need to make sure this is plugged into the corresponding numbered
        // pin on the RoboRio
        private static final int TOP_LIMIT_SWITCH_ID = 0;
        private static final int BOTTOM_LIMIT_SWITCH_ID = 1; 
    /* 
     * Hardware names break conventions for constants, so disable check for now
     * CHECKSTYLE OFF: ConstantNameCheck 
     */

    /** Primary TalonSRX on left side. */
    public static final TalonSRX leftTalon1 = new TalonSRX(CAN.LEFT_TALON_1);
    /** TalonSRX on left side, following {@link #leftTalon1}. */
    public static final TalonSRX leftTalon2 = new TalonSRX(CAN.LEFT_TALON_2);
    
    /** Primary TalonSRX on right side. */
    public static final TalonSRX rightTalon1 = new TalonSRX(CAN.RIGHT_TALON_1);
    /** TalonSRX on right side, following {@link #rightTalon1}. */
    public static final TalonSRX rightTalon2 = new TalonSRX(CAN.RIGHT_TALON_2);

    /** First TalonSRX on the shooter prototype. */
    public static final TalonSRX gateMotor = new TalonSRX(CAN.GATE_MOTOR_ID);

    public static final DigitalInput topLimitSwitch = new DigitalInput(BOTTOM_LIMIT_SWITCH_ID);

    public static final DigitalInput botLimitSwitch = new DigitalInput(TOP_LIMIT_SWITCH_ID);
    

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
