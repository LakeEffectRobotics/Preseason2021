package ler.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ler.robot.commands.ShootCommand;

/**
 * Class containing drive team input devices.
 */
public class OI {
    /**
     * Controller bindings.
     */
    private static class Bindings {
        static final int LEFT_STICK_PORT = 0;
        static final int RIGHT_STICK_PORT = 1;
        static final int CONTROLLER_PORT = 2;

        // Driver Bindings (Left stick)
        static final int HALF_SPEED_BUTTON = 3;
        
        // Driver Bindings (Right stick)

        // Operator Bindings
        static final Button PRINT_BUTTON = Button.kA;
        static final Button SHOOT_BUTTON = Button.kBumperLeft;
    }

    /* 
     * Button names break conventions for constants, so disable check for now
     * CHECKSTYLE OFF: ConstantNameCheck 
     */

    /** Joystick for left side of robot. Mapped to {@link Bindings#LEFT_STICK_PORT} */
    private static final Joystick leftStick = new Joystick(Bindings.LEFT_STICK_PORT);
    /** Joystick for right side of robot. Mapped to {@link Bindings#RIGHT_STICK_PORT} */
    private static final Joystick rightStick = new Joystick(Bindings.RIGHT_STICK_PORT);
    /** Xbox controller for operator controls. Mapped to {@link Bindings#CONTROLLER_PORT}*/
    private static final XboxController controller = new XboxController(Bindings.CONTROLLER_PORT);


    /** Drive controller's left stick value. */
    public static final DoubleSupplier leftStickY = () -> leftStick.getY();
    /** Drive controller's right stick value. */
    public static final DoubleSupplier rightStickY = () -> rightStick.getY();

    /** Operator Controller's left trigger value. */
    public static final DoubleSupplier leftOperatorTrigger = () -> controller.getTriggerAxis(Hand.kLeft);
    /** Operators Controller's right trigger value. */
    public static final DoubleSupplier rightOperatorTrigger = () -> controller.getTriggerAxis(Hand.kRight);

    /** Button to drive at half speed. Mapped to {@link Bindings#HALF_SPEED_BUTTON} */
    public static final JoystickButton halfSpeedButton = new JoystickButton(leftStick, Bindings.HALF_SPEED_BUTTON);

    /** Button to print a message (for demo purposes). Mapped to {@link Bindings#PRINT_BUTTON} */
    public static final JoystickButton printButton = new JoystickButton(controller, Bindings.PRINT_BUTTON.value);
    /** Button to run the {@link ShootCommand}. Mapped to {@link Bindings#SHOOT_BUTTON} */
    public static final JoystickButton shootButton = new JoystickButton(controller, Bindings.SHOOT_BUTTON.value);

}
