// package ler.robot.commands;

// import org.junit.Before;
// import org.junit.After;
// import org.junit.Test;
// import ler.robot.subsystems.Drivetrain;
// import ca.gregk.frcmocks.scheduler.MockHardwareExtension;
// import ca.gregk.frcmocks.scheduler.TestWithScheduler;
// import ca.gregk.frcmocks.rev.MockCANSparkMax;

// /**
//  * Test class for DriveSlowCommand.
//  */
// public class DriveSlowCommandTest  {

// 	private MockCANSparkMax leftLead;
// 	private MockCANSparkMax rightLead;
// 	private Drivetrain drivetrain;
// 	private DriveSlowCommand driveSlowCommand;


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
// 		driveSlowCommand = new DriveSlowCommand(drivetrain, ()->0, ()->0, 1);
		
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