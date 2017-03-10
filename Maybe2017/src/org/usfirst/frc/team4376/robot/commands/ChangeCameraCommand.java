package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeCameraCommand extends Command {

    public ChangeCameraCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end!!!!!!!!");
        if ( Robot.selectedCamera == true ){
            Robot.selectedCamera = false;
        } else {
            Robot.selectedCamera = true;
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
