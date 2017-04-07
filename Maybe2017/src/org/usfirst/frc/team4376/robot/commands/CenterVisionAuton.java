package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CenterVisionAuton extends Command {

	private Timer timer;
	
	public int iteration = 1;
	
    public CenterVisionAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	
    	Robot.gyro.reset();
    	timer.reset();
    	timer.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (timer.get() > 0 && timer.get() < 13.0){
    		Robot.vision.checkForCameraUpdate();
//			if (Robot.vision.acquiredTarget()){ //doesnt work
//				Robot.vision.checkForCameraUpdate();
//			} else {
//				if(Robot.gyro.getAngleZ() < -1){
//					Robot.chassis.driveMe(0, -.10, .15);
//				}
//				else if (Robot.gyro.getAngleZ() > 1){
//					Robot.chassis.driveMe(0, -.10, -.15);
//				} else {
//					Robot.chassis.driveMe(0, -.15, 0);
//				}
//
//			}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.chassis.stopMe();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
