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
    		Robot.lift.robotDown();
    	}
    	
        double i = 0.0;
        double left = i + .035;
        double right = i;
        while (timer.get() > 1.0 && timer.get() <= 2.0){


            Robot.chassis.driveMe(left, right);

            i = i + .01;
            left = i + .035;
            right = i;

            if(left > .535){
                left = .535;
            }
            if (right > .5){
                right = .5;
            }


        }

    	while(timer.get() > 2.0 && timer.get() <= 11.0){
    		Robot.chassis.driveMe(.535, .5);
    	}
    	
    	while(timer.get() > 11.0 && timer.get() <= 12.0){
    		Robot.chassis.driveMe(.75, .25);
    	}
    	
    	while(timer.get() > 11.5 && timer.get() <= 13.0){
    		Robot.chassis.driveMe(.535, .5);
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
    	end();
    }
}
