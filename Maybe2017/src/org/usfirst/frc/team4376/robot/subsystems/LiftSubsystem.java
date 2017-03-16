package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class LiftSubsystem extends Subsystem {
	
	Talon liftMotor;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public LiftSubsystem() {
		
		liftMotor = new Talon(RobotMap.liftMotor);
		
	}
	
	public void liftBot(){
		
		liftMotor.set(1);
	}
	
	public void lowerBot(){
		
		liftMotor.set(-1.0);
	}
	
	public void restBot(){
		
		liftMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

