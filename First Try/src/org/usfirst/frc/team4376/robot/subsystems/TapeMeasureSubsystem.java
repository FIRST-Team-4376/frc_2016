package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;
import org.usfirst.frc.team4376.robot.Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4376.robot.commands.TapeExtendCommand;


/**
 *
 */
public class TapeMeasureSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor tapeMotor = new Victor(RobotMap.TAPE_MEASURE_MOTOR);
	//DoubleSolenoid shooterBrake;
	
	public TapeMeasureSubsystem() {
		//shooterBrake = new DoubleSolenoid(RobotMap.LOCK_SHOOTER_FORWARD_SOLENOID, RobotMap.LOCK_SHOOTER_REVERSE_SOLENOID);
		
	}
	
	public void tapeExtend(){
		tapeMotor.set(0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void tapeStop(){
		tapeMotor.set(0.0);
		//shooterBrake.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void tapeRetract(){
		tapeMotor.set(-0.5);
		//shooterBrake.set(DoubleSolenoid.Value.kForward);
		//shooterBrake.set(DoubleSolenoid.Value.kOff);
	}
	
	public void tapeJoystick(){
		tapeMotor.set(Robot.oi.buttonStick.getRawAxis(3) * -1.5);
	}
	
	public void pitTapeRetract(){
		tapeMotor.set(-.25);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new TapeExtendCommand());
    }
}

