package org.usfirst.frc.team4376.robot.commands.autonomous;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {

	public Timer timer1;
	public Timer timer2;
	
    public AutoDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer1 = new Timer();
    	timer1.reset();
    	timer1.start();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	while(timer1.get() <= 0.1){
    	   	Robot.lift.autonomousDown();
    	 }
    	
    	while (timer1.get() <= 7.0 && timer1.get() > 1.0){
    		Robot.chassis.driveForward(0.6);
    	}
    	
    	while (timer1.get() > 7.0 && timer1.get() <= 8.0){
    		Robot.chassis.driveMe(.5, 0);
    	}

    	while (timer1.get() > 8.0 && timer1.get() <= 11.0){
    		Robot.chassis.driveForward(.7);
    		Robot.launcher.resetPusher();
    	}
    	
    	while (timer1.get() > 12.0){
    		Robot.launcher.launchBall();
    	}
    	
    	while (timer1.get() > 12.0){
    		Robot.launcher.pushBall();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stopMe();
    	Robot.lift.stopLiftUp();
    	Robot.launcher.stopLaunchBall();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
