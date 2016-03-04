package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision;


/**
 *
 */
public class TapeMeasureSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor tapeMotor = new Victor(RobotMap.TAPE_MEASURE_MOTOR);
	CameraServer camServer;
	CameraServer camServer2;
	USBCamera lifecam;
	USBCamera lifecam2;
	
	int session;
	Image frame;
	//DoubleSolenoid shooterBrake;
	
	public TapeMeasureSubsystem() {
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
		// camServer = CameraServer.getInstance();
		// lifecam = new USBCamera("cam0");
		//camServer2 = CameraServer.getInstance();
		//lifecam2 = new USBCamera("cam1");
		
	}
	
	public void tapeExtend(){
		tapeMotor.set(0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void tapeStop(){
		tapeMotor.set(0.0);
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void tapeRetract(){
		tapeMotor.set(-0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}
	
	public void pitTapeRetract(){
		tapeMotor.set(-.25);
	}
	
	public void switchtoCamera1(){

	  // the camera name (ex "cam0") can be found through the roborio web interface
	  session = NIVision.IMAQdxOpenCamera("cam0",
	          NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	  NIVision.IMAQdxConfigureGrab(session);

	  NIVision.IMAQdxGrab(session, frame, 1);
	  CameraServer.getInstance().setImage(frame);


		//lifecam.closeCamera();
	    //lifecam2.closeCamera();
		// lifecam.closeCamera();
		// lifecam = new USBCamera("cam0");
	 //    lifecam.setFPS(30);
  //       lifecam.openCamera();
  //       camServer.startAutomaticCapture(lifecam);
    }
	
	public void switchtoCamera2(){
	  session = NIVision.IMAQdxOpenCamera("cam1",
	          NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	  NIVision.IMAQdxConfigureGrab(session);

	  NIVision.IMAQdxGrab(session, frame, 1);
	  CameraServer.getInstance().setImage(frame);


		//lifecam.closeCamera();
		//lifecam2.closeCamera();
		//lifecam2.setFPS(30);
        //lifecam2.openCamera();
	 //    lifecam.closeCamera();
		// lifecam.closeCamera();
		// lifecam = new USBCamera("cam1");
	 //    lifecam.setFPS(30);
  //       lifecam.openCamera();
  //       camServer2.startAutomaticCapture(lifecam);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

