
package org.usfirst.frc.team4376.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.usfirst.frc.team4376.robot.commands.CrossWhiteLineAuton;
import org.usfirst.frc.team4376.robot.commands.ExampleCommand;
import org.usfirst.frc.team4376.robot.commands.FirstAuton;
import org.usfirst.frc.team4376.robot.commands.LeftSideAuton;
import org.usfirst.frc.team4376.robot.commands.LineUpGearCommand;
import org.usfirst.frc.team4376.robot.commands.RightSideAuton;
import org.usfirst.frc.team4376.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.PickUpSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.RampMotorSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.BallDoorSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.VisionSubsystem;
import org.usfirst.frc.team4376.sensorlib.ADIS16448_IMU;

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
	public static final VisionSubsystem vision = new VisionSubsystem();

	public static OI oi;
	
	public static boolean selectedCamera = false;
	public static double lastOverallX = -1.0;
	
	public static ADIS16448_IMU gyro;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		System.out.println("INIT");
		oi = new OI();
		chooser.addDefault("Middle spot (straight ahead to gear)", new FirstAuton());
		chooser.addObject("Cross White Line", new CrossWhiteLineAuton());
		chooser.addObject("Left starting spot", new LeftSideAuton());
		chooser.addObject("Right starting spot", new RightSideAuton());
		
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		gyro = new ADIS16448_IMU();
		gyro.reset();
		gyro.calibrate();

        /** Instantiate a the camera server for both USB webcams in a separate thread **/
        Thread cameraThread = new Thread(() -> {        	
            // 640, 480
            // 320, 240
            // 160, 120
      
        	
            UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);            
            camera1.setResolution(320, 240);
            camera1.setFPS(20);
            
            UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
            camera2.setResolution(320, 240);
            camera2.setFPS(20);
            
            CvSink cvSink = CameraServer.getInstance().getVideo(camera1);
            CvSource outputStream = CameraServer.getInstance().putVideo("Video", 320, 240);
            Mat source = new Mat();     

            boolean currentCamera = selectedCamera;
            while( !Thread.interrupted() ) {
            	// We support two cameras, so the selectedCamera is a boolean to toggle
            	// between camera1 and camera2
            	if ( currentCamera != selectedCamera ) {
            		currentCamera = selectedCamera;
	            	if ( selectedCamera == false ) {
	            		// Set the source to camera1
	            		cvSink.setSource(camera1);            		
	                	SmartDashboard.putString("Camera", "Camera 1");
	            	} else {
	            		// Set the source to camera2
	            		cvSink.setSource(camera2);
	                	SmartDashboard.putString("Camera", "Camera 2");
	            	}
            	}
 
            	//Grab image from the source camera
            	cvSink.grabFrame(source);
            	
            	// if there was an image collected, then send it to the dashboard via
            	// the output stream
            	if ( source.empty() == false ) {
            		outputStream.putFrame(source);
            	}
            }
        });
        
        cameraThread.start();
		

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
	
	public void robotPeriodic(){
	}
}
