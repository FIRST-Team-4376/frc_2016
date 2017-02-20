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
    	double overallCenterX = SmartDashboard.getDouble("overallCenterX", -1.0);
    	double imageWidth = SmartDashboard.getDouble("imageWidth", -1.0);
    	System.out.println("Overall Center X:" + SmartDashboard.getDouble("overallCenterX", -1));
    	System.out.println("Overall Center Y:" + SmartDashboard.getDouble("overallCenterY", -1));
    	System.out.println("Image Width:" + SmartDashboard.getDouble("imageWidth", -1));
    	System.out.println("Image Height:" + SmartDashboard.getDouble("imageHeight", -1));
    	
    	if (overallCenterX != -1.0 && imageWidth != 1.0 ){
    		double imageCenter = imageWidth / 2.0;
    		
    		if (overallCenterX < imageCenter){
    			Robot.chassis.driveMe(-0.5, 0.0, 0.0);
    		} else if (overallCenterX > imageCenter){
    			Robot.chassis.driveMe(0.5, 0.0, 0.0);
    		}
    	}
    	
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

