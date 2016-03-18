package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;


/**
 *
 */
public class TapeMeasureSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor tapeMotor = new Victor(RobotMap.TAPE_MEASURE_MOTOR);
	//DoubleSolenoid shooterBrake;
	DoubleSolenoid tapeBrake;
	
	public TapeMeasureSubsystem() {
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		tapeBrake = new DoubleSolenoid(RobotMap.LOCK_TAPE_MEASURE_FORWARD_SOLENOID, RobotMap.LOCK_TAPE_MEASURE_REVERSE_SOLENOID);


	}
	
	public void tapeExtend(){
		tapeMotor.set(0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void tapeStop(){
		tapeMotor.set(0.0);
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	public void lockTape(){
		tapeBrake.set(DoubleSolenoid.Value.kForward);
	}
	public void unlockTape(){
 		tapeBrake.set(DoubleSolenoid.Value.kReverse);
 	}
	
	public void tapeRetract(){
		tapeMotor.set(-0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}
	
	public void pitTapeRetract(){
		tapeMotor.set(-.25);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

