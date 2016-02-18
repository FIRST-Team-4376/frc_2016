package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LauncherSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	TalonSRX leftLaunchMotor;
	TalonSRX rightLaunchMotor;
	DoubleSolenoid pusher;
	
	public LauncherSubsystem() {
		//liftMotor = new TalonSRX(RobotMap.LIFT_MOTOR);
		pusher = new DoubleSolenoid(1, 2);
		leftLaunchMotor = new TalonSRX(RobotMap.LEFT_LAUNCH_MOTOR_SRX);
		rightLaunchMotor = new TalonSRX(RobotMap.RIGHT_LAUNCH_MOTOR_SRX);
	}
	
	
	//public void robotUp(){
		//liftMotor.set(0.5);
	//}

	public void launchBall(){
		leftLaunchMotor.set(.5);
		rightLaunchMotor.set(.5);
		pusher.set(DoubleSolenoid.Value.kForward);
	}
	
	public void resetPusher(){
		leftLaunchMotor.set(0.0);
		rightLaunchMotor.set(0.0);
		pusher.set(DoubleSolenoid.Value.kReverse);
	    pusher.set(DoubleSolenoid.Value.kOff); 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

