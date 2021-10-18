package ler.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * Class containing drive team input devices.
 */
public class OI {
    /** XBox controller on port 0. */
    private static final int CONTROLLER = 0;

    /** XBox controller used to drive the robot. */
    private final XboxController controller = new XboxController(CONTROLLER);


    /** Drive controller's left stick value. */
    public final DoubleSupplier leftStickY = () -> controller.getY(Hand.kLeft);
    /** Drive controller's right stick value. */
    public final DoubleSupplier rightStickY = () -> controller.getY(Hand.kRight);

    /** Drive controller's A button. */
    public final JoystickButton buttonA = new JoystickButton(controller, Button.kA.value);
    /** Drive controller's B button. */
    public final JoystickButton buttonB = new JoystickButton(controller, Button.kB.value);
    /** Drive controller's X button. */
    public final JoystickButton buttonX = new JoystickButton(controller, Button.kX.value);
    /** Drive controller's Y button. */
    public final JoystickButton buttonY = new JoystickButton(controller, Button.kY.value);

    /** Drive controller's left bumper. */
    public final JoystickButton leftBumper = new JoystickButton(controller, Button.kBumperLeft.value);
    /** Drive controller's right bumper. */
    public final JoystickButton rightBumper = new JoystickButton(controller, Button.kBumperRight.value);

    /**
     * Initialise controller mappings.
     */
    public OI(){
        // Map a command to A button
        buttonA.whenPressed(new PrintCommand("Button A pressed!"));
    }
}
