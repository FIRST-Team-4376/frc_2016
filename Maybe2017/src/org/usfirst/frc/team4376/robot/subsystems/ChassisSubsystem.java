package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;
import org.usfirst.frc.team4376.robot.commands.LineUpGearCommand;



/**
 *
 */
public class ChassisSubsystem extends Subsystem {
	
	public double targetGyroHeading;
	
	public RobotDrive chassis;
	
	Joystick stick = new Joystick(RobotMap.driveStick);
	//public static MotorType kRearRight;
	//public static MotorType kFrontRight;
	
	public ChassisSubsystem(){
		
		chassis = new RobotDrive(RobotMap.frontLeftWheel, RobotMap.backLeftWheel, RobotMap.frontRightWheel, RobotMap.backRightWheel);
		//RobotDrive.setInvertedMotor(RobotMap.frontRightWheel, true);
		//RobotDrive.setInvertedMotor(RobotMap.backRightWheel, true);
		//RobotDrive.setInvertedMotor(kRearRight, true);
		//RobotDrive.setInvertedMotor(kFrontRight);
		
		//public void setLeftRightMotorOutputs(double stick. * -1, double stick.getX());

	}
	
	public void driveMe(){		
		chassis.mecanumDrive_Cartesian(stick.getX() * .75, stick.getY() * .75, stick.getZ() * .75, 0);
		
	}
	
	public void driveMe(double x, double y, double rotation) {
		chassis.mecanumDrive_Cartesian(x, y, rotation, 0);
	}
	
	public void stopMe(){
		
		chassis.mecanumDrive_Cartesian(0, 0, 0, 0);
	}

	public void driveForward(){
		chassis.mecanumDrive_Cartesian(0, .4, 0, 0);
	}
	
	public void driveBackward(){
		chassis.mecanumDrive_Cartesian(0, -.4, 0, 0);
	}
	
	public void setTargetGyroHeading(double number){
		targetGyroHeading = number;
	}
	
	public void setTargetGyroHeading(){
		targetGyroHeading = Robot.gyro.getAngleZ();
	}
	
	public boolean gyroHeadingLeftOfTarget(){
		return Robot.gyro.getAngleZ() < targetGyroHeading - 1.0;
	}
	
	public boolean gyroHeadingRightOfTarget(){
		return Robot.gyro.getAngleZ() > targetGyroHeading + 1.0;
	}
	
	
	public void straightBotWithStickInput(){
		double zChange = 0.0;
		if (gyroHeadingLeftOfTarget()){
			zChange = .15;
		} else if (gyroHeadingRightOfTarget()){
			zChange = -.15;
		}
		
		
		Robot.chassis.driveMe(stick.getX() * .75, stick.getY() * .75, zChange);
	}
	
	public void straightBot(){
		double zChange = 0.0;
		if (gyroHeadingLeftOfTarget()){
			zChange = .10;
		} else if (gyroHeadingRightOfTarget()){ 
			zChange = -.10;
		}
		
		
		Robot.chassis.driveMe(0.0, -.25, zChange);
	}
		
		
		
		
//	public void straightBot(){
//		if(Robot.gyro.getAngleZ() <= 2 && Robot.gyro.getAngleZ() >= -2){
//			Robot.chassis.driveMe(0, -.25, 0);
//		} else if(Robot.gyro.getAngleZ() <= 30 && Robot.gyro.getAngleZ() > 2){
//			Robot.chassis.driveMe(0, -.25, -.25);
//		} else if(Robot.gyro.getAngleZ() < 58 && Robot.gyro.getAngleZ() > 30){
//			Robot.chassis.driveMe(0, -.25, .25);
//		} else if(Robot.gyro.getAngleZ() > 62){
//			Robot.chassis.driveMe(0, -.25, 0);
//		}
//		else if(Robot.gyro.getAngleZ() < -2 && Robot.gyro.getAngleZ() >= -30){
//			Robot.chassis.driveMe(0, -.25, .25);
//		} else if (Robot.gyro.getAngleZ() < -30 && Robot.gyro.getAngleZ() > -58){
//			Robot.chassis.driveMe(0, -.25, -.25);
//		} else if (Robot.gyro.getAngleZ() < -62){
//			Robot.chassis.driveMe(0, -.25, .25);
//		}
//		
//	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    	
    }
}

