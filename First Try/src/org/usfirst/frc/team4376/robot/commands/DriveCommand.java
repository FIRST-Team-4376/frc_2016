
package org.usfirst.frc.team4376.robot.commands;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveCommand extends Command {
	
	Encoder liftAngleEncoder;
	CANTalon liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
	
    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
		liftAngleEncoder = new Encoder(RobotMap.LIFT_ANGLE_ENCODER_A, RobotMap.LIFT_ANGLE_ENCODER_B, true, Encoder.EncodingType.k1X);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	liftAngleEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.driveMe(Robot.oi.leftDriveStick.getRawAxis(1) * -.75, Robot.oi.rightDriveStick.getRawAxis(1) * -.75);
   
SmartDashboard.putNumber("Shooter Angle Encoder", liftMotor.getEncPosition());
		
		int count = liftAngleEncoder.get();
		int rawCount = liftAngleEncoder.getRaw();
		double distance = liftAngleEncoder.getDistance();
		double period = liftAngleEncoder.getPeriod();
		double rate = liftAngleEncoder.getRate();
		boolean direction = liftAngleEncoder.getDirection();
		boolean stopped = liftAngleEncoder.getStopped();
		
		
		
		SmartDashboard.putNumber("count", count);
		SmartDashboard.putNumber("rawCount", rawCount);
		SmartDashboard.putNumber("distance", distance);
		SmartDashboard.putNumber("period", period);
		SmartDashboard.putNumber("rate", rate);
		SmartDashboard.putBoolean("direction", direction);
		SmartDashboard.putBoolean("stopped", stopped);
    
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
    }
}
