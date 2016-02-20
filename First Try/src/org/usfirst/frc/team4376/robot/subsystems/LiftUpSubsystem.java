package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftUpSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
	//DoubleSolenoid shooterBrake;
	
	public LiftUpSubsystem() {
		liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
	}
	
	public void robotUp(){
		liftMotor.set(0.375);
		System.out.println("robotUp is called");
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stopLiftUp(){
		liftMotor.set(0.0);
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void robotDown(){
		liftMotor.set(-0.25);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

