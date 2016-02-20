package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftUpSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
	
	public LiftUpSubsystem() {
		liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
	}
	
	public void robotUp(){
		liftMotor.set(0.375);
		System.out.println("robotUp is called");
	}
	
	public void stopLiftUp(){
		liftMotor.set(0.0);
	}
	
	public void robotDown(){
		liftMotor.set(-0.25);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

