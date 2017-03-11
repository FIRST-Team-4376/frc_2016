
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
import edu.wpi.first.wpilibj.vision.VisionThread;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;
import org.usfirst.frc.team4376.robot.commands.ExampleCommand;
import org.usfirst.frc.team4376.robot.commands.FirstAuton;
import org.usfirst.frc.team4376.robot.commands.LineUpGearCommand;
import org.usfirst.frc.team4376.robot.subsystems.ChassisSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.PickUpSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.RampMotorSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.BallDoorSubsystem;
import org.usfirst.frc.team4376.robot.subsystems.VisionSubsystem;
import org.usfirst.frc.team4376.robot.vision.Pipeline;
import org.usfirst.frc.team4376.robot.vision.VisionProcessor;

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
	public boolean currentCamera = selectedCamera;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	VisionThread visionThread;
	private final Object imgLock = new Object();
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	public static double dCx;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		System.out.println("INIT");
		oi = new OI();
		chooser.addDefault("Default Auto", new FirstAuton());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);

		/**
		 * Instantiate a the camera server for both USB webcams in a separate
		 * thread
		 **/
		// Thread cameraThread = new Thread(() -> {
		// // 640, 480
		// // 320, 240
		// // 160, 120
		//
		//
		// UsbCamera camera1 =
		// CameraServer.getInstance().startAutomaticCapture(0);
		// camera1.setResolution(320, 240);
		// camera1.setFPS(20);
		//
		// UsbCamera camera2 =
		// CameraServer.getInstance().startAutomaticCapture(1);
		// camera2.setResolution(320, 240);
		// camera2.setFPS(20);
		//
		// CvSink cvSink = CameraServer.getInstance().getVideo(camera1);
		// CvSource outputStream = CameraServer.getInstance().putVideo("Video",
		// 320, 240);
		// Mat source = new Mat();
		//
		// boolean currentCamera = selectedCamera;
		// while( !Thread.interrupted() ) {
		// // We support two cameras, so the selectedCamera is a boolean to
		// toggle
		// // between camera1 and camera2
		// if ( currentCamera != selectedCamera ) {
		// currentCamera = selectedCamera;
		// if ( selectedCamera == false ) {
		// // Set the source to camera1
		// cvSink.setSource(camera1);
		// SmartDashboard.putString("Camera", "Camera 1");
		// } else {
		// // Set the source to camera2
		// cvSink.setSource(camera2);
		// SmartDashboard.putString("Camera", "Camera 2");
		// }
		// }
		//
		// //Grab image from the source camera
		// cvSink.grabFrame(source);
		//
		//// pipeline.process(source);
		//// outputStream.putFrame(pipeline.hsvThresholdOutput());
		//
		// // if there was an image collected, then send it to the dashboard via
		// // the output stream
		// if ( source.empty() == false ) {
		// source = visionProcessor.drawContoursOnImage(source);
		// outputStream.putFrame(source);
		// }
		// }
		// });
		//
		// cameraThread.start();

		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
		camera1.setResolution(IMG_WIDTH, IMG_HEIGHT);
		camera1.setFPS(20);

		UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
		camera2.setResolution(IMG_WIDTH, IMG_HEIGHT);
		camera2.setFPS(20);

		// UsbCamera camera =
		// CameraServer.getInstance().startAutomaticCapture();
		// camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
		// camera.setExposureManual(100);
		CvSink cvSink = CameraServer.getInstance().getVideo();
		CvSource blobStream = CameraServer.getInstance().putVideo("blobPoints", 640, 480);
		CvSource thresholdStream = CameraServer.getInstance().putVideo("Threshold", 640, 480);
		final int IMG_CENTER = IMG_WIDTH / 2;
		final Object imgLock = new Object();

		visionThread = new VisionThread(camera1, new Pipeline(), pipeline -> {
			Mat blobPoints = new Mat();
			Mat thresholdImg = new Mat();
			synchronized (imgLock) {

				if (currentCamera != selectedCamera) {
					System.out.println("currentCamera" + currentCamera);
					System.out.println("selectedCamera" + selectedCamera);
					currentCamera = selectedCamera;
					if (selectedCamera == false) {
						// Set the source to camera1
						camera2.setFPS(1);
						camera2.setResolution(3, 3);
						camera1.setFPS(20);
						camera1.setResolution(IMG_WIDTH, IMG_HEIGHT);
						cvSink.setSource(camera1);
						SmartDashboard.putString("Camera", "Camera 1");

						return;
					} else {
						// Set the source to camera2
						camera1.setFPS(1);
						camera1.setResolution(3, 3);
						camera2.setFPS(20);
						camera2.setResolution(IMG_WIDTH, IMG_HEIGHT);
						cvSink.setSource(camera2);
						SmartDashboard.putString("Camera", "Camera 2");
						return;
					}
				}

				// System.out.println("Blobs: " + blobs.size());

				cvSink.grabFrame(blobPoints);

				if (cvSink.getSource().getName().equals("USB Camera 0")) {

					List<MatOfPoint> contoursList = pipeline.getContoursList();

					if (contoursList.size() > 1) {
						Imgproc.drawContours(blobPoints, contoursList, -1, new Scalar(0, 255, 0), 4);
						// Draw marker at center of each contour
//						for (MatOfPoint contour : contoursList) {
//							Moments moments = Imgproc.moments(contour);
//							Point centroid = new Point();
//
//							centroid.x = moments.get_m10() / moments.get_m00();
//							centroid.y = moments.get_m01() / moments.get_m00();
//
//							Imgproc.drawMarker(blobPoints, centroid, new Scalar(0, 0, 255));
//						}

						// Sort contours by area (largest first)
						Collections.sort(contoursList, new Comparator<MatOfPoint>() {
							@Override
							public int compare(MatOfPoint arg0, MatOfPoint arg1) {
								// TODO Auto-generated method stub
								double arg0Area = Imgproc.contourArea(arg0);
								double arg1Area = Imgproc.contourArea(arg1);
								return (arg0Area > arg1Area) ? -1 : (arg0Area < arg1Area) ? 1 : 0;
							}
						});
					}

					// List<KeyPoint> blobs =
					// pipeline.findBlobsOutput().toList();
					// for (KeyPoint blob : blobs) {
					// Imgproc.drawMarker(blobPoints, blob.pt, new Scalar(255,
					// 0, 0));
					// }
					// thresholdImg = pipeline.hsvThresholdOutput();
					// thresholdStream.putFrame(thresholdImg);
					// if (blobs.size() > 1) {
					// Collections.sort(blobs, new Comparator<KeyPoint>() {
					// @Override
					// public int compare(KeyPoint arg0, KeyPoint arg1) {
					// // TODO Auto-generated method stub
					// return (arg0.size > arg1.size) ? -1 : (arg0.size <
					// arg1.size) ? 1 : 0;
					// }
					// });
					// dCx = ((blobs.get(0).pt.x + blobs.get(1).pt.x) / 2) -
					// IMG_CENTER;
					// // System.out.println(dCx);
					// }
				}
				blobStream.putFrame(blobPoints);
			}
		});
		visionThread.start();
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
}
