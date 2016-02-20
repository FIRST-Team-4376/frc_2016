package org.usfirst.frc.team4376.robot.subsystems;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4376.robot.RobotMap;


/**
 *
 */
public class LiftUpSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX liftMotor;
	
	public LiftUpSubsystem() {
		liftMotor = new TalonSRX(RobotMap.LIFT_MOTOR);
	}
	
	public void robotUp(){
		liftMotor.set(0.5);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

