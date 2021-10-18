package ler.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * Map of hardware on robot
 */
public class RobotMap {
    /** CAN ID of left spark 1 */
    public static final int LEFT_SPARK_1 = 0;
    /** CAN ID of left spark 2 */
    public static final int LEFT_SPARK_2 = 0;
    /** CAN ID of left spark 3 */
    public static final int LEFT_SPARK_3 = 0;
    
    /** CAN ID of right spark 1 */
    public static final int RIGHT_SPARK_1 = 0;
    /** CAN ID of right spark 2 */
    public static final int RIGHT_SPARK_2 = 0;
    /** CAN ID of right spark 3 */
    public static final int RIGHT_SPARK_3 = 0;

    /** Primary SparkMax on left side */
    public static final CANSparkMax leftSpark1 = new CANSparkMax(LEFT_SPARK_1, MotorType.kBrushless);
    /** SparkMax on left side, following {@link #leftSpark1} */
    public static final CANSparkMax leftSpark2 = new CANSparkMax(LEFT_SPARK_2, MotorType.kBrushless);
    /** SparkMax on left side, following {@link #leftSpark1} */
    public static final CANSparkMax leftSpark3 = new CANSparkMax(LEFT_SPARK_3, MotorType.kBrushless);
    
    /** Primary SparkMax on right side */
    public static final CANSparkMax rightSpark1 = new CANSparkMax(RIGHT_SPARK_1, MotorType.kBrushless);
    /** SparkMax on right side, following {@link #rightSpark1} */
    public static final CANSparkMax rightSpark2 = new CANSparkMax(RIGHT_SPARK_2, MotorType.kBrushless);
    /** SparkMax on right side, following {@link #rightSpark1} */
    public static final CANSparkMax rightSpark3 = new CANSparkMax(RIGHT_SPARK_3, MotorType.kBrushless);

    /**
     * Initialise robot hardware
     */
    public static void init(){
        // Configure drive motor following
        leftSpark2.follow(leftSpark1);
        leftSpark3.follow(leftSpark1);

        rightSpark2.follow(rightSpark1);
        rightSpark3.follow(rightSpark1);
    }
}
