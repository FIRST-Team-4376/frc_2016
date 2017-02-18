package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class PickUpSubsystem extends Subsystem {
	
	Talon pickUpMotor;
	
	public PickUpSubsystem(){
		
		pickUpMotor =  new Talon(RobotMap.pickUpMotor);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void pickUpBalls(){
	
		pickUpMotor.set(1);
	}
	
	public void stopBalls(){
		
		pickUpMotor.set(.0);
	}

	public void putDownBalls(){
		
		pickUpMotor.set(-1);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

