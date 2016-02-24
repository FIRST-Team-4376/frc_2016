package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PortcullisUpCommand extends Command {

    public PortcullisUpCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	System.out.println("lift up is kinda close");
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("lift up command is initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.portcullisUp();
    	System.out.println("lift up is executed");
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
