package ler.robot.commands;
// package frc.robot.commands;

// import org.junit.Before;
// import org.junit.After;
// import org.junit.Test;
// import frc.robot.subsystems.Drivetrain;
// import ca.gregk.frcmocks.scheduler.MockHardwareExtension;
// import ca.gregk.frcmocks.scheduler.TestWithScheduler;
// import ca.gregk.frcmocks.rev.MockCANSparkMax;

// /**
//  * Test class for DriveCommand.
//  */
// public class DriveCommandTest  {

// 	private MockCANSparkMax leftLead;
// 	private MockCANSparkMax rightLead;
// 	private Drivetrain drivetrain;
// 	private DriveCommand driveCommand;


// 	/**
// 	 * Setup scheduler and subsystems before each test.
// 	 */
// 	@Before
// 	public void setup() {
// 		// Create mocks for subsytems hardware
// 		leftLead = new MockCANSparkMax();
// 		rightLead = new MockCANSparkMax();
// 		// Create subsytem instance
// 		drivetrain = new Drivetrain(leftLead.getMock(), rightLead.getMock());
		
// 		// Create command instance
// 		driveCommand = new DriveCommand(drivetrain, () -> 0, () -> 0);
		
// 		// Setup scheduler system
// 		TestWithScheduler.schedulerStart();
// 		TestWithScheduler.schedulerClear();
// 		MockHardwareExtension.beforeAll();
// 	}

// 	/**
// 	 * Sample test method.
// 	 */
// 	@Test
// 	public void sampleTest() {
// 		// Arrange
		
// 		// Act
		
// 		// Assert
		
// 	}

// 	/**
// 	 * Release scheduler and HAL.
// 	 */
// 	@After
// 	public void after() {
// 		TestWithScheduler.schedulerDestroy();
// 		MockHardwareExtension.afterAll();
// 	}

// }