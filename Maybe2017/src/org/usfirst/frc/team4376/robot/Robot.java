
package org.usfirst.frc.team4376.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4376.robot.commands.ExampleCommand;
import org.usfirst.frc.team4376.robot.commands.FirstAuton;
import org.usfirst.frc.team4376.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.PickUpSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.RampMotorSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.BallDoorSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final ChassisSubsystem chassis = new ChassisSubsystem();
	public static final LiftSubsystem lift = new LiftSubsystem();
	public static final RampMotorSubsystem ramp = new RampMotorSubsystem();
	public static final BallDoorSubsystem ballDoor = new BallDoorSubsystem();
	public static final PickUpSubsystem pickUp = new PickUpSubsystem();


	private final int camCenter;
	private final int camRight;
	private int curCam;
	private Image frame;
	private CameraServer server;

	public static OI oi;
	
	CameraServer camServer;
	UsbCamera lifecam;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new FirstAuton());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);

		// camServer = CameraServer.getInstance();
		// lifecam = new UsbCamera("cam0", 0);



		// Get camera ids by supplying camera name ex 'cam0', found on roborio web interface
		camLeft = NIVision.IMAQdxOpenCamera("cam0", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		camRight = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		curCam = camLeft;
		// Img that will contain camera img
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		// Server that we'll give the img to
		server = CameraServer.getInstance();
		server.setQuality(60);


	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		if(contr.getButton(Config.CameraFeeds.btCamCenter))
			changeCam(camCenter);

		if(contr.getButton(Config.CameraFeeds.btCamRight))
			changeCam(camRight);

		updateCam();

		// lifecam.setFPS(15);
  //       //lifecam.openCamera();
  //       camServer.startAutomaticCapture(lifecam);
	}

	public void changeCam(int newId)
	{
		NIVision.IMAQdxStopAcquisition(curCam);
		NIVision.IMAQdxConfigureGrab(newId);
		NIVision.IMAQdxStartAcquisition(newId);
		curCam = newId;
	}

	public void updateCam()
	{
		NIVision.IMAQdxGrab(curCam, frame, 1);
		server.setImage(frame);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
