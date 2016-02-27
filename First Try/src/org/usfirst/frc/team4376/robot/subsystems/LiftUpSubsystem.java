package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class LiftUpSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
	Encoder liftAngleEncoder = new Encoder(RobotMap.LIFT_ANGLE_ENCODER_A, RobotMap.LIFT_ANGLE_ENCODER_B);
	//DoubleSolenoid shooterBrake;
	
	public LiftUpSubsystem() {
		//liftMotor = new CANTalon(RobotMap.LIFT_MOTOR);
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
	}
	
	public void encoderStuff(){
		int count = liftAngleEncoder.get();
        int rawCount = liftAngleEncoder.getRaw();
        double distance = liftAngleEncoder.getDistance();
        double period = liftAngleEncoder.getPeriod();
        double rate = liftAngleEncoder.getRate();
        boolean direction = liftAngleEncoder.getDirection();
        boolean stopped = liftAngleEncoder.getStopped();

        SmartDashboard.putNumber("count", count);
        SmartDashboard.putNumber("rawCount", rawCount);
        SmartDashboard.putNumber("distance", distance);
        SmartDashboard.putNumber("period", period);
        SmartDashboard.putNumber("rate", rate);
        SmartDashboard.putBoolean("direction", direction);
        SmartDashboard.putBoolean("stopped", stopped);
	}
	
	public void robotUp(){
		liftMotor.set(0.375);
		System.out.println("robotUp is called");
		encoderStuff();
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stopLiftUp(){
		liftMotor.set(0.0);
		encoderStuff();
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void robotDown(){
		liftMotor.set(-0.375);
		encoderStuff();
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

