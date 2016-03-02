package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;


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
	//DoubleSolenoid shooterBrake;
	
	public TapeMeasureSubsystem() {
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
		camServer = CameraServer.getInstance();
		lifecam = new USBCamera("cam0");
		camServer2 = CameraServer.getInstance();
		lifecam2 = new USBCamera("cam1");
		
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
		
		lifecam.setFPS(30);
        lifecam.openCamera();
        camServer.startAutomaticCapture(lifecam);
    }
	
	public void switchtoCamera2(){
		lifecam2.setFPS(30);
        lifecam2.openCamera();
        camServer.startAutomaticCapture(lifecam2);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

