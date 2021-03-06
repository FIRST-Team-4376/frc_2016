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
    	
    	System.out.print("getAngle " + Robot.gyro.getAngle());
    	System.out.print("getAngleZ " + Robot.gyro.getAngleZ());
    	
    	if (overallCenterX != -1.0 &&
    			overallCenterX > 0.0 &&
    			imageWidth != -1.0 &&
    			overallCenterX != Robot.lastOverallX &&
    			imageWidth > 0.0){
    		double imageCenter = imageWidth / 2.0;
    		imageCenter = imageCenter - 70.0;
    		
    		double pct_diff_from_center = (Math.abs(imageCenter - overallCenterX) / imageWidth);
    		System.out.println("pct diff: " + pct_diff_from_center);
    		
    		
    		//Robot.chassis.driveMe(0.0, .20, 0.0);
    		
    		double movement_based_on_pct_diff = (int)Math.round((1+pct_diff_from_center) * 5000);
    		System.out.println("movement_based_on_pct_diff: " + movement_based_on_pct_diff);
    		if (overallCenterX < imageCenter){
    			Robot.lastOverallX = overallCenterX;
    			System.out.println("IF 1");
    			for(int i = 0; i < movement_based_on_pct_diff; i++){
    				Robot.chassis.driveMe(-0.35, 0.0, 0.0);
    			}
    		} else if (overallCenterX > imageCenter){
    			Robot.lastOverallX = overallCenterX;
    			System.out.println("IF 2");
    			for(int i = 0; i < movement_based_on_pct_diff; i++){
    				Robot.chassis.driveMe(0.35, 0.0, 0.0);
    			}
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

