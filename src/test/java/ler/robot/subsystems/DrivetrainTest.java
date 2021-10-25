package ler.robot.subsystems;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import ca.gregk.frcmocks.ctre.MockTalonSRX;

/**
 * Test class for Drivetrain.
 */
public class DrivetrainTest  {

	/**
	 * Lead Spark Max on left side.
	 */
	private MockTalonSRX leftLead;
	/**
	 * Lead Spark Max on right side.
	 */
	private MockTalonSRX rightLead;
	private Drivetrain drivetrain;


	/**
	 * Setup hardware before each test.
	 */
	@Before
	public void setup() {
		// Create mocks for required hardware
		leftLead = new MockTalonSRX();
		rightLead = new MockTalonSRX();
		
		// Create subsytem instance
		drivetrain = new Drivetrain(leftLead.getMock(), rightLead.getMock());
	}

	/**
	 * Sample test method.
	 */
	@Test
	public void testSetOuput() {
		// Arrange
		
		// Act
		drivetrain.setOutput(0.5, 0.5);

		// Assert
		// assertEquals(leftLead.controlType, ControlType.kDutyCycle);
		// assertEquals(leftLead.setpoint, 0.5, 0);
		assertTrue(true);
	}

}