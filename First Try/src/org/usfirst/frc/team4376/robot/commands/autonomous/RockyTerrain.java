package org.usfirst.frc.team4376.robot.commands.autonomous;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RockyTerrain extends Command {

	private Timer timer;
	
    public RockyTerrain() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	
    	timer.reset();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.driveForward(.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return(timer.get() >= 7.0);
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
