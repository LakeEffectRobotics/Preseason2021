package ler.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Map of hardware on robot.
 */
public class RobotMap {
    /** CAN ID of left spark 1. */
    private static final int LEFT_SPARK_1 = 2;
    /** CAN ID of left spark 2. */
    private static final int LEFT_SPARK_2 = 3;
    /** CAN ID of left spark 3. */
    private static final int LEFT_SPARK_3 = 4;
    
    /** CAN ID of right spark 1. */
    private static final int RIGHT_SPARK_1 = 5;
    /** CAN ID of right spark 2. */
    private static final int RIGHT_SPARK_2 = 6;
    /** CAN ID of right spark 3. */
    private static final int RIGHT_SPARK_3 = 7;
        
    /** Primary SparkMax on left side. */
    public final CANSparkMax leftSpark1 = new CANSparkMax(LEFT_SPARK_1, MotorType.kBrushless);
    /** SparkMax on left side, following {@link #leftSpark1}. */
    public final CANSparkMax leftSpark2 = new CANSparkMax(LEFT_SPARK_2, MotorType.kBrushless);
    /** SparkMax on left side, following {@link #leftSpark1}. */
    public final CANSparkMax leftSpark3 = new CANSparkMax(LEFT_SPARK_3, MotorType.kBrushless);
    
    /** Primary SparkMax on right side. */
    public final CANSparkMax rightSpark1 = new CANSparkMax(RIGHT_SPARK_1, MotorType.kBrushless);
    /** SparkMax on right side, following {@link #rightSpark1}. */
    public final CANSparkMax rightSpark2 = new CANSparkMax(RIGHT_SPARK_2, MotorType.kBrushless);
    /** SparkMax on right side, following {@link #rightSpark1}. */
    public final CANSparkMax rightSpark3 = new CANSparkMax(RIGHT_SPARK_3, MotorType.kBrushless);

    /**
     * Initialise robot hardware
    . */
    public RobotMap(){
        // Configure drive motor following
        leftSpark2.follow(leftSpark1);
        leftSpark3.follow(leftSpark1);

        rightSpark2.follow(rightSpark1);
        rightSpark3.follow(rightSpark1);
    }
}
