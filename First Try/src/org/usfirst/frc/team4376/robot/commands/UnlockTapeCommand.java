package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UnlockTapeCommand extends Command {

    public UnlockTapeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//System.out.println("ehhhhh");
    	requires(Robot.tape);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//System.out.println("let's see");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tape.unlockTape();
    	//System.out.println("might work");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
      //Robot.launcher.resetPusher();
    	
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
