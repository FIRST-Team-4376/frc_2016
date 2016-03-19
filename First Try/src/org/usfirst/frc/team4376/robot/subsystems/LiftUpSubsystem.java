package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team4376.robot.commands.LiftUpCommand;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftUpSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon liftMotor;
	//DoubleSolenoid shooterBrake;
	
	public LiftUpSubsystem() {
		CANTalon liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
	}
	
	public void robotUp(){
		liftMotor.set(0.375);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void portcullisUp(){
		liftMotor.set(.75);
	}
	
	public void powerDown(){
		liftMotor.set(-.5);
	}
	
	public void stopLiftUp(){
		liftMotor.set(0.0);
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void aimerThingy(){
		 liftMotor.set(Robot.oi.buttonStick.getRawAxis(1) * -0.55);	
	}
	
	public void robotDown(){
		liftMotor.set(-0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftUpCommand());
    }
}

