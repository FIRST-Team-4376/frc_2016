package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class RampMotorSubsystem extends Subsystem {
	
	Victor rampMotor;
	Counter counter1;
	Counter counter2;
	DigitalInput limitSwitch1;
	DigitalInput limitSwitch2;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public RampMotorSubsystem() {
		
		DigitalInput limitSwitch1 = new DigitalInput(RobotMap.limitSwitch1);
		DigitalInput limitSwitch2 = new DigitalInput(RobotMap.limitSwitch2);

		rampMotor = new Victor(RobotMap.rampMotor);


	}
	
//	public boolean isTopSwitchSet(){
//		//return counter1.get() > 0;
//		
//	}
//	
//	public boolean isBottomSwitchSet(){
//		return counter2.get() > 0;
//	}
	
	public void rampUp(){
		
		if (limitSwitch1.get() == false){
			rampMotor.set(0);
		} else if (limitSwitch2.get() == true){
			rampMotor.set(.5);
		}
	}
	
	public void rampDown(){
		
		if (limitSwitch2.get() == false){
			rampMotor.set(0);
		} else if (limitSwitch2.get() == true){
			rampMotor.set(-.5);
		}
	}
	
	public void rampAtRest(){
		
		rampMotor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

