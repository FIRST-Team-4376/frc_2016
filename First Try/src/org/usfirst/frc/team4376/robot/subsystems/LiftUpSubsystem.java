package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LiftUpSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
	Encoder liftAngleEncoder;
	//DoubleSolenoid shooterBrake;
	
	public LiftUpSubsystem() {
		liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
		liftAngleEncoder = new Encoder(RobotMap.LIFT_ANGLE_ENCODER_A, RobotMap.LIFT_ANGLE_ENCODER_B, true, Encoder.EncodingType.k1X);
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
	}
	
	public void robotUp(){
		int currentEncoderValue = liftAngleEncoder.get();
		while (liftAngleEncoder.get() < currentEncoderValue + 5) { //TODO: I just picked 5 randomly...change accordingly
		  liftMotor.set(0.7);  //original value was 0.375
		}
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void portcullisUp(){
		liftMotor.set(.75);
	}
	
	public void stopLiftUp(){
		liftMotor.set(0.0);
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void robotDown(){
		int currentEncoderValue = liftAngleEncoder.get();
		while (liftAngleEncoder.get() > currentEncoderValue - 5) { //TODO: I just picked 5 randomly...change accordingly
		  liftMotor.set(-0.7);  //original value was -0.375
		}
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

