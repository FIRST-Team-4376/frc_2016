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
    	double leftCenterY = SmartDashboard.getDouble("leftCenterY", -1.0);
    	double rightCenterY = SmartDashboard.getDouble("rightCenterY", -1.0);
    	double overallScoreLeft = SmartDashboard.getDouble("overallScoreLeft", -1.0);
    	double overallScoreRight = SmartDashboard.getDouble("overallScoreRight", -1.0);

    	double imageWidth = SmartDashboard.getDouble("imageWidth", -1.0);
    	System.out.println("Overall Center X:" + SmartDashboard.getDouble("overallCenterX", -1));
    	System.out.println("Overall Center Y:" + SmartDashboard.getDouble("overallCenterY", -1));
    	System.out.println("Image Width:" + SmartDashboard.getDouble("imageWidth", -1));
    	System.out.println("Image Height:" + SmartDashboard.getDouble("imageHeight", -1));
    	
    	if (overallCenterX != -1.0 &&
    			overallCenterX > 0.0 &&
    			imageWidth != -1.0 &&
    			imageWidth > 0.0){
    		double imageCenter = imageWidth / 2.0;
    		
    		if (overallCenterX < imageCenter){
    			System.out.println("IF 1");
    			Robot.chassis.driveMe(-0.25, 0.0, 0.0);
    		} else if (overallCenterX > imageCenter){
    			System.out.println("IF 2");
    			Robot.chassis.driveMe(0.25, 0.0, 0.0);
    		}
    		
    		if (leftCenterY < rightCenterY){
    			Robot.chassis.driveMe(0, 0, .25);
    		} else if (leftCenterY > rightCenterY){
    			Robot.chassis.driveMe(0, 0, -.25);
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

