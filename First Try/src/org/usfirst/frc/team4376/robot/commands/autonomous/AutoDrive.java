package org.usfirst.frc.team4376.robot.commands.autonomous;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

	private Timer timer;
	
    public AutoDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(timer.get() <= 1.0){
    		Robot.launcher.pushBall();
    		Robot.lift.robotDown();
    	}
    	
    	if(timer.get() > 1.0 && timer.get() <= 7.5){
    		Robot.chassis.driveMe(.63595, .6330);
    	}
    	
    	if(timer.get() > 7.5 && timer.get() <= 8.90){
    		Robot.chassis.driveMe(.75, .28);
    	}
    	
    	if(timer.get() > 8.9 && timer.get() <= 10.65){
    		Robot.chassis.driveMe(.63595, .6325);
    		Robot.launcher.resetPusher();
    	}
    	
    	if(timer.get() > 10.65 && timer.get() <= 11.65){
    		Robot.launcher.pushBall();
    		Robot.launcher.launchBall();
    	}
    	
    	if(timer.get() > 11.65 && timer.get() <= 11.95){
    		Robot.launcher.stopLaunchBall();
    		Robot.launcher.resetPusher();
    		Robot.lift.stopLiftUp();
    	}
    	
    	if(timer.get() > 11.95 && timer.get() <= 13.85){
    		Robot.chassis.driveMe(.699545, -.69575);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stopMe();
    	Robot.launcher.stopLaunchBall();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
