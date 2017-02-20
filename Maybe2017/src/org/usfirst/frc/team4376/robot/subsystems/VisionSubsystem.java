package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class VisionSubsystem extends Subsystem {

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public VisionSubsystem() {
		
	}
	
	public void lineUpGear(){
    	System.out.println("test");
    	double overallCenterX = SmartDashboard.getDouble("overallCenterX", -1);
    	System.out.println("Overall Center X:" + overallCenterX);
    	// Robot.chassis.driveForward();
	}
	
	public void stopLineUpGear(){
		return;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

