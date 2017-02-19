package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;
import org.usfirst.frc.team4376.robot.commands.LineUpGearCommand;



/**
 *
 */
public class ChassisSubsystem extends Subsystem {
	
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
		new LineUpGearCommand().execute();
		System.out.println("TEST");
		chassis.mecanumDrive_Cartesian(stick.getX() * .5, stick.getY() * .5, stick.getZ() * .5, 0);
		
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
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    	
    }
}

