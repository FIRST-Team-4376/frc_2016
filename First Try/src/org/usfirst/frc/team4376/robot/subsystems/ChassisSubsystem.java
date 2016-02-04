
package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ChassisSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private RobotDrive chassis;
	
	public ChassisSubsystem() {
		chassis = new RobotDrive(RobotMap.LEFT_DRIVE_MOTOR, RobotMap.RIGHT_DRIVE_MOTOR);
	}
	
	public void driveMe(double left, double right) {
		chassis.tankDrive(left, right);
	}
	
	public void stopMe() {
		chassis.stopMotor();
	}
	
	public void driveForward(double power){
		chassis.tankDrive(power, power);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
}

