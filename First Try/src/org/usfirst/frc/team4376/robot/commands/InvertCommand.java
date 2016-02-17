package org.usfirst.frc.team4376.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4376.robot.Robot;


/**
 *
 */
public class InvertCommand extends Command {
	
    public InvertCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.lift);
    	requires(Robot.invertSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.invertSub.invertVal = -1;
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Robot.invertSub.invertVal = 1;
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
