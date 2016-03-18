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
    	
    	while(timer.get() <= 1.0){
    		Robot.launcher.pushBall();
    		Robot.lift.robotDown();
    	}
    	
    	while(timer.get() > 1.0 && timer.get() <= 8.0){
    		Robot.chassis.driveMe(.63595, .6325);
    	}
    	
    	while(timer.get() > 8.0 && timer.get() <= 9.0){
    		Robot.chassis.driveMe(.75, .28);
    	}
    	
    	while(timer.get() > 9.0 && timer.get() <= 10.5){
    		Robot.chassis.driveMe(.63595, .6325);
    		Robot.launcher.resetPusher();
    	}
    	
    	while(timer.get() > 10.5 && timer.get() <= 11.5){
    		Robot.launcher.pushBall();
    		Robot.launcher.launchBall();
    	}
//    	while(timer.get() > 11.0 && timer.get() <= 11.5){
//    		Robot.launcher.pushBall();
//    	}
    	
    	while(timer.get() > 11.5 && timer.get() <= 12.5){
    		Robot.launcher.stopLaunchBall();
    		Robot.launcher.resetPusher();
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
