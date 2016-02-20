package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.GlobalVariableHolder;
import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InvertCommand extends Command {
public GlobalVariableHolder varHolder;
    public InvertCommand(GlobalVariableHolder holder) {
    	varHolder = holder;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	varHolder.invertVal = -1;
    	//Robot.lift.robotUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	varHolder.invertVal = 1;
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