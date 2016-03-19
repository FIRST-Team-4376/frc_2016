package org.usfirst.frc.team4376.robot.subsystems;

import org.usfirst.frc.team4376.robot.Robot;
import org.usfirst.frc.team4376.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class LauncherSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	CANTalon leftLaunchMotor = new CANTalon(RobotMap.LEFT_LAUNCH_MOTOR_SRX);
	CANTalon rightLaunchMotor = new CANTalon(RobotMap.RIGHT_LAUNCH_MOTOR_SRX);
	DoubleSolenoid pusher;
	//private Timer timer;

	protected void initialize() {

		/*timer = new Timer();

		timer.reset();
		timer.start(); */
		}

	public LauncherSubsystem() {
		pusher = new DoubleSolenoid(RobotMap.PUSH_BALL_FORWARD_SOLENOID, RobotMap.PUSH_BALL_REVERSE_SOLENOID);
	}

	public void launchBall(){
		leftLaunchMotor.set(-1);
		rightLaunchMotor.set(1);
	}

	public void pushBall(){
		pusher.set(DoubleSolenoid.Value.kReverse);
	}

	public void stopLaunchBall(){
		leftLaunchMotor.set(0.0);
		rightLaunchMotor.set(0.0);
	}

	public void getBall(){
		leftLaunchMotor.set(.4);
		rightLaunchMotor.set(-.4);
	}

	protected boolean isFinished() {

		 leftLaunchMotor.set(0.0);
		 rightLaunchMotor.set(0.0);

		 return Robot.oi.buttonStick.getRawButton(6);

	    }

	public void resetPusher(){
		pusher.set(DoubleSolenoid.Value.kForward);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
