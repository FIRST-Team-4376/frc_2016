package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TapeRetractCommand extends Command {

    public TapeRetractCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	System.out.println("tape retract is kinda close");
    	requires(Robot.tape);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("tape retract command is initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.tape.tapeRetract();
    	System.out.println("tape retract is executed");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
