package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class PortcullisLifterSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid portcullisLifter;
	
	public PortcullisLifterSubsystem() {
		portcullisLifter = new DoubleSolenoid(RobotMap.LIFT_PORTCULLIS_FORWARD_SOLENOID, RobotMap.LIFT_PORTCULLIS_REVERSE_SOLENOID);
	}
	
	public void portcullisLifterOut(){
		portcullisLifter.set(DoubleSolenoid.Value.kReverse);
	}

	public void portcullisLifterIn(){
		portcullisLifter.set(DoubleSolenoid.Value.kForward);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

