package org.usfirst.frc.team4376.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;


	//USB Ports
	//public static int DRIVE_JOYSTICK = 0;
	public static int BUTTON_JOYSTICK = 2;
	public static int LEFT_DRIVE_JOYSTICK = 0;
	public static int RIGHT_DRIVE_JOYSTICK = 1;

	//PWM Ports
	public static int LEFT_DRIVE_MOTOR = 0;
	public static int RIGHT_DRIVE_MOTOR = 1;
	public static int TAPE_MEASURE_MOTOR = 2;

	//Talon SRX Ports
	public static int LIFT_MOTOR = 3;
	public static int LEFT_LAUNCH_MOTOR_SRX = 2;
	public static int RIGHT_LAUNCH_MOTOR_SRX = 4;

	//Solenoids
	public static int PUSH_BALL_FORWARD_SOLENOID = 7;
	public static int PUSH_BALL_REVERSE_SOLENOID = 6;
	public static int LIFT_PORTCULLIS_FORWARD_SOLENOID = 2;
	public static int LIFT_PORTCULLIS_REVERSE_SOLENOID = 3;
	public static int LOCK_SHOOTER_FORWARD_SOLENOID = 4;
	public static int LOCK_SHOOTER_REVERSE_SOLENOID = 5;

}
