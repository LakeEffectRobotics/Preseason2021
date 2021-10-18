package ler.robot.subsystems;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import ca.gregk.frcmocks.rev.MockCANSparkMax;

/**
 * Test class for Drivetrain.
 */
public class DrivetrainTest  {

	/**
	 * Lead Spark Max on left side.
	 */
	private MockCANSparkMax leftLead;
	/**
	 * Lead Spark Max on right side.
	 */
	private MockCANSparkMax rightLead;
	private Drivetrain drivetrain;


	/**
	 * Setup hardware before each test.
	 */
	@Before
	public void setup() {
		// Create mocks for required hardware
		leftLead = new MockCANSparkMax();
		rightLead = new MockCANSparkMax();
		
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