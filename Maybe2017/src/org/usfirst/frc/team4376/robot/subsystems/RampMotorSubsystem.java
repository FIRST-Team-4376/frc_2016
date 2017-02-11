package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class RampMotorSubsystem extends Subsystem {
	
	Talon rampMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public RampMotorSubsystem() {
		
		rampMotor = new Talon(RobotMap.rampMotor);

	}
	
	public void rampUp(){
		
		rampMotor.set(.5);
	}
	
	public void rampDown(){
		
		rampMotor.set(-.5);
	}
	
	public void rampAtRest(){
		
		rampMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

