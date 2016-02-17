
package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class InvertSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int invertVal;
	
	public InvertSubsystem() {
		invertVal = 1;
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

