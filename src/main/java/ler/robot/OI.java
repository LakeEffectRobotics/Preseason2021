package ler.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import ler.robot.commands.CloseGateCommand;

/**
 * Class containing drive team input devices.
 */
public class OI {
    /**
     * Controller bindings.
     */
    private static class Bindings {

        static final int CONTROLLER_PORT = 2;
        static final int DRIVER_CONTROLLER_PORT = 3;

        // Driver Bindings (Left stick)
        static final Button HALF_SPEED_BUTTON = Button.kA;
        
        // Driver Bindings (Right stick)

        // Operator Bindings
        static final Button PRINT_BUTTON = Button.kA;
        static final Button OPEN_GATE_BUTTON = Button.kBumperLeft;
        static final Button CLOSE_GATE_BUTTON = Button.kBumperRight;
    }

    /* 
     * Button names break conventions for constants, so disable check for now
     * CHECKSTYLE OFF: ConstantNameCheck 
     */

    /** Xbox controller for operator controls. Mapped to {@link Bindings#CONTROLLER_PORT}*/
    private static final XboxController controller = new XboxController(Bindings.CONTROLLER_PORT);
    
    private static final XboxController driverController = new XboxController(Bindings.DRIVER_CONTROLLER_PORT);


    /** Drive controller's left stick value. */
    public static final DoubleSupplier leftStickY = () -> driverController.getY(Hand.kLeft);
    /** Drive controller's right stick value. */
    public static final DoubleSupplier rightStickY = () -> driverController.getY(Hand.kRight);

    /** Button to drive at half speed. Mapped to {@link Bindings#HALF_SPEED_BUTTON} */
    public static final JoystickButton halfSpeedButton = new JoystickButton(driverController, Bindings.HALF_SPEED_BUTTON.value);

    /** Button to print a message (for demo purposes). Mapped to {@link Bindings#PRINT_BUTTON} */
    public static final JoystickButton printButton = new JoystickButton(controller, Bindings.PRINT_BUTTON.value);
    /** Button to run the {@link CloseGateCommand}. Mapped to {@link Bindings#OPEN_GATE_BUTTON} */
    public static final JoystickButton openGateButton = new JoystickButton(controller, Bindings.OPEN_GATE_BUTTON.value);
    /** Button to run the {@link CloseGateCommand}. Mapped to {@link Bindings#CLOSE_GATE_BUTTON} */
    public static final JoystickButton closeGateButton = new JoystickButton(controller, Bindings.CLOSE_GATE_BUTTON.value);



}
